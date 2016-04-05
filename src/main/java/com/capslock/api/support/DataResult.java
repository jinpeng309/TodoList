package com.capslock.api.support;

import lombok.Data;

/**
 * Created by capslock.
 */
@Data
public class DataResult<T> extends Result {
    private final T data;

    public DataResult(final T data) {
        super(ResultCode.SUCCESS.getValue(), "");
        this.data = data;
    }
}
