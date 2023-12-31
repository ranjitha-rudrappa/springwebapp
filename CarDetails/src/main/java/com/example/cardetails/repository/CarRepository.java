package com.example.cardetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cardetails.model.Car;

public interface CarRepository extends JpaRepository<Car,String>{
	

}
