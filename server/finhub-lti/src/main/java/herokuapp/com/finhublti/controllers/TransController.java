package herokuapp.com.finhublti.controllers;

import herokuapp.com.finhublti.models.Card;
import herokuapp.com.finhublti.models.Customer;
import herokuapp.com.finhublti.models.Product;
import herokuapp.com.finhublti.models.Transactions;
import herokuapp.com.finhublti.repositories.CardsRepository;
import herokuapp.com.finhublti.repositories.CustomersRepository;
import herokuapp.com.finhublti.repositories.ProductRepository;
import herokuapp.com.finhublti.repositories.TransactionsRepository;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
public class TransController {

    @Autowired
    TransactionsRepository transactionsRepository;
	@Autowired
	CustomersRepository customersRepository;
	@Autowired
	CardsRepository cardsRepository;
	@Autowired
	ProductRepository productRepository;
    @PostMapping("/trans")
    public ResponseEntity<String> placeOrder(@RequestBody Map<String, Object> payload) {
        try {
            Long pid = Long.parseLong(payload.get("pid").toString());
            Long cid = Long.parseLong(payload.get("cid").toString());
            Long cvv = Long.parseLong(payload.get("cvv").toString());
            int emiMonths = Integer.parseInt(payload.get("emi_months").toString());
            Optional<Customer> c = customersRepository.findById(cid);
            if(c.isPresent()){
                Card card = cardsRepository.findById(c.get().getCard_no()).get();
                if (card.getCvv()!=cvv)
                    return new ResponseEntity<>("INVALID CVV",HttpStatus.FORBIDDEN);
				Product product = productRepository.findById(pid).get();
				if(card.getBalance()>=(product.getPrice()/emiMonths)){
					Transactions t = new Transactions();
					t.setPending_inst(emiMonths - 1);
					Date date = new Date();
					t.setTxn_date(date);
                    t.setEmi_months(emiMonths);
                    t.setPid(pid);
					Calendar cal = Calendar.getInstance();
					cal.setTime(date);
					cal.add(Calendar.DATE, 45);
					t.setDue_date(cal.getTime());
                    t.setCustid(c.get().getCustid());
					card.setBalance(card.getBalance()-(product.getPrice()/emiMonths));
					cardsRepository.save(card);
					transactionsRepository.save(t);
				}
			}
            return new ResponseEntity<>("OK", HttpStatus.OK);
        } catch (NumberFormatException numberFormatException) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e ){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/trans/live/{cid}")
    public ResponseEntity<List<Transactions>> getLiveTransactions(@PathVariable String cid, @RequestBody Map<String, Object> payload){
        Optional<Customer> customerOptional = customersRepository.findById(Long.parseLong(cid));
        if(customerOptional.isPresent()){
            Customer c = customerOptional.get();
            List<Transactions> transactions = new ArrayList<>();
            for (Transactions t : c.getTransactions()){
                if(t.getPending_inst()>0){
                    transactions.add(t);
                }
            }
            return new ResponseEntity<>(transactions,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /*@PostMapping("/trans")
    public ResponseEntity<String> payEMI(@RequestBody Map<String, Object> payload){
        try{
            Long pid = Long.parseLong(payload.get("pid").toString());
            Long cid = Long.parseLong(payload.get("cid").toString());
            int emiMonths = Integer.parseInt(payload.get("emi_months").toString());

        }
        catch (NumberFormatException numberFormatException) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e ){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/


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
