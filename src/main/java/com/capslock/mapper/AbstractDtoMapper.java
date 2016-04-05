package com.capslock.mapper;

import org.modelmapper.ModelMapper;

/**
 * Created by capslock.
 */
public abstract class AbstractDtoMapper {
    private final static ModelMapper SINGLETON = new ModelMapper();

    public static ModelMapper getSingleton() {
        return SINGLETON;
    }
}
