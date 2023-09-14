 package com.example.flight_routes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.RouteMatcher.Route;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/routes")
public class AirlineRouteController {

 

	@Autowired
	AirlineRouteService airlineRouteService;
@Autowired
	AirlineRouteRepo ar;

	@GetMapping("/fetch-save")
	public List<AirlineRoute> fetchAllAirlineRoute() {
		return airlineRouteService.getAllAirlineRoutes();
	}
	 @GetMapping("/getAll")
	    public ResponseEntity<List<AirlineRoute>> getAllAirlines() {
	        List<AirlineRoute> airlines = airlineRouteService.getAllRoutes();
	        return  ResponseEntity.ok(airlines);
	    }
//	 @PostMapping("/best")
//	    public ResponseEntity<List<AirlineRoute>> getBestRecommendations(@RequestBody AirlineRoute request) {
//	        List<AirlineRoute> recommendations = airlineRouteService.getBestRecommendations(request);
//	        // Handle cases where no recommendations are found or other error handling as needed.
//	        return ResponseEntity.ok(recommendations);
//	    }
	@PostMapping("/best")
		public List<AirlineRoute> getRoute(@RequestBody AirlineRoute model){

			List<AirlineRoute> data = new ArrayList<>();
			List<Boolean> category = Arrays.asList(false, false, false);
			if (model.getClassType().equalsIgnoreCase("Business")) {
				category.set(0, true);
			} else if (model.getClassType().equalsIgnoreCase("Economy")) {
				category.set(1, true);
			} else if (model.getClassType().equalsIgnoreCase("first")) {
				category.set(2, true);
			}
			List<String> dayStatus = Arrays.asList("no", "no", "no", "no", "no", "no", "no");
			int day=model.getDate().getDayOfWeek().getValue();
			dayStatus.set(day - 1, "yes");
			for(AirlineRoute r: ar.findAll()) {

	 

				if((r.getIataFrom().equalsIgnoreCase(model.getIataFrom())) && (r.getIataTo().equalsIgnoreCase(model.getIataTo())) ) {

					if((r.getDay1().equals(dayStatus.get(0)) || r.getDay2().equals(dayStatus.get(1))
							|| r.getDay3().equals(dayStatus.get(2)) || r.getDay4().equals(dayStatus.get(3))
							|| r.getDay5().equals(dayStatus.get(4)) || r.getDay6().equals(dayStatus.get(5))
							|| r.getDay7().equals(dayStatus.get(6))&&
							(r.isClassBusiness() == category.get(0) || r.isClassEconomy() == category.get(1)
									 || r.isClassFirst() == category.get(2)))){
						data.add(r);

					}



				}
			}
			return data;

		}
	}
	 
	
