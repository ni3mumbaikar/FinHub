package herokuapp.com.finhublti.repositories;

import herokuapp.com.finhublti.models.Documents;
import herokuapp.com.finhublti.models.Documents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface DocumentRepository extends JpaRepository<Documents, Long> {

}
