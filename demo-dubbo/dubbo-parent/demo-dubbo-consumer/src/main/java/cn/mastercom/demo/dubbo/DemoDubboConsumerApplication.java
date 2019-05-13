package cn.mastercom.demo.dubbo;

import cn.mastercom.demo.dubbo.service.StudentService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoDubboConsumerApplication {

    @Reference()
    private StudentService demoService;

    public static void main(String[] args) {
        SpringApplication.run(DemoDubboConsumerApplication.class, args);
    }

}
