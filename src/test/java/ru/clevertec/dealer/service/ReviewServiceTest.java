package ru.clevertec.dealer.service;

import org.hibernate.Session;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.clevertec.dealer.dto.ReviewDto;
import ru.clevertec.dealer.dao.ReviewRepository;
import ru.clevertec.dealer.utils.HibernateUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReviewServiceTest {

//    @Autowired
//    private ReviewService reviewService;
//    private static ReviewService reviewService;
//    private static Session session;
//
//    @BeforeAll
//    static void init() {
//        session = HibernateUtil.initDatabaseSession();
//        session.beginTransaction();
//        ReviewRepository reviewRepository = new ReviewRepository(session);
//        reviewService = new ReviewService(reviewRepository);
//    }

//    @AfterAll
//    static void close() {
//        session.getTransaction().rollback();
//    }

//    @Test
//    void findReviewByKeywords() {
//        List<String> list = List.of("Комфортный", "Хорошая");
//        List<ReviewDto> reviewByKeywords = reviewService.findReviewByKeywords(list, 1, 1);
//        assertEquals(8, reviewByKeywords.getFirst().rating());
//    }
}