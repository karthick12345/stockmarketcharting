package com.smc.stockmarketcharting.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smc.stockmarketcharting.model.StockPrice;
import com.smc.stockmarketcharting.repository.StockPriceRepository;

@Service
public class StockPriceService {

	@Autowired
	StockPriceRepository stockPriceRepository;

	public Iterable<StockPrice> getAllStockPrice() {
		// TODO Auto-generated method stub
		return stockPriceRepository.findAll();
	}

	public StockPrice getStockPriceById(Integer id) {
		// TODO Auto-generated method stub
		return stockPriceRepository.findById(id).get();
	}

	public void deleteStockPrice(int id) {
		// TODO Auto-generated method stub
		stockPriceRepository.deleteById(id);
	}

	public void saveOrUpdate(StockPrice stockPrice) {
		// TODO Auto-generated method stub
		stockPriceRepository.save(stockPrice);
	}
	
}
