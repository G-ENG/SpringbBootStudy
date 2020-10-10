package com.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * if no properties are bound to a property, the javaBean instance will contain a null value for this property
 * you can also use @DefaultValue with empty value to prevent from creating a null Object
 *
 * @ClassName YamlConstructorBindModel
 * @Description 测试 Application.yml 配置，使用属性绑定到 javaBean（setter 方式）
 * @Author ceaome
 * @Date 2020/9/21
 **/
@ConstructorBinding
@ConfigurationProperties("person2")
public class YamlConstructorBindModel {
    private String name;
    private int age;
    private double height;
    private Date birth;
    private List<String> girlFriend;
    private Set<String> boyFriend;
    private Son son;


    /**
     * 注解 @DefaultValue使用
     * 对于基本数据类型必须指定值 例如 @DefaultValue("11") double height
     * 对于引用数据类型 例如 Son son，
     * 1.加了 @DefaultValue后生成非空对象
     * "son": {
     * "name": null,
     * "sex": null
     * }
     * 2.不加 @DefaultValue后生成 null
     * "son": null
     */
    public YamlConstructorBindModel(@DefaultValue String name, int age, @DefaultValue("11") double height, @DefaultValue Date birth, List<String> girlFriend, Set<String> boyFriend, Son son) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.birth = birth;
        this.girlFriend = girlFriend;
        this.boyFriend = boyFriend;
        this.son = son;
    }

    @Override
    public String toString() {
        return "YamlConstructorBindModel{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", birth=" + birth +
                ", girlFriend=" + girlFriend +
                ", boyFriend=" + boyFriend +
                ", son=" + son +
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

    public List<String> getGirlFriend() {
        return girlFriend;
    }

    public void setGirlFriend(List<String> girlFriend) {
        this.girlFriend = girlFriend;
    }

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
}
