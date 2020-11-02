package com.grf.service;

import org.springframework.stereotype.Service;

/**
 * demoService
 *
 * @Author GenG
 * @Date 2020/10/28
 **/
@Service
public class DemoService {
    public String doGet(){
        //todo doSomething
        return null;
    }

    public String doPost(String aParam){
        return aParam;
    }

    public Object doSomething(){
        return null;
    }
}
