package br.com.kumabe.votingworker.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import br.com.kumabe.votingworker.models.Voting;
import br.com.kumabe.votingworker.repositories.VotingRepository;
import br.com.kumabe.votingworker.services.VotingWorkerService;

@Service
public class VotingWorkerServiceImpl implements VotingWorkerService {
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	@Autowired
	private VotingRepository votingRepository;
	
	@Override
	public void createFromRedis(String key, Object value) {
		redisTemplate.opsForValue().set(key, value);
	}

	@Override
	public Object retrieveFromRedis(String key) {
		return redisTemplate.opsForValue().get(key);
	}

	@Override
	public void createFromPostgres(Voting voting) {
		Optional<Voting> optional = votingRepository.findById(voting.getLanguage());
		if(optional.isPresent()) {
			Long amount = optional.get().getAmount();
			voting.setAmount(amount + voting.getAmount());
			votingRepository.saveAndFlush(voting);
		}else {
			votingRepository.saveAndFlush(voting);
		}		
	}

	@Override
	public Voting retrieveFromPostgres(String language) {
		Optional<Voting> optional = votingRepository.findById(language);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;	
		}
	}

	@Override
	public void deleteFromRedis(String key) {
		redisTemplate.delete(key);		
	}

}
