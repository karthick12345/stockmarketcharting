package com.smc.stockmarketcharting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smc.stockmarketcharting.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
