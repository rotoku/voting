package br.com.kumabe.votingbackend.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.kumabe.votingbackend.dtos.LanguageDTO;
import br.com.kumabe.votingbackend.models.Language;
import br.com.kumabe.votingbackend.services.LanguageService;

@RestController
@RequestMapping("/api")
public class LanguageController {
	private static final Logger LOGGER = LoggerFactory.getLogger(LanguageController.class);
	private LanguageService languageService;
	
	@Autowired
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@PostMapping(path="/v1/languages", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> create(@RequestBody LanguageDTO languageDTO, UriComponentsBuilder uriComponentsBuilder) {
		LOGGER.info("Create languages...");
		Language language = dto2Entity(languageDTO);
		languageService.create(language);
		URI location = uriComponentsBuilder.path("/api/v1/languages/{id}").buildAndExpand(language.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping(path="/v1/languages", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LanguageDTO>> list(){
		LOGGER.info("List languages...");
		List<LanguageDTO> languageDTOs = languageService.list().stream().map(l -> entity2DTO(l)).collect(Collectors.toList());
		return ResponseEntity.ok(languageDTOs);
	}
	
	private LanguageDTO entity2DTO(Language language){
		return new LanguageDTO(language.getId(), language.getName(), language.getCreatedAt(), language.getWrittenIn());
	}
	
	private Language dto2Entity(LanguageDTO languageDTO){
		return new Language(languageDTO.getId(), languageDTO.getName(), languageDTO.getCreatedAt(), languageDTO.getWrittenIn());
	}
}
