package me.fit.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class HolidayData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	String localName;
	String name;
	LocalDate date;
	String countryCode;

	Car car;

	public HolidayData(Long id, String localName, String name, LocalDate date, String countryCode, Car car) {
		super();
		this.id = id;
		this.localName = localName;
		this.name = name;
		this.date = date;
		this.countryCode = countryCode;
		this.car = car;
	}

	public HolidayData() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

}
