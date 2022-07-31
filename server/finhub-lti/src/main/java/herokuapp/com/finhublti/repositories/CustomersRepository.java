package herokuapp.com.finhublti.repositories;

import herokuapp.com.finhublti.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<Customer,Long> {
}
