package herokuapp.com.finhublti.dao;

import java.util.List;

import herokuapp.com.finhublti.models.Bank;
import herokuapp.com.finhublti.models.Customer;

public interface BankDao {
List<Bank> getBankDetails();
	
	Bank getBankDetail(long cid);
}
