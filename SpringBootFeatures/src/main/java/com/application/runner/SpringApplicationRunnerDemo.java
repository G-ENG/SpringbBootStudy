package com.application.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 *调用时机 {@link SpringApplication#run(String...)} callRunners
 * 注意 runners启动失败会影响 SpringApplication正常启动，可在 run方法中创建新线程启动 runner
 * @Author ceaome
 * @Date 2020/10/10
 **/
@Component
@Order(1)
public class SpringApplicationRunnerDemo implements ApplicationRunner {
    private static final Logger LOG = LoggerFactory.getLogger(SpringApplicationRunnerDemo.class);

    @Override
    public void run(ApplicationArguments args) {
  /*      new Thread(() -> {
            LOG.info("--------SpringApplicationRunnerDemo------------");
            args.getOptionNames().forEach(LOG::info);
            Arrays.stream(args.getSourceArgs()).forEach(LOG::info);
            doSomething();
            LOG.info("-----------------------------------------------");
        }).start();*/

        LOG.info("--------SpringApplicationRunnerDemo------------");
        args.getOptionNames().forEach(LOG::info);
        Arrays.stream(args.getSourceArgs()).forEach(LOG::info);
        doSomething();
        LOG.info("-----------------------------------------------");

    }

    private static void doSomething(){
        LOG.info("If you need to run some specific code once the SpringApplication has started, you can implement the ApplicationRunner or CommandLineRunner interfaces. Both interfaces work in the same way and offer a single run method, which is called just before SpringApplication.run(…\u200B) completes.");
    }
}
