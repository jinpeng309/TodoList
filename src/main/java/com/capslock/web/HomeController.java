package com.capslock.web;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by capslock.
 */
@Controller
public class HomeController {
    @Data
    private static class Info {
        private final String info;
    }

    @RequestMapping("/")
    @ResponseBody
    public Info home() {
        return new Info("welcome");
    }
}
