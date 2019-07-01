package com.atguigu.springcloud.service;
import com.atguigu.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept get(Long id) {
                return new Dept(id, "none", "none无信息");
            }
            @Override
            public boolean add(Dept dept) {
                return false;
            }


            @Override
            public List<Dept> list() {
                return null;
            }
        };
    }
}
