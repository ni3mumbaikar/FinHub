package herokuapp.com.finhublti.services;

import herokuapp.com.finhublti.models.Customer;
import herokuapp.com.finhublti.models.Document;
import herokuapp.com.finhublti.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomersRepository customersRepository;

    public ResponseEntity<List<Customer>> getCustomers() {
        return new ResponseEntity<>(customersRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Customer> getCustomer(String cid) {
        try {
            Optional<Customer> productData = customersRepository.findById(Long.parseLong(cid));
            return productData.map(documents -> new ResponseEntity<>(documents, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (NumberFormatException numberFormatException) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}