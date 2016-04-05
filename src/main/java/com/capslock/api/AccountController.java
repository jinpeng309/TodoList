package com.capslock.api;

import com.capslock.api.error.ServerException;
import com.capslock.api.support.DataResult;
import com.capslock.api.support.Result;
import com.capslock.api.support.ResultCode;
import com.capslock.domain.Account;
import com.capslock.dto.AccountIdDto;
import com.capslock.mapper.AccountMapper;
import com.capslock.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by capslock.
 */
@RestController
@RequestMapping(value = "/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountMapper accountMapper;

    @RequestMapping(value = "/register")
    public Result register(@RequestParam("email") String email, @RequestParam("password") String password,
            @RequestParam("name") String name) {
        if (email.isEmpty() || password.isEmpty() || name.isEmpty()) {
            throw new ServerException(ResultCode.BAD_REQUEST, "name or email or password empty");
        }

        final Account account = accountService.register(name, email, password);
        final AccountIdDto accountIdDto = accountMapper.accountToAccountId(account);
        return new DataResult<>(accountIdDto);
    }

    @RequestMapping(value = "/login")
    public Result login(@RequestParam("email") String email, @RequestParam("password") String password) {
        if (email.isEmpty() || password.isEmpty()) {
            throw new ServerException(ResultCode.BAD_REQUEST, "name or email or password empty");
        }
        final long uid = accountService.login(email, password);
        final AccountIdDto accountIdDto = new AccountIdDto();
        accountIdDto.setId(uid);
        return new DataResult<>(accountIdDto);
    }
}
