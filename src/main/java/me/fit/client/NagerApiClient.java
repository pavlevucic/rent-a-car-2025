package me.fit.client;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import me.fit.dto.CountryDTO;
import me.fit.dto.HolidayDTO;

@Path("/")
@RegisterRestClient(configKey = "nager-api")
public interface NagerApiClient {

	@GET
	@Path("api/v3/AvailableCountries")
	List<CountryDTO> getAvailableCountries();

	@GET
	@Path("api/v3/NextPublicHolidays/{countryCode}")
	List<HolidayDTO> getNextPublicHolidays(@PathParam("countryCode") String countryCode);

}
