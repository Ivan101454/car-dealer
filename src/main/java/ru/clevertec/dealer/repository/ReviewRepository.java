package ru.clevertec.dealer.repository;

import org.hibernate.Session;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaPredicate;
import org.hibernate.query.criteria.JpaRoot;
import ru.clevertec.dealer.entity.Review;
import ru.clevertec.dealer.entity.Review_;

import java.util.List;

public class ReviewRepository extends RepositoryBase<Long, Review> {

    public ReviewRepository(Session session) {
        super(Review.class, session);
    }

    public List<Review> findByKeywords(List<String> keywords, int pageNumber, int pageSize) {
        Session session = super.getSession();
        HibernateCriteriaBuilder cb = session.getCriteriaBuilder();
        JpaCriteriaQuery<Review> criteria = cb.createQuery(Review.class);
        JpaRoot<Review> root = criteria.from(Review.class);

        JpaPredicate[] predicates = new JpaPredicate[keywords.size()];
        for (int i=0; i< keywords.size(); i++) {
            predicates[i] = cb.ilike(root.get(Review_.textReview), "%" + keywords.get(i) +"%");
        }

        criteria.select(root).where(cb.and(predicates));

        return session.createQuery(criteria).setFirstResult((pageNumber - 1)*pageSize).setMaxResults(pageSize).getResultList();
    }
}
