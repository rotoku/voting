package br.com.kumabe.votingbackend.models;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "languages")
@Entity
public class Language implements Serializable {
	private static final long serialVersionUID = 146107821287994455L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "languages_seq")
	@SequenceGenerator(name = "languages_seq", sequenceName = "languages_seq", allocationSize = 1)
	@Column(name="id")
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name="created_at")
	private LocalDate createdAt;
	@Column(name="written_in")
	private String writtenIn;
	
	public Language() {}

	public Language(Long id, String name, LocalDate createdAt, String writtenIn) {
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
