package com.daily.analysis.service.impl;

import com.daily.analysis.exception.ConfigErrorException;
import com.daily.analysis.model.mapper.AnaConfigMapper;
import com.daily.analysis.model.pojo.AnaConfig;
import com.daily.analysis.model.pojo.AnaConfigExample;
import com.daily.analysis.service.ConfigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dailinyi on 15/5/17.
 */
@Service
public class ConfigServiceImpl implements ConfigService {
    @Resource
    private AnaConfigMapper configMapper;


    @Override
    public AnaConfig getConfigByName(String serverName) throws ConfigErrorException{
        AnaConfigExample example = new AnaConfigExample();
        example.createCriteria().andServerNameEqualTo(serverName);
        List<AnaConfig> configs = configMapper.selectByExample(example);
        //如果数据库中配置数量不是1,则报错
        if (configs == null || configs.size() != 1){
            throw new ConfigErrorException();
        }
        return configs.get(0);
    }


}
