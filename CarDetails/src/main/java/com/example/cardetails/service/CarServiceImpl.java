package com.example.cardetails.service;


import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.cardetails.model.Car;
import com.example.cardetails.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService {
	
	CarRepository carRepository;
	
	public CarServiceImpl(CarRepository carRepository) {
		super();
		this.carRepository = carRepository;
	}

	@Override
	public String createCarDetails(Car car) {
		carRepository.save(car);
		return "Success";
	}

	@Override
	public String updateCarDetails(Car car) {
		carRepository.save(car);
		return "Success";
	}

	@Override
	public String deleteCarDetails(String carId) {
		carRepository.deleteById(carId);
		return "Success";
	}


	@Override
	public Car getCarDetails(String carId) {
	    Optional<Car> optionalCar = carRepository.findById(carId);

	    if (optionalCar.isPresent()) {
	        return optionalCar.get();
	    } else {
	        throw new CarNotFoundException("Car not found with ID: " + carId);
	    }
	}

	@Override
	public List<Car> getAllCarDetails() {
		return carRepository.findAll();
	}
	

}




