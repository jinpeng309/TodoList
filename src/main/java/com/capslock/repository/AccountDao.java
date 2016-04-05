package com.capslock.repository;

import com.capslock.domain.Account;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by capslock.
 */
public interface AccountDao extends CrudRepository<Account, Long> {
    Account findByEmail(final String email);
    Account findByEmailAndHashPassword(final String email, final String hashPassword);
}
