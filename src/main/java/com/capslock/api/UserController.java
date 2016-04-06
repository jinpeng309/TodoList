package com.capslock.api;

import com.capslock.api.error.ServerException;
import com.capslock.api.support.DataResult;
import com.capslock.api.support.Result;
import com.capslock.api.support.ResultCode;
import com.capslock.domain.User;
import com.capslock.dto.UserIdDto;
import com.capslock.mapper.UserMapper;
import com.capslock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by capslock.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/register")
    public Result register(@RequestParam("email") String email, @RequestParam("password") String password,
            @RequestParam("name") String name) {
        if (email.isEmpty() || password.isEmpty() || name.isEmpty()) {
            throw new ServerException(ResultCode.BAD_REQUEST, "name or email or password empty");
        }

        final User user = userService.register(name, email, password);
        final UserIdDto userIdDto = userMapper.accountToAccountId(user);
        return new DataResult<>(userIdDto);
    }

    @RequestMapping(value = "/login")
    public Result login(@RequestParam("email") String email, @RequestParam("password") String password) {
        if (email.isEmpty() || password.isEmpty()) {
            throw new ServerException(ResultCode.BAD_REQUEST, "name or email or password empty");
        }
        final long uid = userService.login(email, password);
        final UserIdDto userIdDto = new UserIdDto();
        userIdDto.setId(uid);
        return new DataResult<>(userIdDto);
    }
}
