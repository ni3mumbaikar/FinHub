package herokuapp.com.finhublti.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import herokuapp.com.finhublti.dao.CustDao;
import herokuapp.com.finhublti.models.Customer;

@RestController
public class CustomersController {

	@Autowired
	CustDao cd;

	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return cd.getCustomers();
	}

	@GetMapping("/customers/{cust_id}")
	public Customer getCustomer(@PathVariable String cust_id) {
		System.out.println("cid request : " + cust_id);
		return cd.getCustomer(Long.parseLong(cust_id));
	}

}
