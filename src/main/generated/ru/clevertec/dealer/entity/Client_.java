package ru.clevertec.dealer.entity;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDate;

@StaticMetamodel(Client.class)
public abstract class Client_ {

	public static final String CARS = "cars";
	public static final String CLIENT_ID = "clientId";
	public static final String REVIEW_ON_CAR = "reviewOnCar";
	public static final String DATE_OF_REGISTRATION = "dateOfRegistration";
	public static final String NAME_OF_CUSTOMER = "nameOfCustomer";
	public static final String CONTACTS = "contacts";

	
	/**
	 * @see ru.clevertec.dealer.entity.Client#cars
	 **/
	public static volatile ListAttribute<Client, Car> cars;
	
	/**
	 * @see ru.clevertec.dealer.entity.Client#clientId
	 **/
	public static volatile SingularAttribute<Client, Long> clientId;
	
	/**
	 * @see ru.clevertec.dealer.entity.Client#reviewOnCar
	 **/
	public static volatile ListAttribute<Client, Review> reviewOnCar;
	
	/**
	 * @see ru.clevertec.dealer.entity.Client#dateOfRegistration
	 **/
	public static volatile SingularAttribute<Client, LocalDate> dateOfRegistration;
	
	/**
	 * @see ru.clevertec.dealer.entity.Client#nameOfCustomer
	 **/
	public static volatile SingularAttribute<Client, String> nameOfCustomer;
	
	/**
	 * @see ru.clevertec.dealer.entity.Client
	 **/
	public static volatile EntityType<Client> class_;
	
	/**
	 * @see ru.clevertec.dealer.entity.Client#contacts
	 **/
	public static volatile ListAttribute<Client, String> contacts;

}

