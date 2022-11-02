package com.example.demo.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entities.Vendor;

@Component
public class VendorService {
	//data: lt_tab type table of lfa1.
//		HashMap<String, Vendor> vendors = new HashMap<String, Vendor>();
//		@Autowired
//		Vendor x;
//		@Autowired
//		Vendor y;
//		@Autowired
//		Vendor z;
		
		@Autowired
		private IVendorPersistence vendorDB;
		
		public List<Vendor> getVendor(){
			//fillVendor();
			return vendorDB.findAll();
		}
		
		public Vendor getVendorById(String code) {
			//fillVendor();
			Optional<Vendor> searchResult = vendorDB.findById(code);
			if(!searchResult.isPresent()) {
				return new Vendor("NOTFOUND","","","","","", "", null);
			}
			return searchResult.get();
			
		}
		
		public Vendor createVendor(Vendor vendorrec) {
			vendorrec.setCode("NEW1");
			//TODO: Later insert data to database
			return vendorDB.save(vendorrec);
		}
		
		public Vendor updateVendor(Vendor vendorrec) {
			vendorrec.setRegDate(new Date());
			return vendorrec;
		}
		
		//Like a function module which prepares the data
//		public void fillVendor() {
//			// TODO Auto-generated method stub
//			//Append WA to Itab
//			vendors.put("1", x);
//			vendors.put("2", y);
//			vendors.put("3", z);
//		}	
}
