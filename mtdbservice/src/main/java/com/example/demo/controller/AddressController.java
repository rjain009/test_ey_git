package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Address;
import com.example.demo.services.AddressService;

@RestController
public class AddressController {
	
	
	@Autowired
	AddressService addSrv;
	
	@RequestMapping("/addresses")
	public List<Address> getAddress(){
		return addSrv.getAddresses();
	}
	
	@PostMapping("/address")
	public Address createAddress(@RequestBody Address payload){
		return addSrv.createAddress(payload);
	}
	
}