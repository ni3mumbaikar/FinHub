package herokuapp.com.finhublti.dao;

import java.util.List;

import herokuapp.com.finhublti.models.Documents;

public interface DocDao {

	List<Documents> getDocuments();
	Documents getDocument(long cust_id);
}
