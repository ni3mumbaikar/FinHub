package herokuapp.com.finhublti.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import herokuapp.com.finhublti.dao.DocDao;
import herokuapp.com.finhublti.models.Documents;


@RestController
public class DocController {

	@Autowired
	DocDao cd;

	@GetMapping("/documents")
	public List<Documents> getDocuments() {
		return cd.getDocuments();
	}

	@GetMapping("/documents/{cust_id}")
	public Documents getDocument(@PathVariable String cust_id) {
		System.out.println("cid request : " + cust_id);
		return cd.getDocument(Long.parseLong(cust_id));
	}
}
