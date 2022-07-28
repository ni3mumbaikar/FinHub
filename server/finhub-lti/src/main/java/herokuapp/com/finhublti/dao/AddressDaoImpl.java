package herokuapp.com.finhublti.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import herokuapp.com.finhublti.models.Address;
import herokuapp.com.finhublti.models.Bank;

@Service
public class AddressDaoImpl implements AddressDao{

	 @Autowired
	    private JdbcTemplate jdbcTemplate;


	    @Override
	    public List<Address> getaddrs(){
	        String sql = "SELECT * FROM address";
	        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Address.class));
	    }

	    @Override

	    public Address getaddr(long cid) {

	        String sql = "SELECT * FROM address WHERE CUST_ID=" + cid;
	        return (Address) jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(Address.class));

	    }

}
