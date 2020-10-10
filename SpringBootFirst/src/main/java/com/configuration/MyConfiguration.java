package com.configuration;

import com.model.YamlConstructorBindModel;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MyConfiguration
 * @Description 配置类
 * @Author ceaome
 * @Date 2020/9/21
 **/
@Configuration(proxyBeanMethods=false)
@EnableConfigurationProperties({YamlConstructorBindModel.class})
public class MyConfiguration {


}
