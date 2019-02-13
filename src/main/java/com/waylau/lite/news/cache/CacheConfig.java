/**
 * Welcome to https://waylau.com
 */
package com.waylau.lite.news.cache;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 * Spring Cache Configuration.
 * 
 * @since 1.0.0 2019年2月13日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@Configuration
@EnableCaching
public class CacheConfig {

	@Bean
	public RedisCacheManager cacheManager() {
		return RedisCacheManager.create(redisConnectionFactory());
	}

	@Bean
	public JedisConnectionFactory redisConnectionFactory() {
		return new JedisConnectionFactory();
	}

}
