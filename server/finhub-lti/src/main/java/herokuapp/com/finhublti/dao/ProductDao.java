package herokuapp.com.finhublti.dao;

import herokuapp.com.finhublti.models.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getProducts();
    Product getProduct(long pid);
}
