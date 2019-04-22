package cn.mastercom.demo.redis.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class StringValue {
	RedisTemplate redisTemplate;

	@Autowired
	public void setRedisTemplate(RedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public void set(String key, Object value) {
		redisTemplate.opsForValue().setIfAbsent(key, value);
	}

	public Object get(String key) {
		return redisTemplate.opsForValue().get(key);
	}
}
