package br.com.kumabe.votingworker.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "votes")
public class Voting implements Serializable {
	private static final long serialVersionUID = -517044445275212680L;
	@Id
	@Column(name="language")
	private String language;
	@Column(name="amount")
	private Long amount;
	
	public Voting() {}

	public Voting(String language, Long amount) {
		super();
		this.language = language;
		this.amount = amount;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
}
