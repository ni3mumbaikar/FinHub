package herokuapp.com.finhublti.services;

import herokuapp.com.finhublti.models.Document;
import herokuapp.com.finhublti.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {
    @Autowired
    DocumentRepository documentRepository;

    @Transactional
    public HttpStatus add (Document document){
        documentRepository.save(document);
        return HttpStatus.OK;
    }

    @Transactional
    public HttpStatus delete(long id) {
        documentRepository.deleteById(id);
        return HttpStatus.OK;
    }

    public ResponseEntity<List<Document>> getDocuments() {
        return new ResponseEntity<>(documentRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Document> getDocument(String id) {
        try {
            Optional<Document> productData = documentRepository.findById(Long.parseLong(id));
            return productData.map(documents -> new ResponseEntity<>(documents, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (NumberFormatException numberFormatException) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public HttpStatus updateAadhar(String uid, String appStatus) {
        Optional<List<Document>> dlist = documentRepository.findByCustid(Long.parseLong(uid));
        if (dlist.isPresent()){
            Document d = dlist.get().get(0);
            d.setVaadhar(Long.parseLong(appStatus));
            documentRepository.save(d);
            return HttpStatus.OK;
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
    
    public HttpStatus updatePan(String uid, String appStatus) {
        Optional<List<Document>> dlist = documentRepository.findByCustid(Long.parseLong(uid));
        if (dlist.isPresent()){
            Document d = dlist.get().get(0);
            d.setVpan(Long.parseLong(appStatus));
            documentRepository.save(d);
            return HttpStatus.OK;
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
    
    public HttpStatus updateBank_info(String uid, String appStatus) {
        Optional<List<Document>> dlist = documentRepository.findByCustid(Long.parseLong(uid));
        if (dlist.isPresent()){
            Document d = dlist.get().get(0);
            d.setVbank_info(Long.parseLong(appStatus));
            documentRepository.save(d);
            return HttpStatus.OK;
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
    
    public HttpStatus updatePhoto(String uid, String appStatus) {
        Optional<List<Document>> dlist = documentRepository.findByCustid(Long.parseLong(uid));
        if (dlist.isPresent()){
            Document d = dlist.get().get(0);
            d.setVphoto(Long.parseLong(appStatus));
            documentRepository.save(d);
            return HttpStatus.OK;
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
