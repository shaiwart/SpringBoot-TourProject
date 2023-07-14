package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Tour;
import com.example.repositories.TourRepository;

@Service
public class TourManagerImpl implements TourManager {

	@Autowired
	private TourRepository trepository; 
	
	@Override
	public void add(Tour tour) {
		trepository.save(tour); 

	}
	
	@Override
	public void addTours(List<Tour> tour) {
		trepository.saveAll(tour); 
	}

	@Override
	public List<Tour> viewAll() {
		return trepository.findAll(); 
	}

	@Override
	public List<Tour> findByType(String type) {
		return trepository.findByType(type); 
	}

	@Override
	public void updatePrice(double price, int id) {
		trepository.updatePrice(price, id);
		
	}

	@Override
	public void updateName(String name, int id) {
		trepository.updateName(name, id); 
		
	}

	@Override
	public List<Tour> findByPriceAndDuration(double price, int duration) {
		return trepository.findByCostLessThanAndDurationGreaterThan(price, duration);
	}

	@Override
	public
	List<Tour> findByTypeAndCost(String type, double price) {
		return trepository.findByTypeAndCostLessThan(type, price); 
	}

	

}
