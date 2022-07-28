package herokuapp.com.finhublti.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import herokuapp.com.finhublti.dao.CardDao;
import herokuapp.com.finhublti.dao.CardTypeDao;
import herokuapp.com.finhublti.models.CardType;
import herokuapp.com.finhublti.models.card;

@RestController
public class CardTypeController {

	@Autowired
	CardTypeDao cd;

	@GetMapping("/cards")
	public List<CardType> getCardDetails() {
		return cd.getCardDetails();
	}

	@GetMapping("/cards/{card_type}")
	public CardType getCardDetail(@PathVariable String card_type) {
		System.out.println("cid request : " + card_type);
		return cd.getCardDetail(Integer.parseInt(card_type));
	}

}
