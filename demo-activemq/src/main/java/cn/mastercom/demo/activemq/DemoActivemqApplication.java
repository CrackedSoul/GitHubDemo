package cn.mastercom.demo.activemq;

import cn.mastercom.demo.activemq.msgProcess.MessageSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Date;



@SpringBootApplication

public class DemoActivemqApplication implements CommandLineRunner {
    private MessageSend messageSend;

    @Autowired
    public void setMessageSend(MessageSend messageSend) {
        this.messageSend = messageSend;
    }

    private ThreadPoolTaskExecutor taskExecutor;

    @Autowired
    public void setTaskExecutor(ThreadPoolTaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoActivemqApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        taskExecutor.submit(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                messageSend.sendToQueue(new Date().toString() + "-----" + i);
            }

        });
        taskExecutor.submit(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                messageSend.sendToTopic(new Date().toString() + "-----" + i);
            }

        });
    }

}
