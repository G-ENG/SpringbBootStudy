package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * SpringBootApplication
 *
 * @Author ceaome
 * @Date 2020/10/10
 **/
@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringBootFeaturesApplication {
    public static void main(String[] args) {
       SpringApplication.run(SpringBootFeaturesApplication.class);
    }
}
