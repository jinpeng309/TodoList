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
            System.out.println(accountDao.findByEmail(email));
            throw new ServerException(ResultCode.BAD_REQUEST, "Email already registered");
        }

        final Account account = new Account();
        account.setName(name);
        account.setEmail(email);
        account.setHashPassword(hashPassword(passWord));

        return accountDao.save(account);
    }

    public void login(final String email, final String passWord) {
    }

    private static String hashPassword(final String password) {
        return Base64Utils.encodeToString(DigestUtils.md5Digest(password.getBytes()));
    }
}
