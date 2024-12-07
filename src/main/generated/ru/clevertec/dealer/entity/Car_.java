package ru.clevertec.dealer.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;

@StaticMetamodel(Car.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Car_ {

	public static final String CAR_BRAND = "carBrand";
	public static final String CLIENTS = "clients";
	public static final String YEAR = "year";
	public static final String PRICE = "price";
	public static final String CAR_SHOWROOM = "carShowroom";
	public static final String REVIEWS_ON_CAR = "reviewsOnCar";
	public static final String CAR_ID = "carId";
	public static final String CAR_MODEL = "carModel";
	public static final String CATEGORY_BODY = "categoryBody";

	
	/**
	 * @see ru.clevertec.dealer.entity.Car#carBrand
	 **/
	public static volatile SingularAttribute<Car, String> carBrand;
	
	/**
	 * @see ru.clevertec.dealer.entity.Car#clients
	 **/
	public static volatile ListAttribute<Car, Client> clients;
	
	/**
	 * @see ru.clevertec.dealer.entity.Car#year
	 **/
	public static volatile SingularAttribute<Car, Integer> year;
	
	/**
	 * @see ru.clevertec.dealer.entity.Car#price
	 **/
	public static volatile SingularAttribute<Car, BigDecimal> price;
	
	/**
	 * @see ru.clevertec.dealer.entity.Car#carShowroom
	 **/
	public static volatile SingularAttribute<Car, CarShowroom> carShowroom;
	
	/**
	 * @see ru.clevertec.dealer.entity.Car
	 **/
	public static volatile EntityType<Car> class_;
	
	/**
	 * @see ru.clevertec.dealer.entity.Car#reviewsOnCar
	 **/
	public static volatile ListAttribute<Car, Review> reviewsOnCar;
	
	/**
	 * @see ru.clevertec.dealer.entity.Car#carId
	 **/
	public static volatile SingularAttribute<Car, Long> carId;
	
	/**
	 * @see ru.clevertec.dealer.entity.Car#carModel
	 **/
	public static volatile SingularAttribute<Car, String> carModel;
	
	/**
	 * @see ru.clevertec.dealer.entity.Car#categoryBody
	 **/
	public static volatile SingularAttribute<Car, Category> categoryBody;

}

