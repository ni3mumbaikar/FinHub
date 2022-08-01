package herokuapp.com.finhublti.controllers;

import java.util.List;

import herokuapp.com.finhublti.services.CardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import herokuapp.com.finhublti.models.Card;

@RestController
@CrossOrigin
public class CardController {

	@Autowired
	CardsService cardsService;

	@GetMapping("/cards")
	public ResponseEntity<List<Card>> getCustomers() {
		return cardsService.getCards();
	}

	@GetMapping("/cards/{card_no}")
	public ResponseEntity<Card> getCustomer(@PathVariable String card_no) {
		return cardsService.getCard(card_no);
	}

}
