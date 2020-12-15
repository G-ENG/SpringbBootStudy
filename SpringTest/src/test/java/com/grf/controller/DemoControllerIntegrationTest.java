package com.grf.controller;

import com.alibaba.fastjson.JSONObject;
import com.grf.service.DemoService;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * SpringBootTest.WebEnvironment.RANDOM_PORT will start a full running server
 *
 *
 *   MockMvc 在 none环境下无法使用;
 *   MockBean 在 none环境下正尝试用
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class DemoControllerIntegrationTest {

    @SpringBootApplication
    static class InnerApplicationConfig{
    }

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    DemoService demoService;

    @Test
    public void testMockBeanValid(){
        BDDMockito.given(this.demoService.doGet()).willReturn("aReturn");
        System.out.println(demoService.doGet());
    }

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
    }

    @Test
    public void testGetWithParam() throws Exception {
        mockMvc.perform(get("/testGetWithParam")
                .param("aParam", "hello")
                .header("token", 123456)
                .contentType(MediaType.ALL))
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=UTF-8"))
                .andDo(print());
    }

    @Ignore("not ready yet")
    @Test
    void testPost() {
    }

    @Test
    public void testPostJsonParam() throws Exception {
        JSONObject requestContent = new JSONObject();
        requestContent.put("aJsonParam", "aParamValue");
        mockMvc.perform(//构造一个post请求
                post("/testPostJsonParam")
                        //json类型
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        //使用writeValueAsString()方法来获取对象的JSON字符串表示
                        .content(requestContent.toString())
                        .param("aJsonParam", "12313"))//无效：应该在content中
                //andExpect，添加ResultMathcers验证规则，验证控制器执行完成后结果是否正确，【这是一个断言】
                .andExpect(status().is(200))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("aJsonParam").value("aParamValue"))
                .andDo(print())
                .andReturn();
    }
}

