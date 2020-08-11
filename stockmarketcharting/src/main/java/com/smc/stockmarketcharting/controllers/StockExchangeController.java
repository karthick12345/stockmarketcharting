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

import com.smc.stockmarketcharting.model.StockExchange;
import com.smc.stockmarketcharting.services.StockExchangeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/stockexchange")
public class StockExchangeController {
	
	@Autowired
	StockExchangeService stockExchangeService;
	
	@GetMapping("/all")
	public @ResponseBody Iterable<StockExchange> getAllStockExchange()
	{
		System.out.println("all StockExchange data fetch");
		return stockExchangeService.getAllStockExchange();
	}
	
	@GetMapping("/stockexchangebyid/{id}")
	private @ResponseBody StockExchange getStockExchange(@PathVariable Integer id)
	{
		return stockExchangeService.getStockExchange(id);
	}
	
	@DeleteMapping("/delete/{id}")  
	private @ResponseBody void deleteStockExchange(@PathVariable int id)   
	{  
		stockExchangeService.deleteStockExchange(id);  
	} 
	
	@PostMapping("/add")  
	private @ResponseBody void saveStockExchange(@RequestBody StockExchange stockExchange)   
	{  
		System.out.println("stockexchange added");
		stockExchangeService.saveOrUpdate(stockExchange);  
	// return "saved";
	}
	
	@PutMapping("/update")  
	private @ResponseBody StockExchange updateStockExchange(@RequestBody StockExchange stockExchange)   
	{  
		stockExchangeService.saveOrUpdate(stockExchange);  
	return stockExchange;  
	}
	

}
