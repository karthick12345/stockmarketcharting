package com.smc.stockmarketcharting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.smc.stockmarketcharting.model.IPODetail;
import com.smc.stockmarketcharting.services.IPODetailService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/ipo")
public class IPODetailController {
	
	
	@Autowired
	IPODetailService ipodetailservice;
	
	@GetMapping("/all")
	public @ResponseBody Iterable<IPODetail> getAllIPO()
	{
		System.out.println("all IPO data fetch");
		return ipodetailservice.getAllIPO();
	}
	
	@GetMapping("/ipobyid/{id}")
	private @ResponseBody IPODetail getIPO(@PathVariable Integer id)
	{
		return ipodetailservice.getIPOById(id);
	}
	
	@DeleteMapping("/delete/{ipoid}")  
	private @ResponseBody void deleteIPO(@PathVariable int ipoid)   
	{  
		ipodetailservice.deleteIPO(ipoid);  
	} 
	
	@PostMapping("/add")  
	private @ResponseBody void saveIPO(@RequestBody IPODetail ipodetail)   
	{  
		System.out.println("IPO added");
		ipodetailservice.saveOrUpdate(ipodetail);  
	// return "saved";
	}
	
	@PutMapping("/update")  
	private @ResponseBody IPODetail updateIPO(@RequestBody IPODetail ipodetail)   
	{  
		ipodetailservice.saveOrUpdate(ipodetail);  
	return ipodetail;  
	}
	

}
