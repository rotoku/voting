package br.com.kumabe.votingapp.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import br.com.kumabe.votingapp.services.VotingAppService;


@Service
public class VotingAppServiceImpl implements VotingAppService {
	private static final Logger LOGGER = LoggerFactory.getLogger(VotingAppServiceImpl.class);
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	@Override
	public void create(String key, Object value) {
		redisTemplate.opsForValue().set(key, value);
	}

	@Override
	public Object retrieve(String key) {
		return redisTemplate.opsForValue().get(key);
	}

}
