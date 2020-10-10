package com.grf;

import com.model.YamlConstructorBindModel;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 *
 * SpringTest 默认不启动服务器 ， 如果想则一般使用 webEnvironment = WebEnvironment.RANDOM_PORT
 * Detecting Test Configuration 可不指定 classes=XXApplication.class
 *
 * @Author ceaome
 * @Date 2020/10/10
 **/
@SpringBootTest
class SimpleTest {
    private static final Logger LOG = LoggerFactory.getLogger(SimpleTest.class);

    @Autowired
    YamlConstructorBindModel yamlConstructorBindModel;

    @Test
    void testDemo() {
        assertNotNull(yamlConstructorBindModel);
        LOG.info(yamlConstructorBindModel.toString());
    }
}
