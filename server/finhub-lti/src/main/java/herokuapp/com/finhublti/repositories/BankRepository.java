package herokuapp.com.finhublti.repositories;

import herokuapp.com.finhublti.models.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank,Long> {

}
