package cn.mastercom.demo.activemq.msgProcess;

import javax.jms.Queue;
import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MessageSend {
	private Queue queue;
	private Topic topic;
	private JmsMessagingTemplate jmsMessagingTemplate;

	@Autowired
	public void setQueue(Queue queue) {
		this.queue = queue;
	}

	@Autowired
	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	@Autowired
	public void setJmsMessagingTemplate(JmsMessagingTemplate jmsMessagingTemplate) {
		this.jmsMessagingTemplate = jmsMessagingTemplate;
	}
	@Async("taskExecutor1")
	public void sendToTopic(String msg) throws InterruptedException {
		Thread.sleep(100);
		jmsMessagingTemplate.convertAndSend(topic, msg);
		System.out.println(Thread.currentThread().getName()+"线程：----发送Topic消息，开始异步发送----");
	}
	@Async("faSong")
	public void sendToQueue(String msg) throws InterruptedException {
		Thread.sleep(100);
		jmsMessagingTemplate.convertAndSend(queue, msg);
		System.out.println(Thread.currentThread().getName()+"线程：----发送Queue消息，开始异步发送----");
	}

}
