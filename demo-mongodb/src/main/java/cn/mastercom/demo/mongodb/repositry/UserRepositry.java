package cn.mastercom.demo.mongodb.repositry;


import cn.mastercom.demo.mongodb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepositry extends MongoRepository<User, Long> {

}
