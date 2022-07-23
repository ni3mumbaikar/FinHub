package herokuapp.com.finhublti.dao;

import herokuapp.com.finhublti.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Product> getProducts() {
        String sql = "SELECT * FROM products";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Product.class));
    }

    @Override

    public Product getProduct(long pid) {

        String sql = "SELECT * FROM PRODUCTS WHERE PID=" + pid;
        return (Product) jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(Product.class));

    }

}
