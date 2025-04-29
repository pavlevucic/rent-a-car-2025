package me.fit.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Car {

	@Id
	@SequenceGenerator(name="car_sequence",sequenceName="car_sequence")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="car_sequence")
	Long id;
	String make;
	String model;
	int year;
	String licensePlate;
	boolean available;
//	List<Rental> rentals;
//	List<Service> services;

	public Car() {
		super();
	}

	public Car(Long id, String make, String model, int year, String licensePlate, boolean available) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.year = year;
		this.licensePlate = licensePlate;
		this.available = available;
//		this.rentals = rentals;
//		this.services = services;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

//	public List<Rental> getRentals() {
//		return rentals;
//	}
//
//	public void setRentals(List<Rental> rentals) {
//		this.rentals = rentals;
//	}
//
//	public List<Service> getServices() {
//		return services;
//	}
//
//	public void setServices(List<Service> services) {
//		this.services = services;
//	}

	@Override
	public int hashCode() {
		return Objects.hash(available, id, licensePlate, make, model, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return available == other.available && Objects.equals(id, other.id)
				&& Objects.equals(licensePlate, other.licensePlate) && Objects.equals(make, other.make)
				&& Objects.equals(model, other.model) && year == other.year;
	}

	@Override
	public String toString() {
		return "make=" + make + ", model=" + model + ", year=" + year + ", licensePlate="
				+ licensePlate + ", available=" + available + "]";
	}

}
