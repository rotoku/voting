package br.com.kumabe.votingbackend.dtos;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerDTO implements Serializable {
	private static final long serialVersionUID = 886510416268376626L;
	@JsonProperty("id")	
	private Long id;
	@JsonProperty("name")	
	private String name;
	@JsonProperty("email")	
	private String email;
	
	public CustomerDTO() {}

	public CustomerDTO(Long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
		
}
