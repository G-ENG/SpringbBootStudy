package com.grf;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @ClassName HelloWorldController
 * @Description hello world controller00
 * @Author ceaome
 * @Date 2020/8/31
 **/
@RestController
public class HelloWorldController {

    @GetMapping("/helloWorld")
    public String helloWorld(){
        return "he112312311llo 123123123121112323111/**/world!123123121";
    }

}
