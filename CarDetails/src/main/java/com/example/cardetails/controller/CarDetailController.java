
package com.example.cardetails.controller;
import com.example.cardetails.model.Car;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cardetails.service.CarService;

@RestController
@RequestMapping("/cardetails")
public class CarDetailController {
	
	 CarService carService;
	 private static final Logger logger = LoggerFactory.getLogger(CarDetailController.class);

	
	public CarDetailController(CarService carService) {
		super();
		this.carService = carService;
	}


	@GetMapping
	public List<Car> getCarDetails(String carId)
	{   logger.info("Request received for retrieving all car details.");
		return carService.getAllCarDetails();
	}
	
	
	@GetMapping("{carId}")
	public Car getCarDetailsById(@PathVariable String carId)
	{   logger.info("Request received for retrieving car details by ID: {}", carId);
		return carService.getCarDetails(carId);
	}
	
	@PostMapping
	public String createCarDetails(@RequestBody Car car)
	{   carService.createCarDetails(car);
	    logger.info("Car details added: {}", car);
		return "Car deatils added";
	}
	
	@PutMapping
	public String updateCarDetails(@RequestBody Car car)
	{   carService.updateCarDetails(car);
	    logger.info("Car details updated: {}", car);
	    return "car details updated";
	}
	
	@DeleteMapping("{carId}")
	public String deleteCarDetails(@PathVariable String carId)
	{   carService.deleteCarDetails(carId);
	    logger.info("Car details deleted for ID: {}", carId);
		return "Deleted Sucessfully";
	}
	
}

/*
package com.example.cardetails.controller;

import com.example.cardetails.model.Car;
import com.example.cardetails.service.CarNotFoundException;
import com.example.cardetails.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cardetails")
public class CarDetailController {

    private final CarService carService;
    private static final Logger logger = LoggerFactory.getLogger(CarDetailController.class);

    public CarDetailController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getCarDetails() {
        logger.info("Request received for retrieving all car details.");
        List<Car> allCarDetails = carService.getAllCarDetails();
        logger.info("Returning {} car details.", allCarDetails.size());
        return allCarDetails;
    }

    @GetMapping("{carId}")
    public ResponseEntity<?> getCarDetailsById(@PathVariable String carId) {
        logger.info("Request received for retrieving car details by ID: {}", carId);
        try {
            Car carDetails = carService.getCarDetails(carId);
            logger.info("Found car details for ID {}: {}", carId, carDetails);
            return ResponseEntity.ok(carDetails);
        } catch (CarNotFoundException e) {
            logger.warn("No car details found for ID: {}", carId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found with ID: " + carId);
        }
    }

    @PostMapping
    public String createCarDetails(@RequestBody Car car) {
        carService.createCarDetails(car);
        logger.info("Car details added: {}", car);
        return "Car details added";
    }

    @PutMapping
    public String updateCarDetails(@RequestBody Car car) {
        carService.updateCarDetails(car);
        logger.info("Car details updated: {}", car);
        return "Car details updated";
    }

    @DeleteMapping("{carId}")
    public ResponseEntity<String> deleteCarDetails(@PathVariable String carId) {
        try {
            carService.deleteCarDetails(carId);
            logger.info("Car details deleted for ID: {}", carId);
            return ResponseEntity.ok("Deleted Successfully");
        } catch (CarNotFoundException e) {
            logger.warn("No car details found for ID: {}", carId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found with ID: " + carId);
        }
    }
}
*/



