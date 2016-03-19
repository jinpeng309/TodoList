package com.capslock.api.error;

import com.capslock.api.support.ResultCode;
import lombok.Getter;

/**
 * Created by capslock.
 */
public class ServerException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    @Getter
    private final ResultCode resultCode;

    public ServerException(final ResultCode resultCode, final String message) {
        super(message);
        this.resultCode = resultCode;
    }
}
