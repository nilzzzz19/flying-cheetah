package com.example.demo.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.example.demo.models.Weather;

public interface WeatherRepository extends ListCrudRepository<Weather, Integer> {

}
