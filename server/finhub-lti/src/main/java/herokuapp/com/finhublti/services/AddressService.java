package herokuapp.com.finhublti.services;

import herokuapp.com.finhublti.models.Address;
import herokuapp.com.finhublti.models.Customer;
import herokuapp.com.finhublti.models.Document;
import herokuapp.com.finhublti.repositories.AddressRepository;
import herokuapp.com.finhublti.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    public ResponseEntity<List<Address>> getCustomers() {
        return new ResponseEntity<>(addressRepository.findAll(), HttpStatus.OK);
    }

    @Transactional
    public HttpStatus add (Address address){
        addressRepository.save(address);
        return HttpStatus.OK;
    }

    public ResponseEntity<Address> getCustomer(String cid) {
        try {
            Optional<Address> addressData = addressRepository.findById(Long.parseLong(cid));
            return addressData.map(address -> new ResponseEntity<>(address, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (NumberFormatException numberFormatException) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
