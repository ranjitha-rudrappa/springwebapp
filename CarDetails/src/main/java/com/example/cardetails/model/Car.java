package com.example.cardetails.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Car {
	@Id
	private String carId;
	private String carname;
	private String cartype;
	private String carmodel;
	private String fueltype;
	
	public Car() {
		super();
	}


	
	public Car(String carId, String carname, String cartype, String carmodel, String fueltype) {
		super();
		this.carId = carId;
		this.carname = carname;
		this.cartype = cartype;
		this.carmodel = carmodel;
		this.fueltype = fueltype;
	}



	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public String getCarname() {
		return carname;
	}

	public void setCarname(String carname) {
		this.carname = carname;
	}

	public String getCartype() {
		return cartype;
	}

	public void setCartype(String cartype) {
		this.cartype = cartype;
	}

	public String getCarmodel() {
		return carmodel;
	}

	public void setCarmodel(String carmodel) {
		this.carmodel = carmodel;
	}

	public String getFueltype() {
		return fueltype;
	}

	public void setFueltype(String fueltype) {
		this.fueltype = fueltype;
	}



	@Override
	public String toString() {
		return "Car [carId=" + carId + ", carname=" + carname + ", cartype=" + cartype + ", carmodel=" + carmodel
				+ ", fueltype=" + fueltype + "]";
	}
	
	

}
