package ru.clevertec.dealer.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import ru.clevertec.dealer.enums.Body;

@StaticMetamodel(Category.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Category_ {

	public static final String BODY = "body";
	public static final String CATEGORY_ID = "categoryId";
	public static final String LIST_OF_CAR = "listOfCar";

	
	/**
	 * @see ru.clevertec.dealer.entity.Category#body
	 **/
	public static volatile SingularAttribute<Category, Body> body;
	
	/**
	 * @see ru.clevertec.dealer.entity.Category
	 **/
	public static volatile EntityType<Category> class_;
	
	/**
	 * @see ru.clevertec.dealer.entity.Category#categoryId
	 **/
	public static volatile SingularAttribute<Category, Long> categoryId;
	
	/**
	 * @see ru.clevertec.dealer.entity.Category#listOfCar
	 **/
	public static volatile ListAttribute<Category, Car> listOfCar;

}

