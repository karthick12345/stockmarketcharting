package com.smc.stockmarketcharting.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smc.stockmarketcharting.dto.StockPriceDto;
import com.smc.stockmarketcharting.model.Company;
import com.smc.stockmarketcharting.model.StockPrice;
import com.smc.stockmarketcharting.model.User;
import com.smc.stockmarketcharting.repository.CompanyRepository;
import com.smc.stockmarketcharting.repository.StockPriceRepository;
import com.smc.stockmarketcharting.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CompanyRepository companyrepository;
	
	@Autowired
	StockPriceRepository stockpricerepository;

	public Iterable<User> getAllUser() {
		// TODO Auto-generated method stub	
		return userRepository.findAll();
	}

	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
	}

	public void deleteUser(int userid) {
		// TODO Auto-generated method stub
		userRepository.deleteById(userid);
	}

	public void saveOrUpdate(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}
	
	public void update(User user,int id)
	{
		userRepository.save(user);
	}
	
	public String login(String type,int id,String pass){
		User u=userRepository.findById(id).get();
		if(u==null){
			return "no";
		}
		else{
		String p=u.getPassword();
		if(pass.equals(p)){
			return "ok";
		}
		else
		return "no";
		}
	}
	
	
	  public @ResponseBody Iterable<StockPrice> getMapprice(@RequestBody StockPriceDto stock) {
		Company com = companyrepository.findStockcodeByCompanynameAndIslisted(stock.getCompany_name(),stock.getStock_exchange());
		//return price.findAll();
		return stockpricerepository.findAllByCompanycodeAndDateBetween(com.getStockcode()+" ",stock.getFromDate(),stock.getToDate());
	   //return "";//price.findAll();
	  }
	
}
