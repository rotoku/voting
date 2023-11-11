package br.com.kumabe.votingbackend.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "customers")
@Entity
public class Customer implements Serializable {
	private static final long serialVersionUID = 1975270547625290594L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customers_seq")
	@SequenceGenerator(name = "customers_seq", sequenceName = "customers_seq", allocationSize = 1)
	@Column(name="id")	
	private Long id;
	@Column(name="name")	
	private String name;
	@Column(name="email")	
	private String email;
	
	public Customer() {}

	public Customer(Long id, String name, String email) {
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
