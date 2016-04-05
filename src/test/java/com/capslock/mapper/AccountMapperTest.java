package com.capslock.mapper;

import com.capslock.domain.Account;
import org.junit.Test;

/**
 * Created by capslock.
 */
public class AccountMapperTest {
    @Test
    public void testMapAccountToAccountId() {
        final long id = 1L;
        final String name = "NAME";
        final String email = "EMAIL";
        final Account account = new Account();
        account.setId(id);
        account.setEmail(email);
        account.setName(name);
    }

}