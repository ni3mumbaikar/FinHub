package herokuapp.com.finhublti.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import herokuapp.com.finhublti.models.Address;
import herokuapp.com.finhublti.repositories.AddressRepository;

@SpringBootTest
class AddressControllerTest{

	@Autowired
	AddressRepository arepo;
	
	@Test
	void testGetCustomer() {
		Address a= new Address();
		a.setCity("yanam");
		a.setCustid(2);
		a.setDist("east godavari");
		a.setLandmark("old busstand");
		a.setPincode(533464);
		a.setState("puducherry");
		a.setStreet("ravindra nagar");
		arepo.save(a);
		assertNotNull(arepo.findByCustid(2L).get());
        assertEquals(a.getPincode(),arepo.findByCustid(2L).get().get(0).getPincode());
	}

}


/***@RunWith(SpringRunner.class)
@WebMvcTest(AddressController.class)
class AddressControllerTest{

	@Autowired
	  private MockMvc mockMvc;

	  @MockBean
	  private AddressController ac;

	  Address a = new Address();

      List allArrivals = singletonList(a);

      given(ac.GetCustomers()).willReturn(allArrivals);

      mvc.perform(get(VERSION + a + "all")
              .with(user("blaze").password("Q1w2e3r4"))
              .contentType(APPLICATION_JSON))
              .andExpect(status().isOk())
              .andExpect(jsonPath("$", hasSize(1)))
              .andExpect(jsonPath("$[0].city", is(arrival.getCity())));
  }

  private List singletonList(Address a2) {
		// TODO Auto-generated method stub
		return null;
	}

@Test
  public void getArrivalsById() throws Exception {
      Arrival arrival = new Arrival();
      arrival.setCity("Yerevan");

      given(arrivalController.getArrivalById(arrival.getId())).willReturn(arrival);

      mvc.perform(get(VERSION + ARRIVAL + arrival.getId())
              .with(user("blaze").password("Q1w2e3r4"))
              .contentType(APPLICATION_JSON))
              .andExpect(status().isOk())
              .andExpect(jsonPath("city", is(arrival.getCity())));
  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  @Test
	  void whenValidInput_thenReturns200() throws Exception {
	    mockMvc.perform(null);
	  }

	
	@Test
	void testGetCustomers() {
		mockMvc.perform(get("/address")).contentType("");
	}

	@Test
	void testGetCustomer() {
		
	}

}
***/