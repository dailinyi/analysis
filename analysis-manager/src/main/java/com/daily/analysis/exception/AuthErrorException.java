package com.daily.analysis.exception;

import java.io.IOException;

/**
 * Created by dailinyi on 15/5/23.
 */
public class AuthErrorException extends IOException {
    public AuthErrorException() {
        super("由于用户名密码不匹配,服务器登录失败");
    }
}
