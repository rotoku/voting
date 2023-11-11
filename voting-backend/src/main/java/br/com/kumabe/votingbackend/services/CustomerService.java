package br.com.kumabe.votingbackend.services;

import java.util.List;

import br.com.kumabe.votingbackend.models.Customer;

public interface CustomerService {
	public void create(Customer customer);
	public Customer retrieve(Long id);
	public void update(Long id, Customer customer);
	public void delete(Long id);
	public List<Customer> list();
}
