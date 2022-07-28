package herokuapp.com.finhublti.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import herokuapp.com.finhublti.models.Bank;
import herokuapp.com.finhublti.models.CardType;

@Service
public class CardTypeDaoImpl implements CardTypeDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<CardType> getCardDetails() {
		String sql = "SELECT * FROM CARDS";
		return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(CardType.class));
	}

	@Override

	public CardType getCardDetail(int cid) {

		String sql = "SELECT * FROM CARDS WHERE CARD_TYPE=" + cid;
		return (CardType) jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(CardType.class));

	}

}
