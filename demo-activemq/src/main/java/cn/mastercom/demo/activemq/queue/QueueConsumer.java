package cn.mastercom.demo.activemq.queue;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class QueueConsumer {
	@Async
	public void consume(String msg) {
		System.out.println(Thread.currentThread().getName()+"线程：----收到Queue消息，开始异步处理----");
		System.out.println(msg);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"线程：----收到Queue消息，结束异步处理----");
	}
}
