package herokuapp.com.finhublti.controllers;

import java.util.List;

import herokuapp.com.finhublti.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import herokuapp.com.finhublti.models.Customer;

@RestController
public class CustomersController {

	@Autowired
	CustomerService customerService;

	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getCustomers() {
		return customerService.getCustomers();
	}

	@GetMapping("/customers/{custid}")
	public ResponseEntity<Customer> getCustomer(@PathVariable String custid) {
		System.out.println("cid request : " + custid);
		return customerService.getCustomer(custid);
	}

}
