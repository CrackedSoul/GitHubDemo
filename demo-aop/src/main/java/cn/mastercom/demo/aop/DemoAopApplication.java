package cn.mastercom.demo.aop;

import cn.mastercom.demo.aop.service.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoAopApplication implements CommandLineRunner {
    @Autowired
    private DateService dateService;

    public static void main(String[] args) {
        SpringApplication.run(DemoAopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        this.dateService.getDate();
        this.dateService.newDate();
    }
}
