package com.atguigu.springcloud.cfgbeans;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){

        return new RestTemplate();

    }

//
//    更改的负载均衡方法，默认是轮询的，也可用自定义的

//    @Bean
//    public IRule myRule(){
//        return new RandomRule(); //使用随机算法替代默认的轮询
//        //return new RetryRule();
//    }


}
