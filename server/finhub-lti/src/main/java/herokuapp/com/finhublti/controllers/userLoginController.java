package herokuapp.com.finhublti.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import herokuapp.com.finhublti.dao.userLoginDao;
import herokuapp.com.finhublti.models.Customer;

public class userLoginController {
	@Autowired
	userLoginDao cd;

	@GetMapping("/users")
	public Boolean getUser(@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password) {
		return cd.getUser(username, password);
	}

}
