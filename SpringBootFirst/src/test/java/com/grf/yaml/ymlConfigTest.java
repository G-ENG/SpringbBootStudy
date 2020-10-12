package com.grf.yaml;

import com.model.YamlBean;
import com.model.YamlConstructorBindModel;
import com.model.YamlPropertiesBindModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 *
 * @Author GenG
 * @Date 2020/10/12
 **/
@SpringBootTest
class ymlConfigTest {
    private static final Logger LOG = LoggerFactory.getLogger(ymlConfigTest.class);

    @Value("${oneYmlConfig:error}")
    String oneYmlConfig;

    @Value("${nonexistenceYmlConfig:error}")
    String nonexistenceYmlConfig;

    @Autowired
    YamlBean yamlBean;

    @Autowired
    YamlPropertiesBindModel yamlPropertiesBindModel;

    @Autowired
    YamlConstructorBindModel yamlConstructorBindModel;

    @Autowired
    ApplicationContext ctx;

    @Test
    void testYmlConfigValue(){
        Assertions.assertNotNull(oneYmlConfig);
        Assertions.assertNotNull(nonexistenceYmlConfig);
        LOG.info("使用@Value注解获取Spring的配置,获取的值为{}",oneYmlConfig);
        LOG.info("使用@Value注解获取Spring的配置,获取的值为{}",nonexistenceYmlConfig);
        Assertions.assertEquals("just a yaml config",oneYmlConfig);
        Assertions.assertEquals("error",nonexistenceYmlConfig);
    }

    @Test
    void testBeanAndConfigurationProperties(){
        Assertions.assertNotNull(ctx);
        Assertions.assertNotNull(yamlBean);
        Assertions.assertNotNull(ctx.getBean(YamlBean.class));
        LOG.info("yamlBean{}",yamlBean.toString());
        LOG.info("yamlBean{}",ctx.getBean(YamlBean.class).toString());
    }

    @Test
    void testYamlBindModel(){
        Assertions.assertNotNull(yamlPropertiesBindModel);
        Assertions.assertNotNull(yamlConstructorBindModel);
        LOG.info("yamlPropertiesBindModel:[{}]",yamlPropertiesBindModel);
        LOG.info("yamlConstructorBindModel:[{}]",yamlConstructorBindModel);
    }
}
