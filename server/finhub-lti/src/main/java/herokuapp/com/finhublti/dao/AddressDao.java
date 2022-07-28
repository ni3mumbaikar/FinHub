package herokuapp.com.finhublti.dao;

import java.util.List;

import herokuapp.com.finhublti.models.Address;

public interface AddressDao {

	List<Address>getaddrs();
	Address getaddr(long cid);
}
