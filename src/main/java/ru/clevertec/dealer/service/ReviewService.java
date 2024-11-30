package ru.clevertec.dealer.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.event.internal.ReattachVisitor;
import ru.clevertec.dealer.dto.CarDto;
import ru.clevertec.dealer.dto.ReviewDto;
import ru.clevertec.dealer.entity.Car;
import ru.clevertec.dealer.entity.Review;
import ru.clevertec.dealer.mapper.CarMapper;
import ru.clevertec.dealer.repository.CarRepository;
import ru.clevertec.dealer.repository.ReviewRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public Optional<ReviewDto> findById(Long id) {
        return reviewRepository.finById(id).map(CarMapper.INSTANCE::reviewToReviewDto);
    }

    public List<ReviewDto> findAllStore() {
        return reviewRepository.findAll().stream().map(CarMapper.INSTANCE::reviewToReviewDto).toList();
    }

    public Review create(ReviewDto reviewDto) {
        Review review = CarMapper.INSTANCE.reviewDtoToReview(reviewDto);
        return reviewRepository.save(review);
    }

    public void update(ReviewDto reviewDto) {
        reviewRepository.update(CarMapper.INSTANCE.reviewDtoToReview(reviewDto));
    }

    public boolean delete(Long id) {
        Optional<Review> review = reviewRepository.finById(id);
        review.ifPresent(a -> reviewRepository.delete(a.getReviewId()));
        return review.isPresent();
    }
}
