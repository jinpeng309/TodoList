package com.capslock.repository;

import com.capslock.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by capslock.
 */
public interface UserDao extends CrudRepository<User, Long> {
    User findByEmail(final String email);
    User findByEmailAndHashPassword(final String email, final String hashPassword);
}
