package cn.mastercom.demo.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.queue.SimpleDistributedQueue;
import org.apache.curator.retry.RetryOneTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
public class DemoZookeeperApplication implements CommandLineRunner {
    @Autowired
    private  CuratorFramework curatorFramework;
    private static final String root="/zookeeperTest/demo";

    private ThreadPoolTaskExecutor taskExecutor;

    @Autowired
    public void setTaskExecutor(ThreadPoolTaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoZookeeperApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        SimpleDistributedQueue queue = new SimpleDistributedQueue(curatorFramework, root+"/queue");
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        new Thread(producer, "producer").start();
        new Thread(consumer, "consumer").start();
        Thread.sleep(20000);
     }
    @Bean
    public CuratorFramework getCuratorFramework(){
        CuratorFramework client= CuratorFrameworkFactory.newClient("192.168.2.90:2181",new RetryOneTime(10));
        client.getCuratorListenable().addListener((client1, event) -> System.out.println("CuratorEvent: " + event.getType().name()));
        client.start();
        return  client;
    }

    public static class Producer implements Runnable {

        private SimpleDistributedQueue queue;

        public Producer(SimpleDistributedQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    boolean flag = queue.offer(("zjc-" + i).getBytes());
                    if (flag) {
                        System.out.println("发送一条消息成功：" + "zjc-" + i);
                    } else {
                        System.out.println("发送一条消息失败：" + "zjc-" + i);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Consumer implements Runnable {

        private SimpleDistributedQueue queue;

        public Consumer(SimpleDistributedQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                while(true) {
                    byte[] datas = queue.take();
                    System.out.println("消费一条消息成功：" + new String(datas, "UTF-8"));
                }} catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
