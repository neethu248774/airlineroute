package com.example.flight_routes;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

public interface AirlineRouteService {
	public List<AirlineRoute> getAllAirlineRoutes();
	public List<AirlineRoute>getAllRoutes();
	 List<AirlineRoute> getBestRecommendations(AirlineRoute request);
	 
}