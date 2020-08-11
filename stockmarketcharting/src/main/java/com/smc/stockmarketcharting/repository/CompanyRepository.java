package com.smc.stockmarketcharting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smc.stockmarketcharting.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

	//Company findStockcodeByCompanynameAndIslisted(String compname,String Stockexchange);
	Company findStockcodeByCompanyname(String compname);

}
