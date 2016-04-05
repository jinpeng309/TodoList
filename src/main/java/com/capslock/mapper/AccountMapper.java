package com.capslock.mapper;

import com.capslock.domain.Account;
import com.capslock.dto.AccountIdDto;

/**
 * Created by capslock.
 */
public final class AccountMapper extends AbstractDtoMapper {
    public static AccountIdDto accountToAccountId(final Account account) {
        return getSingleton().map(account, AccountIdDto.class);
    }
}
