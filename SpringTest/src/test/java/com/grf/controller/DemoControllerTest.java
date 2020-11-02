package com.grf.controller;

import com.alibaba.fastjson.JSONObject;
import com.grf.service.DemoService;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DemoController.class)
public class DemoControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    DemoService demoService;

    @Test
    public void indexView() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/index"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("index"))
                .andDo(print())
                .andReturn();//可不加andReturn()
        //也可以使用断言判断
        Assert.assertNotNull(mvcResult.getModelAndView());
    }

    @Test
    public void testGet() throws Exception {

        mockMvc.perform(get("/testGet"))
                .andExpect(status().isOk());
        //测试doGet方法
        BDDMockito.verify(demoService).doGet();
        //验证方法调用指定次数
        BDDMockito.verify(demoService, times(1)).doGet();
        //验证只调用了某方法
        verify(demoService, only()).doGet();
        //验证方法在1ms之内完成
        verify(demoService, timeout(1)).doGet();

    }

    @Test
    public void testGetWithParam() throws Exception {
        BDDMockito.given(this.demoService.doGet()).willReturn("aReturn");
        mockMvc.perform(get("/testGetWithParam")
                .param("aParam", "hello")
                .header("token", 123456)
                .contentType(MediaType.ALL))
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=UTF-8"))
                .andDo(print());
        //验证按顺序执行一些方法
        InOrder inOrder = inOrder(demoService);
        inOrder.verify(demoService).doGet();
        inOrder.verify(demoService).doSomething();
    }

    @Ignore("not ready yet")
    @Test
    void testPost() {
    }

    @Test
    public void testPostJsonParam() throws Exception {
        JSONObject requestContent = new JSONObject();
        requestContent.put("aJsonParam", "aParamValue");
        JSONObject mockResponse = new JSONObject();
        mockResponse.put("code", "00000");
        mockResponse.put("message", "成功");
        mockResponse.put("data", "null");
        given(this.demoService.doPost(anyString())).willReturn(mockResponse.toString());
        assertEquals(mockResponse.toString(), this.demoService.doPost(""));
        mockMvc.perform(//构造一个post请求
                post("/testPostJsonParam")
                        //json类型
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        //使用writeValueAsString()方法来获取对象的JSON字符串表示
                        .content(requestContent.toString())
                        .param("aJsonParam", "12313"))
                //andExpect，添加ResultMathcers验证规则，验证控制器执行完成后结果是否正确，【这是一个断言】
                .andExpect(status().is(200))
                .andExpect(status().isOk())
                //使用jsonPath验证返回的json中code字段的返回值
                .andExpect(jsonPath("$.code").value("00000"))
                .andExpect(jsonPath("$.message").value("成功"))
                //body属性不为空
                .andExpect(jsonPath("$.data").isNotEmpty())
                //添加ResultHandler结果处理器，比如调试时 打印结果(print方法)到控制台
                .andDo(MockMvcResultHandlers.print())
                //返回相应的MvcResult
                .andReturn();
    }
}

