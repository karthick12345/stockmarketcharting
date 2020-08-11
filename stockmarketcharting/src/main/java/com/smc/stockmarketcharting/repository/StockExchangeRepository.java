package com.smc.stockmarketcharting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smc.stockmarketcharting.model.StockExchange;

public interface StockExchangeRepository extends JpaRepository<StockExchange, Integer> {

}
