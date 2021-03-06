package com.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @ClassName YamlModel
 * @Description 测试 Application.yml 配置，使用属性绑定到 javaBean（setter 方式）
 * @Author ceaome
 * @Date 2020/9/21
 **/
@Component
@ConfigurationProperties("person")
@Validated
public class YamlPropertiesBindModel {
    private String name;
    @Max(value = 100,message = "绑定失败，年龄不能超过100岁")
    private int age;
    private double height;
    private Date birth;
    private List<String> girlFriend;
    private Set<String> boyFriend;
    private Son son;

    public Set<String> getBoyFriend() {
        return boyFriend;
    }

    public void setBoyFriend(Set<String> boyFriend) {
        this.boyFriend = boyFriend;
    }

    public Son getSon() {
        return son;
    }

    public void setSon(Son son) {
        this.son = son;
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

    public List<String> getGirlFriend() {
        return girlFriend;
    }

    public void setGirlFriend(List<String> girlFriend) {
        this.girlFriend = girlFriend;
    }


    @Override
    public String toString() {
        return "YamlPropertiesBindModel{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", birth=" + birth +
                ", girlFriend=" + girlFriend +
                ", boyFriend=" + boyFriend +
                ", son=" + son +
                '}';
    }
}
