package com.boot.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.Account;
import com.boot.repository.ShipwreckRepository;

@RestController
@RequestMapping("api/v1")
public class ShipwreckController 
{
	@Autowired
	private ShipwreckRepository shipRepo;
	
	@RequestMapping(value = "shipwrecks", method = RequestMethod.GET)
	public List<Account> list()
	{
		return shipRepo.findAll();
	}
	
	@RequestMapping(value = "shipwrecks", method = RequestMethod.POST)
	public Account create(@RequestBody Account shipwreck)
	{
		return shipRepo.saveAndFlush(shipwreck);
	}
	
	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.GET)
	public Account get(@PathVariable Long id)
	{
		return shipRepo.findOne(id);
	}
	
	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.PUT)
	public Account update(@PathVariable Long id, @RequestBody Account shipwreck)
	{
		Account existingWreck = shipRepo.findOne(id);
		BeanUtils.copyProperties(shipwreck, existingWreck);
		return shipRepo.saveAndFlush(existingWreck);
	}
	
	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.DELETE)
	public Account delete(@PathVariable Long id)
	{
		Account existingWreck = shipRepo.findOne(id);
		shipRepo.delete(existingWreck);		
		return existingWreck;
	}
}
