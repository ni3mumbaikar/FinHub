package herokuapp.com.finhublti.controllers;

import java.util.List;

import herokuapp.com.finhublti.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import herokuapp.com.finhublti.models.Customer;
import herokuapp.com.finhublti.repositories.CustomersRepository;

@RestController
public class CustomersController {

	@Autowired
	CustomerService customerService;

	@Autowired
	CustomersRepository cr;

	@GetMapping("/authenticate")
	public long authenticate(@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password) {
		return customerService.authenicate(username, password);
	}

	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getCustomers() {
		return customerService.getCustomers();
	}

	@GetMapping("/customers/{custid}")
	public ResponseEntity<Customer> getCustomer(@PathVariable String custid) {
		System.out.println("cid request : " + custid);
		return customerService.getCustomer(custid);
	}

	@PostMapping("/users/signup")
	public HttpStatus usersignup(@RequestBody Customer c) {

			if (cr.findByUsername(c.getUsername()) == null) {
			return HttpStatus.BAD_REQUEST;
		}
		else {
			return customerService.insertUser(c);
		}

	}

}
