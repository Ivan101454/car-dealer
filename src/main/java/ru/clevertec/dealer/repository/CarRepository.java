package ru.clevertec.dealer.repository;

import org.hibernate.Session;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaPredicate;
import org.hibernate.query.criteria.JpaRoot;
import ru.clevertec.dealer.entity.Car;
import ru.clevertec.dealer.entity.Car_;
import ru.clevertec.dealer.filter.CarParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarRepository extends RepositoryBase<Long, Car> {


    public CarRepository(Session session) {
        super(Car.class, session);
    }

    public List<Car> getFilterCar(CarParam params, int pageNumber, int pageSize) {
        Session session = super.getSession();
        HibernateCriteriaBuilder cb = session.getCriteriaBuilder();
        JpaCriteriaQuery<Car> criteria = cb.createQuery(Car.class);
        JpaRoot<Car> root = criteria.from(Car.class);

        List<JpaPredicate> predicates = new ArrayList<>();
        if (params.getCarBrand() != null) {
            JpaPredicate predicateBrand = cb.equal(root.get(Car_.carBrand), params.getCarBrand());
            predicates.add(predicateBrand);
        }
        if (params.getStartDate() != 0) {
            JpaPredicate predicateYear = cb.between(root.get(Car_.year), params.getStartDate(), params.getEndDate());
            predicates.add(predicateYear);
        }
        if (params.getMinPrice() != null) {
            JpaPredicate predicatePrice = cb.between(root.get(Car_.price), params.getMinPrice(), params.getMaxPrice());
            predicates.add(predicatePrice);
        }
        if (params.getCategoryBody() != null) {
            JpaPredicate predicateCategoryBody = cb.equal(root.get(Car_.categoryBody), params.getCategoryBody());
            predicates.add(predicateCategoryBody);
        }

        criteria.where(cb.and(predicates.toArray(new JpaPredicate[predicates.size()])));

        if (params.isRequiredSort()) {
            if (params.isDescent()) {
                criteria.orderBy(cb.desc(root.get(Car_.carId)));
            } else criteria.orderBy(cb.asc(root.get(Car_.carId)));
        }

        return session.createQuery(criteria).setFirstResult((pageNumber-1)*pageSize).setMaxResults(pageSize).getResultList();
    }
}
