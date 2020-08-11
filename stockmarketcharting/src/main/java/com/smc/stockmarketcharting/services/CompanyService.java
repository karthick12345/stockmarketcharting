package com.smc.stockmarketcharting.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smc.stockmarketcharting.model.Company;
import com.smc.stockmarketcharting.repository.CompanyRepository;

@Service
public class CompanyService {

	
	@Autowired
	CompanyRepository companyRepository;

	public Iterable<Company> getAllCompany() {
		// TODO Auto-generated method stub
		return companyRepository.findAll();
	}

	public Company getCompanyById(Integer id) {
		// TODO Auto-generated method stub
		return companyRepository.findById(id).get();
	}

	public void deleteCompany(int companyid) {
		// TODO Auto-generated method stub
		companyRepository.deleteById(companyid);
	}

	public void saveOrUpdate(Company company) {
		// TODO Auto-generated method stub
		companyRepository.save(company);
	}

	public Company getCompanyByName(String name) {
		// TODO Auto-generated method stub
		return companyRepository.findStockcodeByCompanyname(name);
	}
	
	
	
	
}
