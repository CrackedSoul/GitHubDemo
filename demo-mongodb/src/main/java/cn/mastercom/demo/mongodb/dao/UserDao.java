package cn.mastercom.demo.mongodb.dao;
import cn.mastercom.demo.mongodb.domain.User;
import java.util.List;

public interface UserDao {
	 void saveUser(User user);

	 User findUserById(long id);

	 User findUserByUserName(String userName);

	 void updateUser(User user);

	 void deleteUserById(Long id);

	 List<User> findAll(int pageNo, int pageSize);

	 List<User> list();
}
