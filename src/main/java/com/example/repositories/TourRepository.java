package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entities.Tour;

import jakarta.transaction.Transactional;


@Transactional
@Repository
public interface TourRepository extends JpaRepository<Tour, Integer> {
	
	
	@Modifying
	@Query(value = "update tour set cost = :cost where t_id= :myid", nativeQuery = true)
	void updatePrice(@Param("cost") double cost, @Param("myid") int id); 
	
	
	List<Tour> findByType(String type); 
	
	
	
	@Modifying
	@Query("update Tour t set t.name = :name where t.t_id = :id")
	void updateName(@Param("name") String name, @Param("id") int id); 
	
	
	
	List<Tour> findByCostLessThanAndDurationGreaterThan(double price, int duration);  
	
	
	
	List<Tour> findByTypeAndCostLessThan(String type, double cost); 
}
