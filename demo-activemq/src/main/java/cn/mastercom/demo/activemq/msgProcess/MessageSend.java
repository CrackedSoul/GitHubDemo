package cn.mastercom.demo.activemq.msgProcess;

import javax.jms.Queue;
import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
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

	public void sendToTopic(String msg) {
		jmsMessagingTemplate.convertAndSend(topic, msg);
	}

	public void sendToQueue(String msg) {
		jmsMessagingTemplate.convertAndSend(queue, msg);
	}

}
