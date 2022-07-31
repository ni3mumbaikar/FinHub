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

	@GetMapping("/customers/{custid}")
	public Customer getCustomer(@PathVariable String custid) {
		System.out.println("cid request : " + custid);
		return cd.getCustomer(Long.parseLong(custid));
	}

}
