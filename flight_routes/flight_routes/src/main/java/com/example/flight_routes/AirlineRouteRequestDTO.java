package com.example.flight_routes;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AirlineRouteRequestDTO {

    private String iataFrom;
    private String iataTo;
    private boolean classBusiness;
    private boolean classEconomy;
    private boolean classFirst;
    private LocalDate date;

    // Constructors, getters, and setters

    // Constructor with all fields
    public AirlineRouteRequestDTO(String iataFrom, String iataTo, boolean classBusiness, boolean classEconomy, boolean classFirst, LocalDate date) {
        this.iataFrom = iataFrom;
        this.iataTo = iataTo;
        this.classBusiness = classBusiness;
        this.classEconomy = classEconomy;
        this.classFirst = classFirst;
        this.date = date;
    }

    // Default constructor
    public AirlineRouteRequestDTO() {
    }

	public String getIataFrom() {
		return iataFrom;
	}

	public void setIataFrom(String iataFrom) {
		this.iataFrom = iataFrom;
	}

	public String getIataTo() {
		return iataTo;
	}

	public void setIataTo(String iataTo) {
		this.iataTo = iataTo;
	}

	public boolean isClassBusiness() {
		return classBusiness;
	}

	public void setClassBusiness(boolean classBusiness) {
		this.classBusiness = classBusiness;
	}

	public boolean isClassEconomy() {
		return classEconomy;
	}

	public void setClassEconomy(boolean classEconomy) {
		this.classEconomy = classEconomy;
	}

	public boolean isClassFirst() {
		return classFirst;
	}

	public void setClassFirst(boolean classFirst) {
		this.classFirst = classFirst;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

    // Getters and setters for all fields
    // ...
	
	@JsonProperty("day1")
	private String day1;

 
@JsonProperty("day2")
	private String day2;

 
@JsonProperty("day3")
	private String day3;

 
@JsonProperty("day4")
	private String day4;

 
@JsonProperty("day5")
	private String day5;

 
@JsonProperty("day6")
	private String day6;

 
@JsonProperty("day7")
	private String day7;

public String getDay1() {
	return day1;
}

public void setDay1(String day1) {
	this.day1 = day1;
}

public String getDay2() {
	return day2;
}

public void setDay2(String day2) {
	this.day2 = day2;
}

public String getDay3() {
	return day3;
}

public void setDay3(String day3) {
	this.day3 = day3;
}

public String getDay4() {
	return day4;
}

public void setDay4(String day4) {
	this.day4 = day4;
}

public String getDay5() {
	return day5;
}

public void setDay5(String day5) {
	this.day5 = day5;
}

public String getDay6() {
	return day6;
}

public void setDay6(String day6) {
	this.day6 = day6;
}

public String getDay7() {
	return day7;
}

public void setDay7(String day7) {
	this.day7 = day7;
}
}
