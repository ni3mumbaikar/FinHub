package herokuapp.com.finhublti.repositories;

import herokuapp.com.finhublti.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardsRepository extends JpaRepository<Card, Long> {

}
