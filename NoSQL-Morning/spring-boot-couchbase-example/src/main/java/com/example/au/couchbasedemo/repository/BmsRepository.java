package com.example.au.couchbasedemo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.au.couchbasedemo.model.Bms;

public interface BmsRepository extends CrudRepository<Bms, String> {
	
	Bms findByName(String name);


}