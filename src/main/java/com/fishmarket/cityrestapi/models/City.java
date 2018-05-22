package com.fishmarket.cityrestapi.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sales")
public class City {

	@Id
	String id;
	String cityName;
	
	public City() {
		
	}
	
	public City(String cityName) {
		this.cityName = cityName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}
