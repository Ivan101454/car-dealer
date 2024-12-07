package ru.clevertec.dealer.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Review.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Review_ {

	public static final String CAR = "car";
	public static final String RATING = "rating";
	public static final String CLIENT = "client";
	public static final String REVIEW_ID = "reviewId";
	public static final String TEXT_REVIEW = "textReview";

	
	/**
	 * @see ru.clevertec.dealer.entity.Review#car
	 **/
	public static volatile SingularAttribute<Review, Car> car;
	
	/**
	 * @see ru.clevertec.dealer.entity.Review#rating
	 **/
	public static volatile SingularAttribute<Review, Integer> rating;
	
	/**
	 * @see ru.clevertec.dealer.entity.Review#client
	 **/
	public static volatile SingularAttribute<Review, Client> client;
	
	/**
	 * @see ru.clevertec.dealer.entity.Review
	 **/
	public static volatile EntityType<Review> class_;
	
	/**
	 * @see ru.clevertec.dealer.entity.Review#reviewId
	 **/
	public static volatile SingularAttribute<Review, Long> reviewId;
	
	/**
	 * @see ru.clevertec.dealer.entity.Review#textReview
	 **/
	public static volatile SingularAttribute<Review, String> textReview;

}

