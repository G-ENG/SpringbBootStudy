package com.configuration;

import com.model.YamlBean;
import com.model.YamlConstructorBindModel;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 2.8.5 Third-party Configuration
 * As well as using @ConfigurationProperties to annotate a class, you can also use it on public @Bean methods. Doing so can be particularly useful when you want to bind properties to third-party components that are outside of your control.
 *
 * To configure a bean from the Environment properties, add @ConfigurationProperties to its bean registration, as shown in the following example:
 *
 *
 * @ClassName MyConfiguration
 * @Description 配置类
 * @Author ceaome
 * @Date 2020/9/21
 **/
@Configuration(proxyBeanMethods=false)
@EnableConfigurationProperties({YamlConstructorBindModel.class})
public class MyConfiguration {

    @Bean
    @ConfigurationProperties("person3")
    public YamlBean getYamlBean(){
        return new YamlBean();
    }

}
