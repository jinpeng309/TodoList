package com.capslock.mapper;

import com.capslock.domain.Account;
import com.capslock.dto.AccountIdDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by capslock.
 */
@Component
public final class AccountMapper {
    @Autowired
    private ModelMapper mapper;

    public AccountIdDto accountToAccountId(final Account account) {
        return mapper.map(account, AccountIdDto.class);
    }
}
