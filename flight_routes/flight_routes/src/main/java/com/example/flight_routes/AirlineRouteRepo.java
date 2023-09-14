package com.example.flight_routes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRouteRepo extends JpaRepository<AirlineRoute, Integer> {

	@Query("SELECT ar FROM AirlineRoute ar " +
	           "WHERE ar.iataFrom = :from " +
	           "AND ar.iataTo = :to " +
	           "AND ar.classBusiness = :business " +
	           "AND ar.classEconomy = :economy "+"AND ar.classFirst = :first " 
	          )
	    List<AirlineRoute> findBestRoutes(
	            String from,
	            String to,
	            boolean business,
	            boolean economy,
	            boolean first
	            
	    );
	

	 
	}


	
	
	
	

