package com.smc.stockmarketcharting.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smc.stockmarketcharting.model.IPODetail;
import com.smc.stockmarketcharting.repository.IPODetailRepository;

@Service
public class IPODetailService {

	
	@Autowired
	IPODetailRepository ipoDetailRepository;

	public Iterable<IPODetail> getAllIPO() {
		// TODO Auto-generated method stub
		return ipoDetailRepository.findAll();
	}

	public IPODetail getIPOById(Integer id) {
		// TODO Auto-generated method stub
		return ipoDetailRepository.findById(id).get();
	}

	public void deleteIPO(int ipoid) {
		// TODO Auto-generated method stub
		ipoDetailRepository.deleteById(ipoid);
	}

	public void saveOrUpdate(IPODetail ipodetail) {
		// TODO Auto-generated method stub
		ipoDetailRepository.save(ipodetail);
	}
	
	
}
