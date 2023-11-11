package br.com.kumabe.votingbackend.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kumabe.votingbackend.models.Vote;
import br.com.kumabe.votingbackend.repositories.VoteRepository;
import br.com.kumabe.votingbackend.services.VoteService;

@Service
public class VoteServiceImpl implements VoteService {
	private VoteRepository voteRepository;
	
	@Autowired
	public VoteServiceImpl(VoteRepository voteRepository) {
		this.voteRepository = voteRepository;
	}

	@Override
	public void create(Vote vote) {	
		voteRepository.saveAndFlush(vote);
	}

	@Override
	public Vote retrieve(Long id) {		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Long id, Vote vote) {
	}

	@Override
	public void delete(Long id) {
	}

	@Override
	public List<Vote> list() {
		return voteRepository.findAll();
	}

}
