package br.com.kumabe.votingbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.kumabe.votingbackend.models.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long>{

}
