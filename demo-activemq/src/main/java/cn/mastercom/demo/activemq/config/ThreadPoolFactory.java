package cn.mastercom.demo.activemq.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ThreadPoolFactory {
    @Autowired
     private Map<String , ThreadPoolTaskExecutor> threadPoolMap;

    public ThreadPoolTaskExecutor getByName(String name){
        return threadPoolMap.get(name);
    }
}
