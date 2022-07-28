package herokuapp.com.finhublti.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import herokuapp.com.finhublti.models.Bank;
import herokuapp.com.finhublti.models.Customer;

@Service
public class BankDaoImpl implements BankDao{
	 @Autowired
	    private JdbcTemplate jdbcTemplate;


	    @Override
	    public List<Bank> getBankDetails(){
	        String sql = "SELECT * FROM bank";
	        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Bank.class));
	    }

	    @Override

	    public Bank getBankDetail(long cid) {

	        String sql = "SELECT * FROM bank WHERE CUST_ID=" + cid;
	        return (Bank) jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(Bank.class));

	    }

}
