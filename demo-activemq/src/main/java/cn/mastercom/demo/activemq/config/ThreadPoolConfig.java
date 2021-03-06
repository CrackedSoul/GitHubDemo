package cn.mastercom.demo.activemq.config;

import java.util.concurrent.ThreadPoolExecutor;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ThreadPoolConfig {

	@Bean("faSong")
	public ThreadPoolTaskExecutor threadPoolTaskExecutora() {
		return get("Fasong");
	}

	@Bean("jieShou")
	public ThreadPoolTaskExecutor threadPoolTaskExecutorb() {
		return get("Jieshou");
	}
	@Bean("taskExecutor1")
	public ThreadPoolTaskExecutor threadPoolTaskExecutorc() {
		return get("taskExecutor");
	}

	private ThreadPoolTaskExecutor get(String name){
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(Runtime.getRuntime().availableProcessors());
		executor.setMaxPoolSize(Runtime.getRuntime().availableProcessors() * 2);
		executor.setQueueCapacity(1000);
		executor.setKeepAliveSeconds(60);
		executor.setThreadNamePrefix("Spring Async Thread "+name);
		// 线程池对拒绝任务的处理策略
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		// 初始化
		executor.initialize();
		return executor;
	}
}
