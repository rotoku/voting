package br.com.kumabe.votingbackend.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kumabe.votingbackend.models.Language;
import br.com.kumabe.votingbackend.repositories.LanguageRepository;
import br.com.kumabe.votingbackend.services.LanguageService;

@Service
public class LanguageServiceImpl implements LanguageService {
	private LanguageRepository languageRepository;
	
	@Autowired
	public LanguageServiceImpl(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public void create(Language language) {
		languageRepository.saveAndFlush(language);
		
	}

	@Override
	public Language retrieve(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Long id, Language language) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Language> list() {
		return languageRepository.findAll();
	}

}
