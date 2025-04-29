package me.fit.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.fit.model.Car;

@Dependent
public class CarService {

	@Inject
	EntityManager em;

	@Transactional
	public Car addCar(Car c) {

		return em.merge(c);
		
		
	}
}
