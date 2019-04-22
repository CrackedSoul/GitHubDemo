package cn.mastercom.demo.redis.redis;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
@Component
public class StringSet {
	RedisTemplate redisTemplate;

	@Autowired
	public void setRedisTemplate(RedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public void add(String key, Object value) {
		this.redisTemplate.opsForSet().add(key, value);
	}

	public Set get(String key) {
		return this.redisTemplate.opsForSet().members(key);
	}
}
