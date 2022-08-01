package herokuapp.com.finhublti.controllers;

import java.util.List;

import herokuapp.com.finhublti.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import herokuapp.com.finhublti.models.Address;

@RestController
@CrossOrigin
public class AddressController {

	@Autowired
	AddressService addressService;

	@GetMapping("/address")
	public ResponseEntity<List<Address>> getCustomers() {
		return addressService.getCustomers();
	}

	@GetMapping("/address/{add_id}")
	public ResponseEntity<Address> getCustomer(@PathVariable String add_id) {
		System.out.println("cid request : " + add_id);
		return addressService.getCustomer(add_id);
	}

}
