package herokuapp.com.finhublti.controllers;

import herokuapp.com.finhublti.dao.ProductDao;
import herokuapp.com.finhublti.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class ProductsController {
    @Autowired
    ProductDao productDao;

    @GetMapping("/products")
    public List<Product> getProducts(){
        return  productDao.getProducts();
    }

    @GetMapping("/products/{pid}")
    public Product getProduct(@PathVariable String pid){
        System.out.println("pid request : " + pid);
        return productDao.getProduct(Long.parseLong(pid));
    }

}
