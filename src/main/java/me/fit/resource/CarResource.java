package me.fit.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import me.fit.model.Car;
import me.fit.repository.CarService;

@Path("/car")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarResource {

	@Inject
	CarService carService;

	@POST
	@Path("/with-rentals")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createCarWithRentals(Car car) {
		carService.createCarWithRentals(car);
		return Response.status(Response.Status.CREATED).build();
	}

	@GET
	@Path("/with-rentals")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Car> getAllCarsWithRentals() {
		return carService.getAllCarsWithRentals();
	}

	@POST
	public Response createCar(Car car) {
		carService.createCar(car);
		return Response.status(Response.Status.CREATED).build();
	}

	@GET
	public List<Car> getAllCars() {
		return carService.getAllCars();
	}
}
