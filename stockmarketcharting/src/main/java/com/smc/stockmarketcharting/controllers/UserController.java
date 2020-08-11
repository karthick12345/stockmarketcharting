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

import com.smc.stockmarketcharting.dto.StockPriceDto;
import com.smc.stockmarketcharting.model.StockPrice;
import com.smc.stockmarketcharting.model.User;
import com.smc.stockmarketcharting.services.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/user")
public class UserController {

	@Autowired
	UserService userservice;
	
	@GetMapping("/all")
	public @ResponseBody Iterable<User> getAllUser()
	{
		System.out.println("all user data fetch");
		return userservice.getAllUser();
	}
	
	@GetMapping("/userbyid/{id}")
	private @ResponseBody User getUser(@PathVariable Integer id)
	{
		return userservice.getUserById(id);
	}
	
	@DeleteMapping("/delete/{userid}")  
	private @ResponseBody void deleteUser(@PathVariable int userid)   
	{
	userservice.deleteUser(userid);  
	}
	
	@PostMapping("/add")  
	private @ResponseBody String saveUser(@RequestBody User user)   
	{  
		System.out.println("user added");
	userservice.saveOrUpdate(user);  
	 return "Hai "+user.getUsername()+" you have registered successfully. Confirm your E-mail before login";
	}
	@PutMapping("/update")  
	private @ResponseBody User updateUser(@RequestBody User user)   
	{  
	userservice.saveOrUpdate(user);  
	return user;
	}
	
	// login credentials checking
	@PostMapping("/login")
	private @ResponseBody String login(@RequestBody User user)
	{
		//System.out.println("login Entered:  "+type+"  "+id+"  "+pass);
		String type=user.getUsertype();
		int id=user.getId();
		String pass=user.getPassword();
		if(type.equals("admin")){
			if(pass.equals("admin") && id==100){
				System.out.println("admin");
				return "admin";
			}
			else
				return "no";
		}
		else{
			System.out.println("user");
		return userservice.login(type,id,pass);
		}		
	}
	
	@GetMapping(path="/map")
	public @ResponseBody Iterable<StockPrice> getMapprice(@RequestBody StockPriceDto stock) {
		
		return userservice.getMapprice(stock);
	}
	
}