package com.example.cardetails.service;
import java.util.List;

import com.example.cardetails.model.Car;

public interface CarService {
	
	public String createCarDetails(Car car);
	public String updateCarDetails(Car car);
	public String deleteCarDetails(String carId);
	public Car getCarDetails(String carId);
	public List<Car> getAllCarDetails();
}
