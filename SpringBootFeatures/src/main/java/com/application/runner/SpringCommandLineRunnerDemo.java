package com.application.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 *
 * @Author ceaome
 * @Date 2020/10/10
 **/
@Component
@Order(2)
public class SpringCommandLineRunnerDemo implements CommandLineRunner {
    private static final Logger LOG = LoggerFactory.getLogger(SpringCommandLineRunnerDemo.class);

    @Override
    public void run(String... args) throws Exception {
        LOG.info("--------SpringCommandLineRunnerDemo------------");
        Arrays.stream(args).forEach(LOG::info);
        doSomething();
        LOG.info("-----------------------------------------------");
    }
    private static void doSomething(){
        LOG.info("If you need to run some specific code once the SpringApplication has started, you can implement the ApplicationRunner or CommandLineRunner interfaces. Both interfaces work in the same way and offer a single run method, which is called just before SpringApplication.run(…\u200B) completes.");
    }
}
