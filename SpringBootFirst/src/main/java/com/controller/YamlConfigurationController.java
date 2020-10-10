package com.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.model.YamlConstructorBindModel;
import com.model.YamlPropertiesBindModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName YamlConfigurationController
 * @Author ceaome
 * @Date 2020/9/21
 **/
@RestController
public class YamlConfigurationController {
    // private static final Logger LOG = LoggerFactory.getLogger(YamlConfigurationController.class);

    @Autowired
    YamlPropertiesBindModel yamlPropertiesBindModel;

    @Autowired
    YamlConstructorBindModel yamlConstructorBindModel;

    @GetMapping("yamlConfiguration")
    public JSON testYamlConfiguration() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("YamlPropertiesBindModel", yamlPropertiesBindModel);
        jsonObject.put("YamlConstructorBindModel", yamlConstructorBindModel);
        return jsonObject;
    }
}
