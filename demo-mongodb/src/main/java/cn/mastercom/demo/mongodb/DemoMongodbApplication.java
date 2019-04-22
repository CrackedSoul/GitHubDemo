package cn.mastercom.demo.mongodb;

import cn.mastercom.demo.mongodb.dao.UserDao;
import cn.mastercom.demo.mongodb.domain.User;
import cn.mastercom.demo.mongodb.repositry.UserRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class DemoMongodbApplication implements CommandLineRunner {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserRepositry userRepositry;

    public static void main(String[] args) {
        SpringApplication.run(DemoMongodbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<User> user = userDao.list();
        for (long i = 0; i < 20; i++) {
//			user.add(new User(i, "NAME" + i, "PassWord" + i));
            System.out.println(user.get((int) i));
        }
//		userRepositry.saveAll(user);
    }

}


