package com.capslock.service;

import com.capslock.api.error.ServerException;
import com.capslock.api.support.ResultCode;
import com.capslock.domain.Account;
import com.capslock.repository.AccountDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Base64Utils;
import org.springframework.util.DigestUtils;

import java.util.Optional;

/**
 * Created by capslock.
 */
@Service
public class AccountService {
    private final Logger logger = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    private AccountDao accountDao;

    @Transactional
    public Account register(final String name, final String email, final String passWord) {

        if (accountDao.findByEmail(email) != null) {
            throw new ServerException(ResultCode.BAD_REQUEST, "Email already registered");
        }

        final Account account = new Account();
        account.setName(name);
        account.setEmail(email);
        account.setHashPassword(hashPassword(passWord));

        return accountDao.save(account);
    }

    public long login(final String email, final String password) {
        final Optional<Account> account = Optional.ofNullable(accountDao.findByEmailAndHashPassword(email, password));
        logger.info(account.toString());
        return account
                .map(Account::getId)
                .orElseThrow(() -> new ServerException(ResultCode.BAD_REQUEST, "Invalid password or email"));

    }

    private static String hashPassword(final String password) {
        return Base64Utils.encodeToString(DigestUtils.md5Digest(password.getBytes()));
    }
}
