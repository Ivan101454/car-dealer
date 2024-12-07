package ru.clevertec.dealer.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
//import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaPredicate;
import org.hibernate.query.criteria.JpaRoot;
import ru.clevertec.dealer.entity.Car;
import ru.clevertec.dealer.entity.Car_;
import ru.clevertec.dealer.filter.CarParam;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CarRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Car> getFilterCar(CarParam params, int pageNumber, int pageSize) {
//        Session session = super.getSession();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Car> criteria = cb.createQuery(Car.class);
        Root<Car> root = criteria.from(Car.class);

        List<Predicate> predicates = new ArrayList<>();
        if (params.getCarBrand() != null) {
            Predicate predicateBrand = cb.equal(root.get(Car_.carBrand), params.getCarBrand());
            predicates.add(predicateBrand);
        }
        if (params.getStartDate() != 0) {
            Predicate predicateYear = cb.between(root.get(Car_.year), params.getStartDate(), params.getEndDate());
            predicates.add(predicateYear);
        }
        if (params.getMinPrice() != null) {
            Predicate predicatePrice = cb.between(root.get(Car_.price), params.getMinPrice(), params.getMaxPrice());
            predicates.add(predicatePrice);
        }
        if (params.getCategoryBody() != null) {
            Predicate predicateCategoryBody = cb.equal(root.get(Car_.categoryBody), params.getCategoryBody());
            predicates.add(predicateCategoryBody);
        }

        criteria.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));

        if (params.isRequiredSort()) {
            if (params.isDescent()) {
                criteria.orderBy(cb.desc(root.get(Car_.carId)));
            } else criteria.orderBy(cb.asc(root.get(Car_.carId)));
        }

        return entityManager.createQuery(criteria).setFirstResult((pageNumber-1)*pageSize).setMaxResults(pageSize).getResultList();
    }
}
