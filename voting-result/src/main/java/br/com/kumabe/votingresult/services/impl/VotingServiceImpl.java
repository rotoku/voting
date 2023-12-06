package br.com.kumabe.votingresult.services.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kumabe.votingresult.models.Voting;
import br.com.kumabe.votingresult.repositories.VotingRepository;
import br.com.kumabe.votingresult.services.VotingService;

@Service
public class VotingServiceImpl implements VotingService {
	private VotingRepository votingRepository;
	
	@Autowired
	public VotingServiceImpl(VotingRepository votingRepository) {
		this.votingRepository = votingRepository;
	}
	
	@Override
	public List<Voting> list() {
		return votingRepository.findAll();
	}

	@Override
	public BigDecimal somaTotalDeVotos() {
		return votingRepository.somaTotalDeVotos();
	}

}
