package com.capslock;

import com.capslock.api.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TodoListApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class TodoListApplicationTests {
    @Value("${local.server.port}")
    int port;

    @Test
    public void testRegister() {
        final String email = "EMAIL";
        final String password = "PASSWORD";
        final String name = "NAME";

        final UserController userController = new UserController();
        userController.register(email, password, name);
    }

}
