package br.com.kumabe.votingbackend.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "votes")
@Entity
public class Vote implements Serializable {
	private static final long serialVersionUID = -8300100364943301320L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "votes_seq")
	@SequenceGenerator(name = "votes_seq", sequenceName = "votes_seq", allocationSize = 1)
	@Column(name="id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	@ManyToOne
	@JoinColumn(name="language_id")
	private Language language;
	
	@Column(name="created_at")
	private LocalDateTime createdAt;	
	
	public Vote() {}

	public Vote(Long id, Customer customer, Language language, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.customer = customer;
		this.language = language;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
}
