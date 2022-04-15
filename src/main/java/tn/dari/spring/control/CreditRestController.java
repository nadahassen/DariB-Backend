package tn.dari.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import tn.dari.spring.entity.Credit;
import tn.dari.spring.service.CreditService;


@RestController
@Api(tags="Gestion des credits")
@RequestMapping("/credit")
public class CreditRestController {
	

	@Autowired
	CreditService creditService;
	
	//http://localhost:8081/SpringMVC/servlet/retrieve-all-credits
	@GetMapping("/retrieve-all-credits")	
	@ResponseBody
	public List<Credit> retrieveAllCredits(){
		List<Credit> list = creditService.retrieveAllCredits();
		return list;
	}
	
	//http://localhost:8081/SpringMVC/servlet/add-credit
	@PostMapping("/add-credit")
	@ResponseBody
	public Credit addCredit(@RequestBody Credit c) {
		return creditService.addCredit(c);
	}
	
	//http://localhost:8081/SpringMVC/servlet/delete-credit/{id}
	@DeleteMapping("/delete-credit/{id}")
	@ResponseBody
	public void deleteCredit(@PathVariable("id") Long id) {
		creditService.deleteCredit(id);
	}
	
	//http://localhost:8081/SpringMVC/servlet/retrieveCredit/{id}
	@GetMapping("/retrieveCredit/{id}")
	@ResponseBody
	public Credit retrieveCredit(@PathVariable("id") Long id) {
		return creditService.retrieveCreditById(id);
	}


}
