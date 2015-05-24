package com.daily.analysis.test;

import com.daily.analysis.model.LogInfo;
import com.daily.analysis.utils.SSHUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by dailinyi on 15/5/24.
 */
public class AlertTest {
    @Test
    public void alertTest(){

        String s = "cat abcd.text |tail -n 100";
        try {
            String result = SSHUtils.exec("123.57.210.213", "root", "dayongfalw", s);
            System.out.println(result);
            String[] sar = result.split("\n");
//            List<String> out = new ArrayList<String>();
            List<LogInfo> out = new ArrayList<LogInfo>();
            StringBuilder sb = new StringBuilder();
            for (String temp : sar) {
                if (StringUtils.isNotBlank(sb.toString())){
                    sb.append("\n");
                }
                sb.append(temp);

                if (StringUtils.isBlank(temp)){
                    out.add(new LogInfo(sb.toString()+""));
                    sb = new StringBuilder();
                }
            }
            out.add(new LogInfo(sb.toString()+""));

            Collections.reverse(out);

            System.out.println("---------------out--------------");
            for(int i = 0 ;i<out.size();i++){
                System.out.println(i + "-----" + out.get(i));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
