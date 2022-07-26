package herokuapp.com.finhublti.dao;

import java.util.*;

import herokuapp.com.finhublti.models.Customer;

public interface CustDao {

	List<Customer> getCustomers();
	
	Customer getCustomer(long cid);
}
