package herokuapp.com.finhublti.services;

import herokuapp.com.finhublti.models.Bank;
import herokuapp.com.finhublti.repositories.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService {
    @Autowired
    BankRepository bankRespository;

    public ResponseEntity<List<Bank>> getBanks() {
        return new ResponseEntity<>(bankRespository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Bank> getBank(String cid) {
        try {
            Optional<Bank> bankData = bankRespository.findById(Long.parseLong(cid));
            return bankData.map(documents -> new ResponseEntity<>(documents, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (NumberFormatException numberFormatException) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
