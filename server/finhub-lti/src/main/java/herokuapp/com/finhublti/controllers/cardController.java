package herokuapp.com.finhublti.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import herokuapp.com.finhublti.dao.CardDao;
import herokuapp.com.finhublti.models.card;

@RestController
public class cardController {

	@Autowired
	CardDao cd;

	@GetMapping("/card")
	public List<card> getCards() {
		return cd.getCards();
	}

	@GetMapping("/card/{custid}")
	public card getCard(@PathVariable String custid) {
		System.out.println("cid request : " + custid);
		return cd.getCard(Long.parseLong(custid));
	}

}
