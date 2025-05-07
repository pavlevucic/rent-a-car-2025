package me.fit.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import me.fit.model.Service;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
@NamedQuery(name = "Car.getAllWithRentals", query = "SELECT DISTINCT c FROM Car c LEFT JOIN FETCH c.rentalList")
public class Car implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_seq")
	@SequenceGenerator(name = "car_seq", sequenceName = "car_seq", allocationSize = 1)
	private Long id;
	String make;
	String model;
	int year;
	String licensePlate;
	boolean available;

	@OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	List<Rental> rentalList = new ArrayList<>();

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "car_service", joinColumns = @JoinColumn(name = "car_id"), inverseJoinColumns = @JoinColumn(name = "service_id"))
	Set<Service> services = new HashSet<>();

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

	public List<Rental> getRentalList() {
		return rentalList;
	}

	public void setRentalList(List<Rental> rentalList) {
		this.rentalList = rentalList;
	}

	public Set<Service> getServices() {
		return services;
	}

	public void setServices(Set<Service> services) {
		this.services = services;
	}

	@Override
	public int hashCode() {
		return Objects.hash(available, id, licensePlate, make, model, year, services);
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
				&& Objects.equals(model, other.model) && year == other.year && Objects.equals(services, other.services);
	}

	@Override
	public String toString() {
		return "make=" + make + ", model=" + model + ", year=" + year + ", licensePlate=" + licensePlate
				+ ", available=" + available + ", services=" + services + "]";
	}
}
