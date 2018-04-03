package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.model.Account;

public interface ShipwreckRepository extends JpaRepository<Account,Long>
{
	
}
