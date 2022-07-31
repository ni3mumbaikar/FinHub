package herokuapp.com.finhublti.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import herokuapp.com.finhublti.models.Customer;

@Service
public class CustDaoImpl implements CustDao {
	
	 @Autowired
	    private JdbcTemplate jdbcTemplate;


	    @Override
	    public List<Customer> getCustomers() {
	        String sql = "SELECT * FROM customers";
	        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Customer.class));
	    }

	    @Override

	    public Customer getCustomer(long custid) {

	        String sql = "SELECT * FROM CUSTOMERS WHERE CUSTID=" + custid;
	        return (Customer) jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(Customer.class));

	    }

}
