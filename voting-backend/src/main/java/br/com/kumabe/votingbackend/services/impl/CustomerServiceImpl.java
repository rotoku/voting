package br.com.kumabe.votingbackend.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kumabe.votingbackend.models.Customer;
import br.com.kumabe.votingbackend.repositories.CustomerRepository;
import br.com.kumabe.votingbackend.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	private CustomerRepository customerRepository;
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public void create(Customer customer) {
		customerRepository.saveAndFlush(customer);		
	}

	@Override
	public Customer retrieve(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Long id, Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Customer> list() {
		return customerRepository.findAll();
	}

}
