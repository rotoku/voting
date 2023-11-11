package br.com.kumabe.votingbackend.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LanguageDTO implements Serializable {
	private static final long serialVersionUID = 76807122351608843L;
	private Long id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("created_at")
	private LocalDate createdAt;
	@JsonProperty("written_in")
	private String writtenIn;
	
	public LanguageDTO() {}

	public LanguageDTO(Long id, String name, LocalDate createdAt, String writtenIn) {
		super();
		this.id = id;
		this.name = name;
		this.createdAt = createdAt;
		this.writtenIn = writtenIn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public String getWrittenIn() {
		return writtenIn;
	}

	public void setWrittenIn(String writtenIn) {
		this.writtenIn = writtenIn;
	}
	
	
}
