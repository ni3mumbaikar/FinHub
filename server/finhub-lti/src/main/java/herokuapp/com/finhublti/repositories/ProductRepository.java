package herokuapp.com.finhublti.repositories;

import herokuapp.com.finhublti.models.Product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Optional<List<Product>> findBypid(long l);

	Optional<List<Product>> deleteById(long l);

}
