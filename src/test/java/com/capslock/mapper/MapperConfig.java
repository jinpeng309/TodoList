package com.capslock.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by capslock.
 */
@Configuration
public class MapperConfig {

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
