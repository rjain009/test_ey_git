package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Address;

@Component
public class AddressService {
	
	@Autowired
	IAddressPersistence addressDB;
	
	public List<Address> getAddresses(){
		return addressDB.findAll();
	}
	
	public Address createAddress(Address payload) {
		return addressDB.save(payload);
	}
	
}