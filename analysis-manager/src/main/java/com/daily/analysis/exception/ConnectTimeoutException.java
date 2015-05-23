package com.daily.analysis.exception;

import java.io.IOException;

/**
 * Created by dailinyi on 15/5/23.
 */
public class ConnectTimeoutException extends IOException {
    public ConnectTimeoutException() {
        super("连接服务器超时,请检查...");
    }
}
