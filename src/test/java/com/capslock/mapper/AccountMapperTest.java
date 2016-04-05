package com.capslock.mapper;

import com.capslock.domain.Account;
import com.capslock.dto.AccountIdDto;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

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

        final AccountIdDto dto = AccountMapper.accountToAccountId(account);
        assertThat(dto.getId()).isEqualTo(id);
    }

}