package com.capslock.api.support;

import lombok.Data;

/**
 * Created by capslock.
 */
@Data
public abstract class Result {
    private final int code;
    private final String message;
}
