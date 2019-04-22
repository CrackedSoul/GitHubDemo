package cn.mastercom.demo.redis.redis;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
@Component
public class StringHash {
	RedisTemplate redisTemplate;

	@SuppressWarnings("rawtypes")
	@Autowired
	public void setRedisTemplate(RedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public void put(String key, String hashkey, Object value) {
		this.redisTemplate.opsForHash().put(key, hashkey, value);
	}

	
	public Map get(String key) {
		return this.redisTemplate.opsForHash().entries(key);
	}

	public Object get(String key, String hashKey) {
		return this.redisTemplate.opsForHash().get(key, hashKey);
	}
}
