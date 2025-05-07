package me.fit.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "service")
public class Service {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "service_seq")
	@SequenceGenerator(name = "service_seq", sequenceName = "service_seq", allocationSize = 1)
	Long id;

	@Column(name = "name")
	String name;

	@Column(name = "date")
	LocalDate date;

	@Column(name = "cost")
	double cost;

	@ManyToMany(mappedBy = "services")
	Set<Car> cars = new HashSet<>();

	public Service() {
		super();
	}

	public Service(Long id, String name, LocalDate date, double cost, Set<Car> cars) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.cost = cost;
		this.cars = cars;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Service))
			return false;
		Service service = (Service) o;
		return Double.compare(service.cost, cost) == 0 && Objects.equals(id, service.id)
				&& Objects.equals(name, service.name) && Objects.equals(date, service.date);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, date, cost);
	}

	@Override
	public String toString() {
		return "Service [id=" + id + ", name=" + name + ", date=" + date + ", cost=" + cost + ", cars=" + cars + "]";
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Set<Car> getCars() {
		return cars;
	}

	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}
}
