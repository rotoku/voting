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
import br.com.kumabe.votingbackend.models.Customer;
import br.com.kumabe.votingbackend.services.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	private CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@PostMapping(path="/v1/customers", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> create(@RequestBody CustomerDTO customerDTO, UriComponentsBuilder uriComponentsBuilder) {
		LOGGER.info("Create Customers...");
		Customer customer = dto2Entity(customerDTO);
		customerService.create(customer);
		URI location = uriComponentsBuilder.path("/api/v1/customers/{id}").buildAndExpand(customer.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping(path="/v1/customers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CustomerDTO>> list(){
		LOGGER.info("List Customers...");
		List<CustomerDTO> customerDTOs = customerService.list().stream().map(c -> entity2DTO(c)).collect(Collectors.toList());
		return ResponseEntity.ok(customerDTOs);
	}
	
	private CustomerDTO entity2DTO(Customer customer){
		return new CustomerDTO(customer.getId(), customer.getName(), customer.getEmail());
	}
	
	private Customer dto2Entity(CustomerDTO customerDTO){
		return new Customer(customerDTO.getId(), customerDTO.getName(), customerDTO.getEmail());
	}
}
