package com.capslock.api.support;

/**
 * Created by capslock.
 */
public class ErrorResult extends Result {
    public ErrorResult(final ResultCode code, final String message) {
        super(code.getValue(), message);
    }
}
