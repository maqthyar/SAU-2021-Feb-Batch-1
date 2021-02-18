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

import com.example.au.couchbasedemo.model.Football;
import com.example.au.couchbasedemo.repository.FootballRepository;

@RestController
public class FootballController {
    
    @Autowired
    FootballRepository footRepo;
    
	/*
	 * @RequestMapping("/") public String index() { return
	 * "Welcome to the CRUD application!!"; }
	 */
    
    @GetMapping("/football/special")
    public List<Football> specialPlayer() {
        List<Football> playerList = new ArrayList<>();
        footRepo.findAll().forEach(Football -> {
            Integer numberOfGoals = Football.getNOG();
            if (numberOfGoals >= 10) {
                playerList.add(Football);
            }
        });

        return playerList;
    }
    
    @GetMapping("/football/{id}")
    public Optional<Football> getMovie(@PathVariable String id) 
    {
        if (footRepo.existsById(id)) {
            return footRepo.findById(id);
        } else
            return Optional.empty();
    }
    
    
    
    @PostMapping("/football")
    public Football addPlayer(@RequestBody Football name) 
    {
        return footRepo.save(name);
    }
    
    
    
    
    
    @DeleteMapping("/football/{id}")
    public void deleteById(@PathVariable String id) {
    	footRepo.deleteById(id);
    }

   

}