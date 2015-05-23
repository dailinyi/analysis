package com.daily.analysis.utils;

import com.daily.analysis.model.Result;

/**
 * Created by Daily on 2015/5/23.
 */
public class ResultUtils {
    public static final int SUCCESS_CODE = 0;
    public static final int FAIL_CODE = 1;

    public static Result successResult(){
        return new Result(SUCCESS_CODE);
    }
    public static Result failResult(String failMessage){
        return new Result(FAIL_CODE,failMessage);
    }

}
