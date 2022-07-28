package herokuapp.com.finhublti.dao;

import java.util.List;

import herokuapp.com.finhublti.models.CardType;

public interface CardTypeDao {

	List<CardType> getCardDetails();

	CardType getCardDetail(int cid);
}
