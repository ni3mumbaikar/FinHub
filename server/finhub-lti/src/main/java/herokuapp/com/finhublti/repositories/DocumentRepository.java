package herokuapp.com.finhublti.repositories;

import herokuapp.com.finhublti.models.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
    Optional<List<Document>> findByCustid(long custid);
}
