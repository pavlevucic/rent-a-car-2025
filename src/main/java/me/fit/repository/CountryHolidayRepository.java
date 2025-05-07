package me.fit.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.fit.model.CountryHoliday;

@ApplicationScoped
public class CountryHolidayRepository {

    @Inject
    EntityManager em;

    @Transactional
    public void save(CountryHoliday ch) {
        em.persist(ch);
    }

    public boolean existsByCountryAndYear(String countryCode, int year) {
        Long count = em.createQuery(
                "SELECT COUNT(ch) FROM CountryHoliday ch WHERE ch.countryCode = :countryCode AND ch.year = :year", Long.class)
                .setParameter("countryCode", countryCode)
                .setParameter("year", year)
                .getSingleResult();
        return count > 0;
    }
}
