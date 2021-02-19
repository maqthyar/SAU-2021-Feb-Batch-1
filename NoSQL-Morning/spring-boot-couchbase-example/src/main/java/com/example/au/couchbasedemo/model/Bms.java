package com.example.au.couchbasedemo.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import com.sun.istack.NotNull;

@Document
public class Bms {
    
    @Id
    String id;
    
    @NotNull
    @Field
    String name;
    
    
    @Field
    List<String> city;
    
    @Field
    Date date;

	public String getMovie() {
		return name;
	}

	public void setMovie(String name) {
		this.name = name;
	}

	public List<String> getCity() {
		return city;
	}

	public void setCity(List<String> tags) {
		this.city = tags;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public Bms(String id, String name,  List<String> city, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.date = date;
	}
    
    
    
}
