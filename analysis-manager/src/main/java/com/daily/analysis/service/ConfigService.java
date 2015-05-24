package com.daily.analysis.service;


import com.daily.analysis.exception.ConfigErrorException;
import com.daily.analysis.model.pojo.AnaConfig;

import java.util.List;

/**
 * Created by dailinyi on 15/5/17.
 */
public interface ConfigService {

    /**
     * 通过服务器名获取服务器配置
     * @param serverName
     * @return
     * @throws ConfigErrorException 如果服务器配置信息为空,或者不等于一个,则报配置错误异常
     */
    public AnaConfig getConfigByName(String serverName) throws ConfigErrorException;
}
