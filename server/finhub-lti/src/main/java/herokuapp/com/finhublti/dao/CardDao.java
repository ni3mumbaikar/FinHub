package herokuapp.com.finhublti.dao;

import java.util.List;

import herokuapp.com.finhublti.models.card;



public interface CardDao {

List<card> getCards();
	
	card getCard(long cid);
}
