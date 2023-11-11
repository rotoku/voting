package br.com.kumabe.votingbackend.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VoteDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	@JsonProperty("id")
	private Long id;
	@JsonProperty("customer")
	private CustomerDTO customerDTO;
	@JsonProperty("language")
	private LanguageDTO languageDTO;
	@JsonProperty("created_at")
	private LocalDateTime createdAt;	
	
	public VoteDTO() {}

	public VoteDTO(Long id, CustomerDTO customerDTO, LanguageDTO languageDTO, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.customerDTO = customerDTO;
		this.languageDTO = languageDTO;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CustomerDTO getCustomerDTO() {
		return customerDTO;
	}

	public void setCustomerDTO(CustomerDTO customerDTO) {
		this.customerDTO = customerDTO;
	}

	public LanguageDTO getLanguageDTO() {
		return languageDTO;
	}

	public void setLanguageDTO(LanguageDTO languageDTO) {
		this.languageDTO = languageDTO;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
}
