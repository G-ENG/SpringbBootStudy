package com.aop.controller;

import com.aop.bean.User;
import com.aop.log.HelloLog;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @Author GenG
 * @Date 2020/11/23
 **/
@Service
public class HelloService {

    @HelloLog(desc = "我是一段描述")
    public void someMethod(User user){
    }
}
