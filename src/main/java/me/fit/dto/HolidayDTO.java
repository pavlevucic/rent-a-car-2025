package me.fit.dto;

import java.time.LocalDate;

public class HolidayDTO {

	String localName;
	String name;
	LocalDate date;
	String countryCode;

	public HolidayDTO(String localName, String name, LocalDate date, String countryCode) {
		super();
		this.localName = localName;
		this.name = name;
		this.date = date;
		this.countryCode = countryCode;
	}

	public HolidayDTO() {
		super();
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

}
