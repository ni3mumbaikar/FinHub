package herokuapp.com.finhublti.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import herokuapp.com.finhublti.dao.TransDao;
import herokuapp.com.finhublti.models.Transactions;

@RestController
public class TransController {

	@Autowired
	TransDao cd;

	@GetMapping("/trans")
	public List<Transactions> gettrans() {
		return cd.gettrans();
	}

	@GetMapping("/trans/{cust_id}")
	public Transactions gettran(@PathVariable String cust_id) {
		System.out.println("cid request : " + cust_id);
		return cd.gettran(Long.parseLong(cust_id));
	}
}
