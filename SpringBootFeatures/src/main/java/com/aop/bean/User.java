package com.aop.bean;

import com.aop.log.LogParam1;

/**
 * TODO
 *
 * @Author GenG
 * @Date 2020/11/23
 **/
public class User {
    @LogParam1(type = LogParam1.TypeEnum.ADD)
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
