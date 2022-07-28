package herokuapp.com.finhublti.dao;

import java.util.List;

import herokuapp.com.finhublti.models.Transactions;

public interface TransDao {

	List<Transactions> gettrans();

	Transactions gettran(long cid);
}
