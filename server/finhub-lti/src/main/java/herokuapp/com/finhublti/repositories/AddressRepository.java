package herokuapp.com.finhublti.repositories;

import herokuapp.com.finhublti.models.Address;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {


	Optional<List<Address>> findByCustid(long i);

}
