package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptContoller_Consumer {


    private static final String REST_URL_PREFIX="http://MICROSERVICECLOUD-DEPT";
 //   private static final String REST_URL_PREFIX="http://localhost:8001";
    @Autowired

    private RestTemplate restTemplate;



    @RequestMapping(value = "/consumer/dept/add")

    public boolean add( Dept dept){

        //三个参数：url,requestMap,ResponseBean.class代表rest请求地址，请求参数，HTTP响应对象类型

        return  restTemplate.postForObject(

                REST_URL_PREFIX+"/dept/add",

                dept,

                Boolean.class);

    }



    @RequestMapping("/consumer/dept/get/{id}")

    public Dept get(@PathVariable("id") Long id){

        //三个参数：url,requestMap ResponseBean.class

        return  restTemplate.getForObject(

                REST_URL_PREFIX+"/dept/get/"+id,

                Dept.class);

    }

    @RequestMapping("/consumer/dept/list")

    public List<Dept> list(){

        //三个参数：url,requestMap ResponseBean.class

        return  restTemplate.getForObject(

                REST_URL_PREFIX+"/dept/list",

                List.class);

    }



    @RequestMapping(value = "/consumer/dept/discovery")

    public Object discovery(){

        return  restTemplate.getForObject(

                REST_URL_PREFIX+"/dept/discovery",

                Object.class);

    }
}
