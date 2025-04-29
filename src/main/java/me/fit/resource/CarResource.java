package me.fit.resource;


import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.fit.model.Car;
import me.fit.repository.CarService;

@Path("car")
public class CarResource {


	@Inject
	CarService carService;
	
	@Path("addCar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCar(Car c) {
		
		Car car = carService.addCar(c);
		
		return Response.ok(car).build();
		
	}
}
