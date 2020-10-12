package com.model;

import java.util.Date;

/**
 *
 * @Author ceaome
 * @Date 2020/10/12
 **/
public class YamlBean {
    private String name;
    private int age;
    private double height;
    private Date birth;

    @Override
    public String toString() {
        return "YamlBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", birth=" + birth +
                '}';
    }

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

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
