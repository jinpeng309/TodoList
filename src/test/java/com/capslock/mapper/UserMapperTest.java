package com.capslock.mapper;

import com.capslock.domain.User;
import com.capslock.dto.UserIdDto;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by capslock.
 */
public class UserMapperTest {
    @Test
    public void testMapAccountToAccountId() {
        final long id = 1L;
        final String name = "NAME";
        final String email = "EMAIL";
        final User user = new User();
        user.setId(id);
        user.setEmail(email);
        user.setName(name);

        final UserIdDto dto = new UserMapper().accountToAccountId(user);
        assertThat(dto.getId()).isEqualTo(id);
    }

}