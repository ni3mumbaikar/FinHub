package herokuapp.com.finhublti.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import herokuapp.com.finhublti.models.Product;
import herokuapp.com.finhublti.repositories.ProductRepository;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProductsControllerTest {
	@Autowired
	 ProductRepository arepo;
	

	 Product a= new Product();
	@BeforeAll
	 void befinit() {
		System.out.print("hi");
		a.setIs3(1);
		a.setIs6(0);
		a.setIs9(0);
		a.setIs12(0);
		a.setPdesc("white ball");
		a.setPid(205L);
		a.setPimage("https://www.prodirectsoccer.com/ProductImages/Main/269498_Main_Thumb_1183120.jpg");
		a.setPname("ball");
		a.setPrice(500);
		arepo.save(a);
	}

	
	@Test
	void testGetProducts() {
			assertNotNull(arepo.findBypid(205L).get());
	        assertEquals(a.getPname(),arepo.findBypid(205L).get().get(0).getPname());
	        
		}
	
	@AfterAll
	 void aftinit() {
		arepo.deleteById(205);
	}
	

}

