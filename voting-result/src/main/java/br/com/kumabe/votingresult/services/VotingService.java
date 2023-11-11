package br.com.kumabe.votingresult.services;

import java.math.BigDecimal;
import java.util.List;

import br.com.kumabe.votingresult.models.Voting;

public interface VotingService {
	public List<Voting> list();
	public BigDecimal somaTotalDeVotos();
}
