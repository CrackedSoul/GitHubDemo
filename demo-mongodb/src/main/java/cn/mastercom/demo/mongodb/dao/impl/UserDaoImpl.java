package cn.mastercom.demo.mongodb.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import cn.mastercom.demo.mongodb.dao.UserDao;
import cn.mastercom.backstage.domain.User;

@Service("userDao")
public class UserDaoImpl implements UserDao {
	@Resource
	private MongoTemplate mongoTemplate;

	@Override
	public void saveUser(User user) {
		mongoTemplate.save(user);
	}

	@Override
	public User findUserById(long id) {
		Query query = new Query(Criteria.where("id").is(id));
		return mongoTemplate.findOne(query, User.class);
	}

	@Override
	public User findUserByUserName(String userName) {
		Query query = new Query(Criteria.where("userName").is(userName));
		User user = mongoTemplate.findOne(query, User.class);
		return user;
	}

	@Override
	public void updateUser(User user) {
		Query query = new Query(Criteria.where("id").is(user.getId()));
		Update update = new Update().set("userName", user.getUserName()).set("passWord", user.getPassWord());
		// 更新查询返回结果集的第一条
		mongoTemplate.updateFirst(query, update, User.class);
	}

	@Override
	public void deleteUserById(Long id) {
		Query query = new Query(Criteria.where("id").is(id));
		mongoTemplate.remove(query, User.class);
	}

	@Override
	public List<User> findAll(int pageNo, int pageSize) {
		Query query = new Query();
		query.skip((pageNo - 1) * pageSize);
		query.limit(pageSize);
		query.with(new Sort(Sort.Direction.ASC, "userId"));// 按照userId排序
		List<User> users = mongoTemplate.find(query, User.class);
		return users;
	}

	@Override
	public List<User> list() {
		Query query = new Query();
		List<User> users = mongoTemplate.find(query, User.class);
		return users;
	}

}
