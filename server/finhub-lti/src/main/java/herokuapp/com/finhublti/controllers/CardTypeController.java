package herokuapp.com.finhublti.controllers;

import java.util.List;

import herokuapp.com.finhublti.services.CardTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import herokuapp.com.finhublti.models.CardType;

@RestController
public class CardTypeController {

	@Autowired
	CardTypeService cardTypeService;

	@GetMapping("/cardtype")
	public ResponseEntity<List<CardType>> getCardTypes() {
		return cardTypeService.getCardTypes();
	}

	@GetMapping("/cardtype/{ctype}")
	public ResponseEntity<CardType> getCardType(@PathVariable String ctype) {
		System.out.println("cid request : " + ctype);
		return cardTypeService.getCardType(ctype);
	}

}
