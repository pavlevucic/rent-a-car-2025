package me.fit.dto;

import java.util.Objects;

public class CountryDTO {

	String countryCode;
	String name;

	public CountryDTO(String countryCode, String name) {
		super();
		this.countryCode = countryCode;
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(countryCode, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CountryDTO other = (CountryDTO) obj;
		return Objects.equals(countryCode, other.countryCode) && Objects.equals(name, other.name);
	}

	public CountryDTO() {
		super();
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
