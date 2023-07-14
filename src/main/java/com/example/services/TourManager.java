package com.example.services;

import java.util.List;

import com.example.entities.Tour;

public interface TourManager {
	
	void add(Tour tour); 
	
	void addTours(List<Tour> tour); 
	
	List<Tour> viewAll(); 
	
	List<Tour> findByType(String type); 
	
	void updatePrice(double price, int id); 
	
	void updateName(String name, int id); 
	
	
	List<Tour> findByPriceAndDuration(double price, int duration); 
	
	
	List<Tour> findByTypeAndCost(String type, double price);
	
}
