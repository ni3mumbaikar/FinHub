package herokuapp.com.finhublti.repositories;

import herokuapp.com.finhublti.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
