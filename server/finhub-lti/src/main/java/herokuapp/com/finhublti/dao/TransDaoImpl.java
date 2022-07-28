package herokuapp.com.finhublti.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import herokuapp.com.finhublti.models.Transactions;

@Service
public class TransDaoImpl implements TransDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Transactions> gettrans() {
		String sql = "SELECT * FROM transactions";
		return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Transactions.class));
	}

	@Override

	public Transactions gettran(long cid) {

		String sql = "SELECT * FROM transactions WHERE CUST_ID=" + cid;
		return (Transactions) jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(Transactions.class));

	}

}
