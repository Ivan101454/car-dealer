package ru.clevertec.dealer.entity;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(CarShowroom.class)
public abstract class CarShowroom_ {

	public static final String ADDRESS_OF_SHOWROOM = "addressOfShowroom";
	public static final String CAR_IN_STORE = "carInStore";
	public static final String SHOWROOM_ID = "showroomId";
	public static final String NAME_OF_SHOWROOM = "nameOfShowroom";

	
	/**
	 * @see ru.clevertec.dealer.entity.CarShowroom#addressOfShowroom
	 **/
	public static volatile SingularAttribute<CarShowroom, String> addressOfShowroom;
	
	/**
	 * @see ru.clevertec.dealer.entity.CarShowroom#carInStore
	 **/
	public static volatile ListAttribute<CarShowroom, Car> carInStore;
	
	/**
	 * @see ru.clevertec.dealer.entity.CarShowroom#showroomId
	 **/
	public static volatile SingularAttribute<CarShowroom, Long> showroomId;
	
	/**
	 * @see ru.clevertec.dealer.entity.CarShowroom
	 **/
	public static volatile EntityType<CarShowroom> class_;
	
	/**
	 * @see ru.clevertec.dealer.entity.CarShowroom#nameOfShowroom
	 **/
	public static volatile SingularAttribute<CarShowroom, String> nameOfShowroom;

}

