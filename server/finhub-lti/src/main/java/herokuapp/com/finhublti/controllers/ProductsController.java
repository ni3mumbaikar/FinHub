package herokuapp.com.finhublti.controllers;

import herokuapp.com.finhublti.models.Product;
import herokuapp.com.finhublti.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class ProductsController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
        return  new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/products/{pid}")
    public ResponseEntity<Product> getProduct(@PathVariable String pid){
        try{
            Optional<Product> productData =  productRepository.findById(Long.parseLong(pid));
            if(productData.isPresent()){
                return new ResponseEntity<>(productData.get(),HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (NumberFormatException numberFormatException){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
