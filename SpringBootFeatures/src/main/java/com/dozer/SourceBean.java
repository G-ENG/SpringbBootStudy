package com.dozer;


import org.dozer.Mapping;

/**
 * TODO
 *
 * @Author GenG
 * @Date 2020/12/2
 **/
public class SourceBean {
    private String name;
    @Mapping("myAge")
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
