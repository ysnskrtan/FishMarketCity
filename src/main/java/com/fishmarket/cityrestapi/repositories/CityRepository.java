package com.fishmarket.cityrestapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fishmarket.cityrestapi.models.City;

@Repository
public interface CityRepository extends MongoRepository<City, String> {

}
