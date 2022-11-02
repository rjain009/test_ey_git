package com.example.demo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Vendor;
import com.example.demo.services.VendorService;

@RestController
public class VendorController {
	
	
	@Autowired
	VendorService vendorService;
	
	@RequestMapping("/vendors")
	//GET_ENTITY_SET function in DPC Extension class
	public List<Vendor> getVendor(){
		return vendorService.getVendor();
	}
	
	@RequestMapping("/vendors/{vendorId}")
	//GET_ENTITY function where we pass key and get single record
	public Vendor getVendorById(@PathVariable("vendorId") String code) {
		return vendorService.getVendorById(code);
	}
	
	@PostMapping("/vendor")
	public Vendor createVendor(@RequestBody Vendor vendorrec) {
		return vendorService.createVendor(vendorrec);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="vendor")
	public Vendor updateVendor(@RequestBody Vendor vendorrec) {
		return vendorService.updateVendor(vendorrec);
	}

	
	
	
}
