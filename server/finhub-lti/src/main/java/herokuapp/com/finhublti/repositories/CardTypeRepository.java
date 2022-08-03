package herokuapp.com.finhublti.repositories;

import herokuapp.com.finhublti.models.CardType;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CardTypeRepository extends JpaRepository<CardType, Integer> {

}
