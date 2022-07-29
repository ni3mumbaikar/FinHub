package herokuapp.com.finhublti.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import herokuapp.com.finhublti.models.card;



@Service
public class CardDaoImpl implements CardDao {

	 @Autowired
	    private JdbcTemplate jdbcTemplate;


	    @Override
	    public List<card> getCards() {
	        String sql = "SELECT * FROM card_info";
	        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(card.class));
	    }

	    @Override

	    public card getCard(long cust_id) {

	        String sql = "SELECT * FROM card_info WHERE CUST_ID=" + cust_id;
	        return (card) jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(card.class));

	    }

}
