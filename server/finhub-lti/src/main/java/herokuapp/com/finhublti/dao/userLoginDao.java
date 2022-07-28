package herokuapp.com.finhublti.dao;

import java.util.List;

import herokuapp.com.finhublti.models.Customer;

public interface userLoginDao {

	Boolean getUser(String username, String password);
}
