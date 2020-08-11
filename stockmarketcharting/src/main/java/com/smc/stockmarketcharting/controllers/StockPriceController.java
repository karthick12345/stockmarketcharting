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

import com.smc.stockmarketcharting.model.StockPrice;
import com.smc.stockmarketcharting.services.StockPriceService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/stockprice")
public class StockPriceController {

	@Autowired
	StockPriceService stockPriceService;
	
	@GetMapping("/all")
	public @ResponseBody Iterable<StockPrice> getAllStockPrice()
	{
		System.out.println("all Stockprice data fetch");
		return stockPriceService.getAllStockPrice();
	}
	
	@GetMapping("/userbyid/{id}")
	private @ResponseBody StockPrice getStockPrice(@PathVariable Integer id)
	{
		return stockPriceService.getStockPriceById(id);
	}
	
	@DeleteMapping("/delete/{id}")  
	private @ResponseBody void deleteStockPrice(@PathVariable int id)   
	{  
		stockPriceService.deleteStockPrice(id);  
	} 
	
	@PostMapping("/add")  
	private @ResponseBody void saveStockPrice(@RequestBody StockPrice stockPrice)   
	{  
		System.out.println("stockprice added");
		stockPriceService.saveOrUpdate(stockPrice);  
	// return "saved";
	}
	
	@PutMapping("/update")  
	private @ResponseBody StockPrice updateStockPrice(@RequestBody StockPrice stockPrice)   
	{  
		stockPriceService.saveOrUpdate(stockPrice);  
	return stockPrice;  
	}
}
