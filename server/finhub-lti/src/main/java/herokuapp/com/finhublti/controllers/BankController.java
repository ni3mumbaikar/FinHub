package herokuapp.com.finhublti.controllers;

import herokuapp.com.finhublti.models.Bank;
import herokuapp.com.finhublti.services.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankController {
    @Autowired
    BankService bankService;

    @GetMapping("/banks")
    public ResponseEntity<List<Bank>> getBanks() {
        return bankService.getBanks();
    }

    @GetMapping("/banks/{bankid}")
    public ResponseEntity<Bank> getBank(@PathVariable String bankid) {
        System.out.println("cid request : " + bankid);
        return bankService.getBank(bankid);
    }
}
