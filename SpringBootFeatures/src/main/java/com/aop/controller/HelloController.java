package com.aop.controller;

/**
 * TODO
 *
 * @Author GenG
 * @Date 2020/11/23
 **/

import com.aop.bean.User;
import com.aop.log.HelloLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {


    private final Class<User> userClass = User.class;
    @Autowired
    HelloService helloService;
    @GetMapping("/aop/{word}")
    @ResponseBody
    public String testLog(@PathVariable String word) throws InterruptedException {

        User user = new User();
        user.setName("grf");
        user.setAge("123");
        helloService.someMethod(user);
        return "hello" + word;
    }


}
