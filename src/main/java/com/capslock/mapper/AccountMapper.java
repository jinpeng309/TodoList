package com.capslock.mapper;

import com.capslock.domain.Account;
import com.capslock.dto.AccountIdDto;
import org.modelmapper.ModelMapper;

/**
 * Created by capslock.
 */
public final class AccountMapper {
    AccountIdDto accountToAccountId(final Account account) {
        return new ModelMapper().map(account, AccountIdDto.class);
    }
}
