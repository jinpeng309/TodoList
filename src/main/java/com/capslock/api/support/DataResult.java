package com.capslock.api.support;

/**
 * Created by capslock.
 */
public class DataResult extends Result {
    public DataResult(final String message) {
        super(ResultCode.SUCCESS.getValue(), message);
    }
}
