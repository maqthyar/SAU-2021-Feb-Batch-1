package com.example.au.couchbasedemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.au.couchbasedemo.model.Bms;
import com.example.au.couchbasedemo.repository.BmsRepository;

@RestController
public class BmsController {
    
    @Autowired
    BmsRepository bmsRepository;
    
	/*
	 * @RequestMapping("/") public String index() { return
	 * "Welcome to the CRUD application!!"; }
	 */
    
    @PostMapping("/bookmyshow")
    public Bms addMovie(@RequestBody Bms movie) {
        return bmsRepository.save(movie);
    }
    
    @GetMapping("/bookmyshow/{id}")
    public Optional<Bms> getMovie(@PathVariable String id) {
        if (bmsRepository.existsById(id)) {
            return bmsRepository.findById(id);
        } else
            return Optional.empty();
    }
    
    @GetMapping("/bookmyshow/movies/{movie}")
    public Bms getMovieByName(@PathVariable String movie) {
        return bmsRepository.findByName(movie);
    }
    
    
    @DeleteMapping("/bookmyshow/{id}")
    public void deleteById(@PathVariable String id) {
    	bmsRepository.deleteById(id);
    }

    @GetMapping("/bookmyshow/city/{city}")
    public List<Bms> getMoviesByCityName(@PathVariable String city) {
        List<Bms> BmsArr = new ArrayList<>();
        bmsRepository.findAll().forEach(Bms -> {
            List<String> showCities = Bms.getCity();
            if (showCities.contains(city)) {
                BmsArr.add(Bms);
            }
        });

        return BmsArr;
    }

}