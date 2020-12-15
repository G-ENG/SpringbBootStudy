package com.dozer;

import org.dozer.Mapping;

/**
 * TODO
 *
 * @Author GenG
 * @Date 2020/12/2
 **/
public class TargetBean {
    @Mapping("name")
    private String myName;
    @Mapping("name")
    private String name;
    private long myAge;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public long getMyAge() {
        return myAge;
    }

    public void setMyAge(long myAge) {
        this.myAge = myAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
