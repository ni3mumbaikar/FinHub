package herokuapp.com.finhublti.repositories;

import herokuapp.com.finhublti.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {

}
