package herokuapp.com.finhublti.controllers;

import herokuapp.com.finhublti.models.Documents;
import herokuapp.com.finhublti.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
public class DocController {

    @Autowired
    DocumentRepository documentRepository;

    @GetMapping("/documents")
    public ResponseEntity<List<Documents>> getDocuments() {
        return new ResponseEntity<>(documentRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/documents/{did}")
    public ResponseEntity<Documents> getDocument(@PathVariable String did) {
        try {
            Optional<Documents> productData = documentRepository.findById(Long.parseLong(did));
            if (productData.isPresent()) {
                return new ResponseEntity<>(productData.get(), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (NumberFormatException numberFormatException) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
