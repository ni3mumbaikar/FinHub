package herokuapp.com.finhublti.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import herokuapp.com.finhublti.models.Product;
import herokuapp.com.finhublti.models.Transactions;
import herokuapp.com.finhublti.repositories.TransactionsRepository;

@RestController
public class TransController {

	@Autowired
	TransactionsRepository transactionsRepository;

	@GetMapping("/trans")
	public ResponseEntity<List<Transactions>> getTransactions() {
		return new ResponseEntity<>(transactionsRepository.findAll(), HttpStatus.OK);
	}

	@GetMapping("/trans/{txn_id}")
	public ResponseEntity<Transactions> getTransaction(@PathVariable String txn_id) {
		try {
			Optional<Transactions> txData = transactionsRepository.findById(Long.parseLong(txn_id));
			if (txData.isPresent()) {
				return new ResponseEntity<>(txData.get(), HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (NumberFormatException numberFormatException) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (Exception exception) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
