package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Tour;
import com.example.services.TourManager;


@RestController
public class TourController {
	
	@Autowired
	private TourManager manager; 
	
	
	@PostMapping(value = "api/tour")
	public void add(@RequestBody Tour tour) {
		manager.add(tour); 
	}
	
	@PostMapping(value = "api/tours")
	public void addTours(@RequestBody List<Tour> tour) {
		 manager.addTours(tour); 
	}
	
	@GetMapping(value = "api/tours")
	public List<Tour> viewAll() {
		return manager.viewAll(); 
	}
	
	@GetMapping(value = "api/tours/{type}")
	public List<Tour> findByType(@PathVariable String type) {
		return manager.findByType(type);  
	}
	
	
	@PutMapping(value = "api/tour/{price}/{id}")
	public void add(@PathVariable double price, @PathVariable int id) {
		manager.updatePrice(price, id);   
	}
	
	
	@PutMapping(value = "api/tour/change-name/{name}/{id}")
	public void add(@PathVariable String name, @PathVariable int id) {
		manager.updateName(name, id);   
	}
	
	
	@GetMapping(value = "api/tours/price-less-than-duration-greater-than/{price}/{duration}")
	public List<Tour> findByPriceAndDuration(@PathVariable double price, @PathVariable int duration) {
		return manager.findByPriceAndDuration(price, duration); 
	}
	
	
	@GetMapping(value = "api/tours/by-type-and-price-less-than/{type}/{price}")
	public List<Tour> findByTypeAndCost(@PathVariable String type, @PathVariable double price) {
		return manager.findByTypeAndCost(type, price); 
	}
	
	
	
}
