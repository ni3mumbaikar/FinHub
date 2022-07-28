package herokuapp.com.finhublti.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import herokuapp.com.finhublti.models.Documents;

@Service
public class DocDaoimpl implements DocDao {
	 @Autowired
	    private JdbcTemplate jdbcTemplate;


	    @Override
	    public List<Documents> getDocuments(){
	        String sql = "SELECT * FROM documents";
	        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Documents.class));
	    }

	    @Override

	    public Documents getDocument(long cust_id) {

	        String sql = "SELECT * FROM documents WHERE CUST_ID=" + cust_id;
	        return (Documents) jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(Documents.class));

	    }
}
