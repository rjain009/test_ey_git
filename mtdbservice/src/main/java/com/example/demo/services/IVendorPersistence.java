package com.example.demo.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Vendor;

public interface IVendorPersistence extends JpaRepository<Vendor, String> {

}
