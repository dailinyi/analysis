package com.daily.analysis.exception;

import java.io.IOException;

/**
 * Created by dailinyi on 15/5/23.
 */
public class CommandErrorException extends IOException {
    public CommandErrorException() {
        super("输入命令错误");
    }
    public CommandErrorException(String msg) {
        super("输入命令错误,返回结果:"+msg);
    }
}
