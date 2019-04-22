package cn.mastercom.demo.activemq.topic;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class TopicConsumer {
	@Async
	public void consume(String msg) {
		System.out.println(Thread.currentThread().getName()+"线程：----收到Topic消息，开始异步处理----");
		System.out.println(msg);
		System.out.println(Thread.currentThread().getName()+"线程：----收到Topic消息，结束异步处理----");
	}
}
