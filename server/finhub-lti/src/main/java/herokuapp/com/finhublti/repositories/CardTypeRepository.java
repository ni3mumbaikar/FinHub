package herokuapp.com.finhublti.repositories;

import herokuapp.com.finhublti.models.CardType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardTypeRepository extends JpaRepository<CardType, Integer> {
}
