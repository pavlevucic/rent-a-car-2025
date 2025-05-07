package me.fit.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "country_holiday", uniqueConstraints = @UniqueConstraint(columnNames = { "countryCode", "year" }))
public class CountryHoliday implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String localName;
	private LocalDate date;
	private int year;

	@Column(nullable = false)
	private String countryCode;

	public CountryHoliday(Long id, String name, String localName, LocalDate date, int year, String countryCode) {
		this.id = id;
		this.name = name;
		this.localName = localName;
		this.date = date;
		this.year = year;
		this.countryCode = countryCode;
	}

	public CountryHoliday() {
	}

	@Override
	public int hashCode() {
		return Objects.hash(countryCode, date, id, name, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		CountryHoliday other = (CountryHoliday) obj;
		return year == other.year &&
			Objects.equals(id, other.id) &&
			Objects.equals(name, other.name) &&
			Objects.equals(localName, other.localName) &&
			Objects.equals(date, other.date) &&
			Objects.equals(countryCode, other.countryCode);
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

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
}
