package ru.clevertec.dealer.repository;

import org.hibernate.Session;
import ru.clevertec.dealer.entity.Review;

public class ReviewRepository extends RepositoryBase<Long, Review> {

    public ReviewRepository(Session session) {
        super(Review.class, session);
    }
}
