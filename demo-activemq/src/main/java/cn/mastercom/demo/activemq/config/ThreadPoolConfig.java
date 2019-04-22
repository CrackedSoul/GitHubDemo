package cn.mastercom.demo.activemq.config;

import java.util.concurrent.ThreadPoolExecutor;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

//@Configuration
//@EnableAsync
public class ThreadPoolConfig {

//	@Bean("taskExecutor")
	public ThreadPoolTaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(Runtime.getRuntime().availableProcessors() / 2);
		executor.setMaxPoolSize(Runtime.getRuntime().availableProcessors() * 2);
		executor.setQueueCapacity(100);
		executor.setKeepAliveSeconds(60);
		executor.setThreadNamePrefix("Spring Async Thread ");
		// 线程池对拒绝任务的处理策略
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		// 初始化
		executor.initialize();
		return executor;
	}
}
