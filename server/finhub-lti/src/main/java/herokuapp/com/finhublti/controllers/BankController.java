package herokuapp.com.finhublti.controllers;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import herokuapp.com.finhublti.dao.BankDao;
import herokuapp.com.finhublti.models.Bank;

@RestController
public class BankController {

	@Autowired
	BankDao cd;

	@GetMapping("/bank")
	public List<Bank> getBankDetails() {
		return cd.getBankDetails();
	}

	@GetMapping("/bank/{cust_id}")
	public Bank getCustomer(@PathVariable String cust_id) {
		System.out.println("cid request : " + cust_id);
		return cd.getBankDetail(Long.parseLong(cust_id));
	}

}
