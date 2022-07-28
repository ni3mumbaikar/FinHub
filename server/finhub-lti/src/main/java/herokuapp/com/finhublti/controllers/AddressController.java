package herokuapp.com.finhublti.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import herokuapp.com.finhublti.dao.AddressDao;
import herokuapp.com.finhublti.models.Address;

@RestController
public class AddressController {

	@Autowired
	AddressDao cd;

	@GetMapping("/address")
	public List<Address> getaddrs() {
		return cd.getaddrs();
	}

	@GetMapping("/address/{cust_id}")
	public Address getaddr(@PathVariable String cust_id) {
		System.out.println("cid request : " + cust_id);
		return cd.getaddr(Long.parseLong(cust_id));
	}
}
