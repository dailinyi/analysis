package com.daily.analysis.service;

import com.daily.analysis.model.pojo.AnaConfig;

import java.io.IOException;

/**
 * Created by dailinyi on 15/5/23.
 */
public interface CommandService {
    /**
     * 实用命令行获取获取snort.conf接口
     * AnaConfig 是从服务器读取的配置
     * @return
     */
    public String getSnortConfig(AnaConfig config) throws IOException;
}
