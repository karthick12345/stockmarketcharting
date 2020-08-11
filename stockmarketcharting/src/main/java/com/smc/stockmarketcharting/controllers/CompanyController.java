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

import com.smc.stockmarketcharting.model.Company;
import com.smc.stockmarketcharting.services.CompanyService;

@RestController
@CrossOrigin()
@RequestMapping(path="/company")
public class CompanyController {
	
	
	@Autowired
	CompanyService companyService;
	
	
	@GetMapping("/all")
	public @ResponseBody Iterable<Company> getAllCompany()
	{
		System.out.println("all company data fetch");
		return companyService.getAllCompany();
	}
	@GetMapping("/companybyid/{id}")
	private @ResponseBody Company getCompany(@PathVariable Integer id)
	{
		return companyService.getCompanyById(id);
	}
	
	@DeleteMapping("/delete/{companyid}")  
	private @ResponseBody void deleteCompany(@PathVariable int companyid)   
	{   	
		System.out.println(companyid+" "+"Company deleted");
		companyService.deleteCompany(companyid);  
	}
	
	@PostMapping("/add")  
	private @ResponseBody void saveCompany(@RequestBody Company company)   
	{  
		System.out.println(company.getCompanyname()+" "+"Company added");
		companyService.saveOrUpdate(company);  
	// return "saved";
	}
	
	@PutMapping("/update")  
	private @ResponseBody Company updateCompany(@RequestBody Company company)   
	{  
	System.out.println(company.getCompanyname()+" "+"Company updated");
	companyService.saveOrUpdate(company);
	return company;
	}

	@PostMapping("/companybyName")
	private @ResponseBody Company getCompanyName(@PathVariable String compname)
	{
		return companyService.getCompanyByName(compname);
	}
	
}
