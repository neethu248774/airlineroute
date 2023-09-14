package com.example.flight_routes;

import java.io.File;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AirlineRouteServiceImpl implements AirlineRouteService {

	@Autowired
	AirlineRouteRepo airlineRouteRepo;

 

	@Override
	public List<AirlineRoute> getAllAirlineRoutes() {
		List<AirlineRoute> dataList = new ArrayList<>();
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			// Specify the path to your JSON file
			File jsonFile = new File("src/main/resources/json/flightsDB.json");

 

			// Read JSON data into a List of MyJsonObject
			dataList = objectMapper.readValue(jsonFile, new TypeReference<List<AirlineRoute>>() {
			});

 

			// Now you can work with the 'dataList' which contains a list of JSON objects.
			for (AirlineRoute obj : dataList) {
				airlineRouteRepo.save(obj);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dataList;

 

	}



	@Override
	public List<AirlineRoute> getAllRoutes() {
		// TODO Auto-generated method stub
		return airlineRouteRepo.findAll();
	}



	@Override
	public List<AirlineRoute> getBestRecommendations(AirlineRoute request) {
		String iataFrom = request.getIataFrom();
        String iataTo = request.getIataTo();
        boolean classBusiness = request.isClassBusiness();
        boolean classEconomy = request.isClassEconomy();
       boolean classFirst=request.isClassFirst();
//        String day1 = request.getDay1();

        // Implement your query logic based on the provided parameters
        List<AirlineRoute> recommendations = airlineRouteRepo.findBestRoutes(iataFrom, iataTo, classBusiness, classEconomy, classFirst);

        return recommendations;
		
	}



	
//	public List<AirlineRoute> getBestRecommendations(AirlineRoute request) {
//		// TODO Auto-generated method stub
//		String iataFrom = request.getIataFrom();
//        String iataTo = request.getIataTo();
//        boolean classBusiness = request.isClassBusiness();
//        boolean classEconomy = request.isClassEconomy();
//       boolean classFirst=request.isClassFirst();
////        String day1 = request.getDay1();
//
//        // Implement your query logic based on the provided parameters
//        List<AirlineRoute> recommendations = airlineRouteRepo.findBestRoutes(iataFrom, iataTo, classBusiness, classEconomy, classFirst);
//
//        return recommendations;
//    }
//	@Override
//	public List<AirlineRoute> getBestRecommendations(AirlineRouteRequestDTO request) {
//		// TODO Auto-generated method stub
//		
//		String iataFrom = request.getIataFrom();
//        String iataTo = request.getIataTo();
//        boolean classBusiness = request.isClassBusiness();
//        boolean classEconomy = request.isClassEconomy();
//       boolean classFirst=request.isClassFirst();
//       LocalDate date=request.getDate();
//       DayOfWeek dayOfWeek=date.getDayOfWeek();
//       int dayValue=dayOfWeek.getValue()%7+1;
////       System.out.println(dayValue);
//       
////       switch (dayValue) {
////		case 1:if(request.getDay1()=="yes")
////		{
////			 List<AirlineRoute> recommendations = airlineRouteRepo.findBestRoutes(iataFrom, iataTo, classBusiness, classEconomy, classFirst);	
////			return recommendations;
////			 break;}
////		case 2:if(request.getDay2()=="yes")
////		{
////			 List<AirlineRoute> recommendations = airlineRouteRepo.findBestRoutes(iataFrom, iataTo, classBusiness, classEconomy, classFirst);	
////			 return recommendations;
////			 break;}	
////		case 3:if(request.getDay3()=="yes")
////		{
////			 List<AirlineRoute> recommendations = airlineRouteRepo.findBestRoutes(iataFrom, iataTo, classBusiness, classEconomy, classFirst);	
////			 return recommendations;
////			 break;}
////		case 4:if(request.getDay4()=="yes")
////		{
////			 List<AirlineRoute> recommendations = airlineRouteRepo.findBestRoutes(iataFrom, iataTo, classBusiness, classEconomy, classFirst);	
////			 return recommendations;
////			 break;}
////		case 5:if(request.getDay5()=="yes")
////		{
////			 List<AirlineRoute> recommendations = airlineRouteRepo.findBestRoutes(iataFrom, iataTo, classBusiness, classEconomy, classFirst);	
////			 return recommendations;
////			 break;}
////		case 6:if(request.getDay6()=="yes")
////		{
////			 List<AirlineRoute> recommendations = airlineRouteRepo.findBestRoutes(iataFrom, iataTo, classBusiness, classEconomy, classFirst);	
////			 return recommendations;
////			 break;}
////		case 7:if(request.getDay7()=="yes")
////		{
////			 List<AirlineRoute> recommendations = airlineRouteRepo.findBestRoutes(iataFrom, iataTo, classBusiness, classEconomy, classFirst);	
////			 return recommendations;
////			 break;}
////	
////		default:
////			break;
////	}
////       
//////        String day1 = request.getDay1();
////
////        // Implement your query logic based on the provided parameters
//////        List<AirlineRoute> recommendations = airlineRouteRepo.findBestRoutes(iataFrom, iataTo, classBusiness, classEconomy, classFirst);
////
////        return recommendations;
//       List<DayOfWeek> selectedDays = new ArrayList<>();
//
//       if ("yes".equals(request.getDay1())) {
//           selectedDays.add(DayOfWeek.MONDAY);
//       }
//       if ("yes".equals(request.getDay2())) {
//           selectedDays.add(DayOfWeek.TUESDAY);
//       }
//       if ("yes".equals(request.getDay3())) {
//           selectedDays.add(DayOfWeek.WEDNESDAY);
//       }
//       if ("yes".equals(request.getDay4())) {
//           selectedDays.add(DayOfWeek.THURSDAY);
//       }
//       if ("yes".equals(request.getDay5())) {
//           selectedDays.add(DayOfWeek.FRIDAY);
//       }
//       if ("yes".equals(request.getDay6())) {
//           selectedDays.add(DayOfWeek.SATURDAY);
//       }
//       if ("yes".equals(request.getDay7())) {
//           selectedDays.add(DayOfWeek.SUNDAY);
//       }
//
//       // If no days are selected, return an empty list
//       if (selectedDays.isEmpty()) {
//           return Collections.emptyList();
//       }
//
//       // Query the repository based on selected criteria
//       List<AirlineRoute> recommendations = airlineRouteRepo.findBestRoutes(iataFrom, iataTo, classBusiness, classEconomy, classFirst);
//
//       return recommendations;
//    }
//	@Override
//	public List<AirlineRoute> getBestRecommendations(AirlineRouteRequestDTO request) {
//	    String iataFrom = request.getIataFrom();
//	    String iataTo = request.getIataTo();
//	    boolean classBusiness = request.isClassBusiness();
//	    boolean classEconomy = request.isClassEconomy();
//	    boolean classFirst = request.isClassFirst();
//	    LocalDate date = request.getDate();
//
//	    // Create a list to store filtered recommendations
//	    List<AirlineRoute> filteredRecommendations = new ArrayList<>();
//
//	    // Get the day of the week from the provided date
//	    DayOfWeek dayOfWeek = date.getDayOfWeek();
//
//	    // Check if the day of the week matches the selected day in the request
//	    switch (dayOfWeek) {
//	        case MONDAY:
//	            if ("yes".equals(request.getDay1())) {
//	                filteredRecommendations.addAll(airlineRouteRepo.findBestRoutes(iataFrom, iataTo, classBusiness, classEconomy, classFirst, "day1"));
//	            }
//	            break;
//	        case TUESDAY:
//	            if ("yes".equals(request.getDay2())) {
//	                filteredRecommendations.addAll(airlineRouteRepo.findBestRoutes(iataFrom, iataTo, classBusiness, classEconomy, classFirst, "day2"));
//	            }
//	            break;
//	        case WEDNESDAY:
//	            if ("yes".equals(request.getDay3())) {
//	                filteredRecommendations.addAll(airlineRouteRepo.findBestRoutes(iataFrom, iataTo, classBusiness, classEconomy, classFirst, "day3"));
//	            }
//	            break;
//	        case THURSDAY:
//	            if ("yes".equals(request.getDay4())) {
//	                filteredRecommendations.addAll(airlineRouteRepo.findBestRoutes(iataFrom, iataTo, classBusiness, classEconomy, classFirst, "day4"));
//	            }
//	            break;
//	        case FRIDAY:
//	            if ("yes".equals(request.getDay5())) {
//	                filteredRecommendations.addAll(airlineRouteRepo.findBestRoutes(iataFrom, iataTo, classBusiness, classEconomy, classFirst, "day5"));
//	            }
//	            break;
//	        case SATURDAY:
//	            if ("yes".equals(request.getDay6())) {
//	                filteredRecommendations.addAll(airlineRouteRepo.findBestRoutes(iataFrom, iataTo, classBusiness, classEconomy, classFirst, "day6"));
//	            }
//	            break;
//	        case SUNDAY:
//	            if ("yes".equals(request.getDay7())) {
//	                filteredRecommendations.addAll(airlineRouteRepo.findBestRoutes(iataFrom, iataTo, classBusiness, classEconomy, classFirst, "day7"));
//	            }
//	            break;
//	        default:
//	            // Handle any other cases if needed
//	            break;
//	    }
//
//	    return filteredRecommendations;
//	}


	
}

 