package com.smc.stockmarketcharting.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smc.stockmarketcharting.model.StockPrice;

public interface StockPriceRepository extends JpaRepository<StockPrice, Integer> {

	List<StockPrice> findAllByCompanycodeAndDateBetween(String companycode,Date date,Date date1);
	
}
