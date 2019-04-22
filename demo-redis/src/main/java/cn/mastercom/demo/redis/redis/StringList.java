package cn.mastercom.demo.redis.redis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
@Component
public class StringList {
	RedisTemplate redisTemplate;

	@Autowired
	public void setRedisTemplate(RedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public void push(String key, Object value) {
		this.redisTemplate.opsForList().leftPush(key, value);
	}

	public Object pop(String key) {
		return this.redisTemplate.opsForList().leftPop(key);
	}

	public List getList(String key) {
		return this.redisTemplate.opsForList().range(key, 0, this.redisTemplate.opsForList().size(key));
	}
}
