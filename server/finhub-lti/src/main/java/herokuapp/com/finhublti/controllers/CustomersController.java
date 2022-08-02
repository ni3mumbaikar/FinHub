package herokuapp.com.finhublti.controllers;

import herokuapp.com.finhublti.models.*;
import herokuapp.com.finhublti.repositories.CardsRepository;
import herokuapp.com.finhublti.services.AddressService;
import herokuapp.com.finhublti.services.CustomerService;
import herokuapp.com.finhublti.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.*;

@RestController
@CrossOrigin
public class CustomersController {

    @Autowired
    CustomerService customerService;
    @Autowired
    AddressService addressService;
    @Autowired
    DocumentService documentService;

    @Autowired
    CardsRepository cardsRepository;

    @GetMapping("customers/authenticate")
    public long authenticate(@RequestParam String username, @RequestParam String password) {
        System.out.println(username+" "+password);
        return customerService.authenticate(username,password);
    }

    @GetMapping("customers/approve/{cid}")
    public HttpStatus approveCustomer(@PathVariable String cid){
        try{
            Customer c = customerService.getCustomer(cid).getBody();
            c.setIs_approved(1);
            customerService.insertUser(c);
            generateCC(c);
            return HttpStatus.OK;
        } catch (NumberFormatException numberFormatException){
            return HttpStatus.BAD_REQUEST;
        }
    }

    @GetMapping("customers/reject/{cid}")
    public HttpStatus rejectCustomer(@PathVariable String cid){
        try{
            Customer c = customerService.getCustomer(cid).getBody();
            c.setIs_approved(1);
            customerService.insertUser(c);
            generateCC(c);
            return HttpStatus.OK;
        } catch (NumberFormatException numberFormatException){
            return HttpStatus.BAD_REQUEST;
        } catch (NullPointerException nullPointerException){
            return HttpStatus.NOT_FOUND;
        }
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/customers/{custid}")
    public ResponseEntity<Customer> getCustomer(@PathVariable String custid) {
        return customerService.getCustomer(custid);
    }

    @PostMapping("/customers/signup")
    @Transactional
    public HttpStatus usersignup(@RequestBody Map<String, Object> payload) {
        Customer c = new Customer();
        c.setAadhar(Long.parseLong(payload.get("aadhar").toString()));
        c.setAlternate_phone(Long.parseLong(payload.get("alternate_phone").toString()));
        c.setEmail(payload.get("email").toString());
        c.setFirst_name(payload.get("first_name").toString());
        c.setLast_name(payload.get("last_name").toString());
        c.setMiddle_name(payload.get("middle_name").toString());
        c.setPan(payload.get("pan").toString());
        c.setUsername(payload.get("username").toString());
        c.setPassword(payload.get("password").toString());
        c.setPhone_no(Long.parseLong(payload.get("phone_no").toString()));
        c.setCard_type(Long.parseLong(payload.get("inlineRadioOptions").toString()));
        customerService.insertUser(c);

        Document document = new Document();
        document.setAadhar(payload.get("aadhar_doc").toString());
        document.setPan(payload.get("pan_doc").toString());
        document.setBank_info(payload.get("bank_info").toString());
        document.setPhoto(payload.get("photo").toString());
        document.setVaadhar(0);
        document.setVbank_info(0);
        document.setVpan(0);
        document.setVbank_info(0);
        document.setCustid(c.getCustid());
        documentService.add(document);

        Address address = new Address();
        address.setCity(payload.get("city").toString());
        address.setDist(payload.get("dist").toString());
        address.setCustid(c.getCustid());
        address.setLandmark(payload.get("landmark").toString());
        address.setPincode(Long.parseLong(payload.get("pincode").toString()));
        address.setState(payload.get("state").toString());
        address.setStreet(payload.get("street").toString());
        addressService.add(address);

        return HttpStatus.OK;

    }

    public void generateCC(Customer customer){
        Long ccnum = Long.parseLong(getCCNumber(16));
        Long cvv = Long.parseLong(getCCNumber(3));
        Long limit = (customer.getCard_type()==1)? 50000L : 80000L;
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.YEAR,2);
        date = c.getTime();

        Card card = new Card();
        card.setLimit(limit);
        card.setCard_no(ccnum);
        card.setCustid(customer.getCustid());
        card.setValid_thr(date);
        card.setCvv(cvv);
        card.setBalance(card.getLimit());
        card.setCard_type((int)customer.getCard_type());

        customer.setCard_no(card.getCard_no());
        customerService.insertUser(customer);
        cardsRepository.save(card);
    }

    public static String getCCNumber(int digits) {
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(digits);
        for(int i=0; i < digits; i++)
            sb.append((char)('0' + rnd.nextInt(10)));
        return sb.toString();
    }


}
