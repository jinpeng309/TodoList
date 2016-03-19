package com.capslock.api.support;

/**
 * Created by capslock.
 */
public enum ResultCode {
    SUCCESS(200), BAD_REQUEST(400), UNAUTHORIZED(401), FORBIDDEN(403), INTERNAL_SERVER_ERROR(500);
    private final int value;

    ResultCode(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ResultCode from(final int code) {
        for (final ResultCode resultCode : values()) {
            if (resultCode.getValue() == code) {
                return resultCode;
            }
        }
        return BAD_REQUEST;
    }
}
