package ru.clevertec.dealer.repository;

import org.hibernate.Session;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaPredicate;
import org.hibernate.query.criteria.JpaRoot;
import ru.clevertec.dealer.entity.Car;
import ru.clevertec.dealer.entity.Car_;
import ru.clevertec.dealer.filter.CarParam;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class CarRepository extends RepositoryBase<Long, Car> {


    public CarRepository(Session session) {
        super(Car.class, session);
    }

    public List<Car> getFilterCar(CarParam params, Pageable pageable) {
        Session session = super.getSession();
        HibernateCriteriaBuilder cb = session.getCriteriaBuilder();
        JpaCriteriaQuery<Car> criteria = cb.createQuery(Car.class);
        JpaRoot<Car> root = criteria.from(Car.class);


        JpaPredicate predicateBrand = cb.equal(root.get(Car_.carBrand), params.getCarBrand());
        JpaPredicate predicateYear = cb.between(root.get(Car_.year), params.getStartDate(), params.getEndDate());
        JpaPredicate predicatePrice = cb.between(root.get(Car_.price), params.getMinPrice(), params.getMaxPrice());
        JpaPredicate predicateCategoryBody = cb.equal(root.get(Car_.categoryBody), params.getCategoryBody());
        List<JpaPredicate> list = Arrays.asList(predicateBrand, predicateYear, predicatePrice, predicateCategoryBody);
        List<JpaPredicate> predicates = new ArrayList<>(list);

        criteria.where(cb.and(predicates.toArray(new JpaPredicate[predicates.size()])));
        criteria.orderBy(cb.desc(root.get(Car_.carId)));

//        criteria.where(predictBrand);
        return session.createQuery(criteria).getResultList();
    }


}
