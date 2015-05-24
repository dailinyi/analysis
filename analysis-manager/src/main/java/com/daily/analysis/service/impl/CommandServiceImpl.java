package com.daily.analysis.service.impl;

import com.daily.analysis.model.FileInfo;
import com.daily.analysis.model.LogInfo;
import com.daily.analysis.model.pojo.AnaConfig;
import com.daily.analysis.service.CommandService;
import com.daily.analysis.utils.PropertiesUtils;
import com.daily.analysis.utils.SSHUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by dailinyi on 15/5/23.
 */
@Service
public class CommandServiceImpl implements CommandService {

    protected static final String SNORT_CONF_URL = PropertiesUtils.getProperty("config.default.snort.conf");
    protected static final String TEMP_URL = PropertiesUtils.getProperty("config.tmp.url");
    protected static final String RULES_URL = PropertiesUtils.getProperty("config.default.rules.url");
    protected static final String GUARDIAN_CONF_URL = PropertiesUtils.getProperty("config.default.guardian.conf");
    protected static final String ALERT_URL = PropertiesUtils.getProperty("config.default.alert.url");
    protected static final Integer ALERT_LINE = Integer.valueOf(PropertiesUtils.getProperty("config.default.alert.line"));
    @Override
    public String getSnortConfig(AnaConfig config) throws IOException{
        if (StringUtils.isEmpty(config.getSnortConfUrl())){
            config.setSnortConfUrl(SNORT_CONF_URL);
        }

        StringBuilder command = new StringBuilder().append(" cat ")
                .append(config.getSnortConfUrl());

        return SSHUtils.exec(config,command.toString());
    }

    @Override
    public void mergeSnortConfig(AnaConfig config,String newConfig) throws IOException {
        if (StringUtils.isEmpty(config.getSnortConfUrl())){
            config.setSnortConfUrl(SNORT_CONF_URL);
        }
        if (StringUtils.isBlank(newConfig)){
            return;
        }

        String backFileName = "snort.conf." + new DateTime().toLocalDateTime();

        StringBuilder sb = new StringBuilder();

        //先将文件备份到另一位置
        sb.append(" mv ").append(config.getSnortConfUrl()).append(" ")
                .append(TEMP_URL).append("/snortConfBackup/").append(backFileName);

        //重写snort.conf
        sb.append(" && ");
        String[] splitCommand = newConfig.split("\\n");
        for (int i = 0 ; i<splitCommand.length;i++){
//            sb = new StringBuilder();
            sb.append(" echo ").append("'").append(splitCommand[i].replace("'","")).append("'")
                    .append(" >> ").append(config.getSnortConfUrl());


            if (i != splitCommand.length - 1){
                sb.append(" && ");
            }

        }
        SSHUtils.exec(config, sb.toString());
    }

    @Override
    public List<FileInfo> getRulesList(AnaConfig config) throws IOException {
        if (StringUtils.isEmpty(config.getSnortRuleUrl())){
            config.setSnortRuleUrl(RULES_URL);
        }

        StringBuilder command = new StringBuilder().append(" ls -lh ")
                .append(config.getSnortRuleUrl());

        String s = SSHUtils.exec(config,command.toString());

        List<String> lines = Arrays.asList(s.split("\\n"));
        List<FileInfo> result = new ArrayList<FileInfo>();
        for(String line : lines){
            result.add(FileInfo.covertToFile(line));
        }
        return result;
    }

    @Override
    public String getRulesInfo(AnaConfig config, String rulesName) throws IOException {
        if (StringUtils.isEmpty(config.getSnortRuleUrl())){
            config.setSnortRuleUrl(RULES_URL);
        }
        StringBuilder command = new StringBuilder().append(" cat ")
                .append(config.getSnortRuleUrl()).append("/").append(rulesName);

        String result = SSHUtils.exec(config, command.toString());

        return result;
    }

    @Override
    public String getGuardianConfig(AnaConfig config) throws IOException {

        if (StringUtils.isEmpty(config.getGuarduanConfUrl())){
            config.setGuarduanConfUrl(GUARDIAN_CONF_URL);
        }

        StringBuilder command = new StringBuilder().append(" cat ")
                .append(config.getGuarduanConfUrl());

        return SSHUtils.exec(config,command.toString());
    }

    @Override
    public List<LogInfo> getAlertList(AnaConfig config) throws IOException {
        if (config.getAlertDefaultLine() == null || config.getAlertDefaultLine() ==0){
            config.setAlertDefaultLine(ALERT_LINE);
        }
        if (StringUtils.isBlank(config.getAlertUrl())){
            config.setAlertUrl(ALERT_URL);
        }

        StringBuilder command = new StringBuilder().append(" cat ")
                .append(config.getAlertUrl()).append(" |tail -n ").append(config.getAlertDefaultLine());

        String result = SSHUtils.exec(config,command.toString());

        return splitAlertLogToLogInfoList(result);
    }

    @Override
    public void mergeRules(AnaConfig config, String ruleName, String content) throws IOException {
        if (StringUtils.isEmpty(config.getSnortRuleUrl())){
            config.setSnortConfUrl(RULES_URL);
        }
        if (StringUtils.isBlank(content)){
            return;
        }

        String backFileName = ruleName + "." + new DateTime().toLocalDateTime();

        StringBuilder sb = new StringBuilder();

        //先将文件备份到另一位置
        sb.append(" mv ").append(config.getSnortRuleUrl()).append("/").append(ruleName).append(" ")
                .append(TEMP_URL).append("/rulesBackup/").append(backFileName);

        //重写ruleName
        sb.append(" && ");
        String[] splitCommand = content.split("\\n");
        for (int i = 0 ; i<splitCommand.length;i++){
            sb.append(" echo ").append("'").append(splitCommand[i].replace("'","")).append("'")
                    .append(" >> ").append(config.getSnortRuleUrl()).append("/").append(ruleName);


            if (i != splitCommand.length - 1){
                sb.append(" && ");
            }

        }
        SSHUtils.exec(config, sb.toString());
    }


    private List<LogInfo> splitAlertLogToLogInfoList(String result){

        List<LogInfo> logInfos = new ArrayList<LogInfo>();

        if (StringUtils.isBlank(result)){
            return logInfos;
        }

        String[] resultArr = result.split("\n");

        StringBuilder contentBuilder = new StringBuilder();


        for (String temp : resultArr) {
            //如果里面有值,则添加个\n
            if (StringUtils.isNotBlank(contentBuilder.toString())){
                contentBuilder.append("\n");
            }
            //将文本塞进去
            contentBuilder.append(temp);

            //如果返回是空,说明该换行了
            if (StringUtils.isBlank(temp)){
                logInfos.add(new LogInfo(contentBuilder.toString()+""));
                contentBuilder = new StringBuilder();
            }
        }
        logInfos.add(new LogInfo(contentBuilder.toString()+""));

        //反转输出
        Collections.reverse(logInfos);

        //可能最后一条消息是不完整的,删除最后一条消息
        logInfos.remove(logInfos.size()-1);

        return logInfos;
    }
}
