package herokuapp.com.finhublti.controllers;

import herokuapp.com.finhublti.models.Document;
import herokuapp.com.finhublti.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class DocController {

    @Autowired
    DocumentService documentService;

    @GetMapping("/documents")
    public ResponseEntity<List<Document>> getDocuments() {
        return documentService.getDocuments();
    }

    @GetMapping("/documents/{did}")
    public ResponseEntity<Document> getDocument(@PathVariable String did) {
        return documentService.getDocument(did);
    }

    @DeleteMapping("/documents/{did}")
    public HttpStatus removeDocument(@PathVariable String did){
        return documentService.delete(Long.parseLong(did));
    }

    @PostMapping("/documents")
    public HttpStatus insertDocument(@RequestBody Document doc) {
        return documentService.add(doc);
    }

    @PutMapping("/documents/{uid}/vAadhar")
    public HttpStatus updateAadhar (@PathVariable String uid, @RequestParam String appStatus){
        return documentService.updateAadhar(uid, appStatus);
    }


    @PutMapping("/documents/{uid}/vPan")
    public HttpStatus updatePan (@PathVariable String uid, @RequestParam String appStatus){
        return documentService.updatePan(uid, appStatus);
    }
    

    @PutMapping("/documents/{uid}/vBank_info")
    public HttpStatus updateBank_info (@PathVariable String uid, @RequestParam String appStatus){
        return documentService.updateBank_info(uid, appStatus);
    }
    

    @PutMapping("/documents/{uid}/vPhoto")
    public HttpStatus updatePhoto (@PathVariable String uid, @RequestParam String appStatus){
        return documentService.updatePhoto(uid, appStatus);
    }


}
