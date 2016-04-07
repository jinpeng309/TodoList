package com.capslock.mapper;

import com.capslock.domain.User;
import com.capslock.dto.UserIdDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by capslock.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MapperConfig.class})
public class UserMapperTest {
    @Autowired
    private ModelMapper modelMapper;

    public void setModelMapper(final ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Test
    public void testMapAccountToAccountId() {
        final long id = 1L;
        final String name = "NAME";
        final String email = "EMAIL";
        final User user = new User();
        user.setId(id);
        user.setEmail(email);
        user.setName(name);

        final UserMapper userMapper = new UserMapper();
        userMapper.setMapper(modelMapper);
        final UserIdDto dto = userMapper.accountToAccountId(user);
        assertThat(dto.getId()).isEqualTo(id);
    }

}