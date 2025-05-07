package me.fit.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import me.fit.model.Car;
import me.fit.model.Rental;

@ApplicationScoped
public class CarService {

	@Inject
	EntityManager em;

	public List<Car> getAllCarsWithRentals() {
		return em.createNamedQuery("Car.getAllWithRentals", Car.class).getResultList();
	}

	@Transactional
	public void createCarWithServices(Car car) {
		em.persist(car);
	}

	@Transactional
	public void createCarWithRentals(Car car) {
		if (car.getRentalList() != null) {
			for (Rental rental : car.getRentalList()) {
				rental.setCar(car);
			}
		}
		em.persist(car);
	}

	@Transactional
	public void createCar(Car car) {
		em.persist(car);
	}

	public List<Car> getAllCars() {
		return em.createQuery("SELECT c FROM Car c", Car.class).getResultList();
	}
}