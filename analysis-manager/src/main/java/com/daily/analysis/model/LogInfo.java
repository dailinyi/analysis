package com.daily.analysis.model;

/**
 * Created by dailinyi on 15/5/24.
 */
public class LogInfo {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LogInfo(String content) {
        this.content = content;
    }

    public LogInfo() {
    }


    @Override
    public String toString() {
        return "LogInfo{" +
                "content='" + content + '\'' +
                '}';
    }
}
