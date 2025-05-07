package me.fit.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import me.fit.repository.CountryHolidayRepository;
import me.fit.service.HolidayService;

@Path("/holidays")
public class HolidayResource {

	@Inject
	HolidayService holidayService;

	@Inject
	CountryHolidayRepository countryHolidayRepository;

	@GET
	public Response fetchHolidays(@QueryParam("countryCode") String countryCode) {
		int currentYear = java.time.LocalDate.now().getYear();

		boolean exists = countryHolidayRepository.existsByCountryAndYear(countryCode, currentYear);

		if (exists) {
			return Response.status(Response.Status.CONFLICT)
					.entity("Holiday data already exists for country: " + countryCode + " and year: " + currentYear)
					.build();
		}

		holidayService.fetchAndSaveCountryHolidays(countryCode);

		return Response.ok("Holidays successfully fetched and saved for country: " + countryCode).build();
	}
}
