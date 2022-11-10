package com.example.global_exception_demo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GlobalExceptionDemoApplicationTests {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeAll
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    void test1() throws Exception {
        //构造请求
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/test1")
                .param("id", "0");
        //模拟http请求
        MvcResult mvcResult = mockMvc.perform(request)
                //打印
                .andDo(MockMvcResultHandlers.print())
                //返回结果
                .andReturn();
        //响应
        MockHttpServletResponse response = mvcResult.getResponse();
        //断言http 状态码
        assert response.getStatus() == 400;
        //断言响应内容
        assert response.getContentAsString().equals("ParameterException: message = invalid id, url = /test1");
        System.out.println("done!");
    }

    @Test
    void test2() throws Exception {
        //构造请求
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/test2");
        //模拟http请求
        MvcResult mvcResult = mockMvc.perform(request)
                //打印
                .andDo(MockMvcResultHandlers.print())
                //返回结果
                .andReturn();
        //响应
        MockHttpServletResponse response = mvcResult.getResponse();
        //断言http 状态码
        assert response.getStatus() == 500;
        //断言响应内容
        assert response.getContentAsString().equals("Internal Server Error");
        System.out.println("done!");
    }

    @Test
    void test3() throws Exception {
        //构造请求
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/test3");
        //模拟http请求
        MvcResult mvcResult = mockMvc.perform(request)
                //打印
                .andDo(MockMvcResultHandlers.print())
                //返回结果
                .andReturn();
        //响应
        MockHttpServletResponse response = mvcResult.getResponse();
        //断言http 状态码
        assert response.getStatus() == 500;
        //断言响应内容
        assert response.getContentAsString().equals("Internal Server Error");
        System.out.println("done!");
    }

}
