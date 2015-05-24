package com.daily.analysis.model;

/**
 * Created by Daily on 2015/5/23.
 */
public class Result {


    private int status;
    private String errorMsg;
    private Object content;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Result result = (Result) o;

        if (status != result.status) return false;
        return !(errorMsg != null ? !errorMsg.equals(result.errorMsg) : result.errorMsg != null);

    }

    @Override
    public int hashCode() {
        int result = status;
        result = 31 * result + (errorMsg != null ? errorMsg.hashCode() : 0);
        return result;
    }

    public Result() {
    }

    public Result(int status, String errorMsg) {
        this.status = status;
        this.errorMsg = errorMsg;
    }

    public Result(int status) {
        this.status = status;
    }
}
