package com.grf.controller;

import com.grf.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * demoController
 *
 * @Author GenG
 * @Date 2020/10/28
 **/
@Controller
public class DemoController {
    @Autowired
    DemoService demoService;

    @GetMapping("/index")
    public String indexView() {
        return "index";
    }

    @GetMapping("/testGet")
    @ResponseBody
    public String testGet() {
        return demoService.doGet();
    }

    @GetMapping("/testGetWithParam")
    @ResponseBody
    public Object testGetWithParam(String aParam) {
        demoService.doGet();
        demoService.doSomething();
        return aParam;
    }

    @PostMapping("testPost")
    public void testPost(String aParam){
        demoService.doPost(aParam);
    }

    @PostMapping("/testPostJsonParam")
    @ResponseBody
    public String testPostJsonParam(@RequestBody String aJsonParam){
        return demoService.doPost(aJsonParam);
    }
}
