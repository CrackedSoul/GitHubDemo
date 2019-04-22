package cn.mastercom.demo.redis.redis;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class StringZSet {
	RedisTemplate redisTemplate;

	@Autowired
	public void setRedisTemplate(RedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public void add(String key, Object value, double sortValue) {
		this.redisTemplate.opsForZSet().add(key, value, sortValue);
	}

	public Set get(String key) {
		return this.redisTemplate.opsForZSet().range(key, 0, this.redisTemplate.opsForZSet().size(key));
	}
}
