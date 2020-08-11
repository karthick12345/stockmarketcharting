package com.smc.stockmarketcharting.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smc.stockmarketcharting.model.StockExchange;
import com.smc.stockmarketcharting.repository.StockExchangeRepository;

@Service
public class StockExchangeService {

	@Autowired
	StockExchangeRepository stockExchangeRepository;

	public Iterable<StockExchange> getAllStockExchange() {
		// TODO Auto-generated method stub
		return stockExchangeRepository.findAll();
	}

	public StockExchange getStockExchange(Integer id) {
		// TODO Auto-generated method stub
		return stockExchangeRepository.findById(id).get();
	}

	public void deleteStockExchange(int id) {
		// TODO Auto-generated method stub
		stockExchangeRepository.deleteById(id);
	}

	public void saveOrUpdate(StockExchange stockExchange) {
		// TODO Auto-generated method stub
		stockExchangeRepository.save(stockExchange);
	}
	
}
