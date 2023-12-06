package br.com.kumabe.votingworker.services;

import br.com.kumabe.votingworker.models.Voting;

public interface VotingWorkerService {
	public void createFromRedis(String key, Object value);
	public Object retrieveFromRedis(String key);
	public void deleteFromRedis(String key);
	public void createFromPostgres(Voting voting);
	public Voting retrieveFromPostgres(String language);
}
