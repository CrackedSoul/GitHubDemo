package cn.mastercom.demo.activemq;

import cn.mastercom.demo.activemq.msgProcess.MessageSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Date;


@SpringBootApplication()
@EnableAsync
public class DemoActivemqApplication implements CommandLineRunner {
    private MessageSend messageSend;

    @Autowired
    public void setMessageSend(MessageSend messageSend) {
        this.messageSend = messageSend;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoActivemqApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

            for (int i = 0; i < 100; i++) {
                messageSend.sendToQueue(new Date().toString() + "-----" + i);

            }
            for (int i = 0; i < 10; i++) {
                messageSend.sendToTopic(new Date().toString() + "-----" + i);
            }

    }

}
