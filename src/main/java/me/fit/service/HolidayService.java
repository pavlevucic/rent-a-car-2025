package me.fit.service;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import me.fit.client.NagerApiClient;
import me.fit.dto.HolidayDTO;
import me.fit.model.CountryHoliday;
import me.fit.repository.CountryHolidayRepository;

@ApplicationScoped
public class HolidayService {

	@Inject
	@RestClient
	NagerApiClient nagerApiClient;

	@Inject
	CountryHolidayRepository repository;

	public void fetchAndSaveCountryHolidays(String countryCode) {
		List<HolidayDTO> holidays = nagerApiClient.getNextPublicHolidays(countryCode);

		if (holidays == null || holidays.isEmpty()) {
			System.out.println("Nema praznika za zemlju: " + countryCode);
			return;
		}

		for (HolidayDTO dto : holidays) {
			int year = dto.getDate().getYear();
			if (!repository.existsByCountryAndYear(countryCode, year)) {
				CountryHoliday ch = new CountryHoliday();
				ch.setName(dto.getName());
				ch.setLocalName(dto.getLocalName());
				ch.setDate(dto.getDate());
				ch.setYear(year);
				ch.setCountryCode(dto.getCountryCode());
				repository.save(ch);
			}
		}
	}
}
