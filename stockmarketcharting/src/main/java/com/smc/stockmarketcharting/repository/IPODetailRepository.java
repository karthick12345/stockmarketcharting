package com.smc.stockmarketcharting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smc.stockmarketcharting.model.IPODetail;

public interface IPODetailRepository extends JpaRepository<IPODetail, Integer> {

}
