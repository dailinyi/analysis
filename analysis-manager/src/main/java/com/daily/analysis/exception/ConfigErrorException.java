package com.daily.analysis.exception;

/**
 * Created by dailinyi on 15/5/23.
 */
public class ConfigErrorException extends Exception{
    public ConfigErrorException() {
        super("服务器配置参数错误,请检查");
    }
}
