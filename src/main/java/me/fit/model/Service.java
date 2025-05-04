package me.fit.model;

import java.util.List;

public class Service {

	Long id;
	String name;
	String date;
	double cost;
	List<Car> cars;

	public Service(Long id, String name, String date, double cost, List<Car> cars) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.cost = cost;
		this.cars = cars;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

}
