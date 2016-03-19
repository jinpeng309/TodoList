package com.capslock.api.support;

/**
 * Created by capslock.
 */
public final class SuccessResult extends Result {
    private final static String SUCCESS_MESSAGE = "success";

    private SuccessResult() {
        super(ResultCode.SUCCESS.getValue(), SUCCESS_MESSAGE);
        //no instance
    }

    public static final SuccessResult singleton = new SuccessResult();
}
