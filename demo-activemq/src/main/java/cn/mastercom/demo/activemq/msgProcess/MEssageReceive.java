package cn.mastercom.demo.activemq.msgProcess;

import cn.mastercom.demo.activemq.queue.QueueConsumer;
import cn.mastercom.demo.activemq.topic.TopicConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
public class MEssageReceive {
	private TopicConsumer topicConsumer;
	private QueueConsumer queueConsumer;

	@Autowired
	public void setTopicConsumer(TopicConsumer topicConsumer) {
		this.topicConsumer = topicConsumer;
	}
	@Autowired
	public void setQueueConsumer(QueueConsumer queueConsumer) {
		this.queueConsumer = queueConsumer;
	}

	@JmsListener(destination = "TEST_TOPIC", containerFactory = "jmsListenerContainerTopic")
	public void onTopicMessage(String msg) {
		topicConsumer.consume(msg);
	}

	@JmsListener(destination = "TEST_QUEUE", containerFactory = "jmsListenerContainerQueue")
	public void onQueueMessage(String msg) {
		queueConsumer.consume(msg);
	}

}
