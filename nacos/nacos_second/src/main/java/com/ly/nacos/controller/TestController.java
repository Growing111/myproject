package com.ly.nacos.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/****
 *
 *  通过RestTemplate进行服务调用
 *
 */
@RestController
public class TestController {

    @Resource
    private RestTemplate restTemplate;


    @RequestMapping(value = "/test")
    @SentinelResource(value = "test",
            fallback = "getFallback")
    public String getProviderInfo() {

        return restTemplate.getForObject("http://nacos-first-provice/user/", String.class);
    }

    public String getFallback(Throwable t) {
        return "请求限制了";
    }
}
