package br.com.kumabe.votingresult.repositories;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.kumabe.votingresult.models.Voting;

@Repository
public interface VotingRepository extends JpaRepository<Voting, String> {
	@Query("SELECT SUM(v.amount) FROM Voting v")
	public BigDecimal somaTotalDeVotos();
}
