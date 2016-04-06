package com.capslock.mapper;

import com.capslock.domain.User;
import com.capslock.dto.UserIdDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by capslock.
 */
@Component
public final class UserMapper {
    @Autowired
    private ModelMapper mapper;

    public UserIdDto accountToAccountId(final User user) {
        return mapper.map(user, UserIdDto.class);
    }
}