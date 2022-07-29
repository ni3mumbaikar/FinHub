package herokuapp.com.finhublti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import herokuapp.com.finhublti.models.Transactions;

public interface TransactionsRepository extends JpaRepository<Transactions, Long> {

}
