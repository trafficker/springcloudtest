package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

@Autowired
private DeptService service;

@Autowired
private DiscoveryClient client;

@RequestMapping(value = "/dept/add",method= RequestMethod.POST)
public boolean add(@RequestBody Dept dept){
    return service.add(dept);
}

@RequestMapping(value = "/dept/get/{id}",method= RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id){
        return service.get(id);
    }

@RequestMapping(value = "/dept/list",method= RequestMethod.GET)
    public List<Dept> list(){
        return service.list();
    }



    @RequestMapping(value = "/dept/discovery",method = RequestMethod.GET)

    public Object discovery(){

        List<String> list = client.getServices();

        System.out.println("总共有多少个微服务"+list.size());



        //查询STUDY-SPRINGCLOUD-DEPT 服务

        List<ServiceInstance> instances = client.getInstances("STUDY-SPRINGCLOUD-DEPT");



        //打印STUDY-SPRINGCLOUD-DEPT服务信息

        for (ServiceInstance element :instances){

            System.out.println(element.getServiceId());

            System.out.println(element.getHost());

            System.out.println(element.getPort());

            System.out.println(element.getUri());

        }

        return this.client;

    }
}
