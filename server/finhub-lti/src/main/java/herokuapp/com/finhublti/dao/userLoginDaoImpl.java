package herokuapp.com.finhublti.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import herokuapp.com.finhublti.models.Customer;

@Service
public class userLoginDaoImpl implements userLoginDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override

	public Boolean getUser(String username, String password) {

		String sql = "select count(*) from ( SELECT * FROM CUSTOMERS WHERE username = '\" + username + \"' and password='\"\n" +
				"\t\t\t\t+ password + \"')";
		int c = (Integer) jdbcTemplate.queryForObject(sql, Integer.class);
		return (c != 0);

	}

}
