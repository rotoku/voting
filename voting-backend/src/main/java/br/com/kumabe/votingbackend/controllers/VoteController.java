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

import br.com.kumabe.votingbackend.dtos.CustomerDTO;
import br.com.kumabe.votingbackend.dtos.LanguageDTO;
import br.com.kumabe.votingbackend.dtos.VoteDTO;
import br.com.kumabe.votingbackend.models.Customer;
import br.com.kumabe.votingbackend.models.Language;
import br.com.kumabe.votingbackend.models.Vote;
import br.com.kumabe.votingbackend.services.VoteService;

@RestController
@RequestMapping("/api")
public class VoteController {
	private static final Logger LOGGER = LoggerFactory.getLogger(VoteController.class);
	
	private VoteService votingService;
	
	@Autowired
	public VoteController(VoteService votingService) {
		this.votingService = votingService;
	}
	
	@PostMapping(path="/v1/votes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> create(@RequestBody VoteDTO voteDTO, UriComponentsBuilder uriComponentsBuilder) {
		LOGGER.info("Create votes...");
		Vote vote = dto2Entity(voteDTO);
		votingService.create(vote);
		URI location = uriComponentsBuilder.path("/api/v1/votes/{id}").buildAndExpand(vote.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping(path="/v1/votes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<VoteDTO>> list(){
		LOGGER.info("List votes...");
		List<VoteDTO> voteDTOs = votingService.list().stream().map(v -> entity2DTO(v)).collect(Collectors.toList());
		return ResponseEntity.ok(voteDTOs);
	}
	
	private VoteDTO entity2DTO(Vote vote){
		return new VoteDTO(
				vote.getId(),
				new CustomerDTO(vote.getCustomer().getId(), vote.getCustomer().getName(), vote.getCustomer().getEmail()),
				new LanguageDTO(vote.getLanguage().getId(), vote.getLanguage().getName(), vote.getLanguage().getCreatedAt(), vote.getLanguage().getWrittenIn()),
				vote.getCreatedAt());
	}
	
	private Vote dto2Entity(VoteDTO voteDTO){
		return new Vote(
				voteDTO.getId(), 
				new Customer(voteDTO.getCustomerDTO().getId(), voteDTO.getCustomerDTO().getName(), voteDTO.getCustomerDTO().getEmail()),
				new Language(voteDTO.getLanguageDTO().getId(), voteDTO.getLanguageDTO().getName(), voteDTO.getLanguageDTO().getCreatedAt(), voteDTO.getLanguageDTO().getWrittenIn()),
				voteDTO.getCreatedAt());
	}
}
