package br.com.kumabe.votingapp.services;

public interface VotingAppService {
	public void create(String key, Object value);
	public Object retrieve(String key);
}
