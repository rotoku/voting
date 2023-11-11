package br.com.kumabe.votingbackend.services;

import java.util.List;

import br.com.kumabe.votingbackend.models.Language;

public interface LanguageService {
	public void create(Language language);
	public Language retrieve(Long id);
	public void update(Long id, Language language);
	public void delete(Long id);
	public List<Language> list();
}
