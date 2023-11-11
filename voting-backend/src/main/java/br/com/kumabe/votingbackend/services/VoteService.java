package br.com.kumabe.votingbackend.services;

import java.util.List;

import br.com.kumabe.votingbackend.models.Vote;

public interface VoteService {
	public void create(Vote vote);
	public Vote retrieve(Long id);
	public void update(Long id, Vote vote);
	public void delete(Long id);
	public List<Vote> list();
}
