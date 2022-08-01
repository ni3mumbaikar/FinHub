package herokuapp.com.finhublti.repositories;

import herokuapp.com.finhublti.models.Customer;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<Customer,Long> {
	Optional<List<Customer>> findByUsername(String custid);
}
