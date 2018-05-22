package com.fishmarket.cityrestapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fishmarket.cityrestapi.models.City;
import com.fishmarket.cityrestapi.repositories.CityRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class CityController {

	@Autowired
	CityRepository cityRepository;
	
	@GetMapping("/cities")
	public List<City> getAllsales(){
		return cityRepository.findAll();
	}
	
	@PostMapping("/cities")
	public City createUser(@RequestBody City city) {
		return cityRepository.save(city);
	}
	
	@GetMapping(value="/cities/{id}")
	public ResponseEntity<City> getUserById(@PathVariable("id") String id){
		return cityRepository.findById(id).map(city -> ResponseEntity.ok().body(city)).orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping(value="/cities/{id}")
    public ResponseEntity<City> updateTodo(@PathVariable("id") String id,
                                           @RequestBody City city) {
        return cityRepository.findById(id)
                .map(cityData -> {
                	cityData.setCityName(city.getCityName());
                    City updatedCity = cityRepository.save(cityData);
                    return ResponseEntity.ok().body(updatedCity);
                }).orElse(ResponseEntity.notFound().build());
    }
	
	@DeleteMapping(value="/cities/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") String id) {
        return cityRepository.findById(id)
                .map(city -> {
                    cityRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
