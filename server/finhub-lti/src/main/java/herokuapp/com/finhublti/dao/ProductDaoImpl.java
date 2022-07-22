package herokuapp.com.finhublti.dao;

import herokuapp.com.finhublti.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    List<Product> products;

    @Override
    public List<Product> getProducts() {
        String sql = "SELECT * FROM products";
        products = jdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(Product.class));
        return products;
    }

    @Override
    public Product getProduct(long pid) {
        return null;
    }

}
