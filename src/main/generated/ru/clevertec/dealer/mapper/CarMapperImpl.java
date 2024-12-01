package ru.clevertec.dealer.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import ru.clevertec.dealer.dto.CarDto;
import ru.clevertec.dealer.dto.CarShowroomDto;
import ru.clevertec.dealer.dto.CategoryDto;
import ru.clevertec.dealer.dto.ClientDto;
import ru.clevertec.dealer.dto.ReviewDto;
import ru.clevertec.dealer.entity.Car;
import ru.clevertec.dealer.entity.CarShowroom;
import ru.clevertec.dealer.entity.Category;
import ru.clevertec.dealer.entity.Client;
import ru.clevertec.dealer.entity.Review;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-01T23:03:47+0300",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.4 (Amazon.com Inc.)"
)
public class CarMapperImpl implements CarMapper {

    @Override
    public CarShowroomDto carShowroomToCarShowroomDto(CarShowroom carShowroom) {
        if ( carShowroom == null ) {
            return null;
        }

        CarShowroomDto.CarShowroomDtoBuilder carShowroomDto = CarShowroomDto.builder();

        carShowroomDto.nameOfShowroom( carShowroom.getNameOfShowroom() );
        carShowroomDto.addressOfShowroom( carShowroom.getAddressOfShowroom() );
        carShowroomDto.carInStore( carListToCarDtoList( carShowroom.getCarInStore() ) );

        return carShowroomDto.build();
    }

    @Override
    public CarShowroom carShowroomDtoToCarShowroom(CarShowroomDto carShowroomDto) {
        if ( carShowroomDto == null ) {
            return null;
        }

        CarShowroom.CarShowroomBuilder carShowroom = CarShowroom.builder();

        carShowroom.nameOfShowroom( carShowroomDto.getNameOfShowroom() );
        carShowroom.addressOfShowroom( carShowroomDto.getAddressOfShowroom() );
        carShowroom.carInStore( carDtoListToCarList( carShowroomDto.getCarInStore() ) );

        return carShowroom.build();
    }

    @Override
    public CarDto carToCarDto(Car car) {
        if ( car == null ) {
            return null;
        }

        CarDto.CarDtoBuilder carDto = CarDto.builder();

        carDto.carBrand( car.getCarBrand() );
        carDto.carModel( car.getCarModel() );
        carDto.year( car.getYear() );
        carDto.price( car.getPrice() );
        carDto.categoryBody( categoryToCategoryDto( car.getCategoryBody() ) );
        carDto.carShowroom( carShowroomToCarShowroomDto( car.getCarShowroom() ) );
        carDto.reviewsOnCar( reviewListToReviewDtoList( car.getReviewsOnCar() ) );
        carDto.clients( clientListToClientDtoList( car.getClients() ) );

        return carDto.build();
    }

    @Override
    public Car carDtoToCar(CarDto carDto) {
        if ( carDto == null ) {
            return null;
        }

        Car.CarBuilder car = Car.builder();

        car.carBrand( carDto.getCarBrand() );
        car.carModel( carDto.getCarModel() );
        car.year( carDto.getYear() );
        car.price( carDto.getPrice() );
        car.categoryBody( categoryDtoToCategory( carDto.getCategoryBody() ) );
        car.carShowroom( carShowroomDtoToCarShowroom( carDto.getCarShowroom() ) );
        car.reviewsOnCar( reviewDtoListToReviewList( carDto.getReviewsOnCar() ) );
        car.clients( clientDtoListToClientList( carDto.getClients() ) );

        return car.build();
    }

    @Override
    public ClientDto clientToClientDto(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientDto.ClientDtoBuilder clientDto = ClientDto.builder();

        clientDto.nameOfCustomer( client.getNameOfCustomer() );
        List<String> list = client.getContacts();
        if ( list != null ) {
            clientDto.contacts( new ArrayList<String>( list ) );
        }
        clientDto.dateOfRegistration( client.getDateOfRegistration() );
        clientDto.cars( carListToCarDtoList( client.getCars() ) );
        clientDto.reviewOnCar( reviewListToReviewDtoList( client.getReviewOnCar() ) );

        return clientDto.build();
    }

    @Override
    public Client clientDtoToClient(ClientDto clientDto) {
        if ( clientDto == null ) {
            return null;
        }

        Client.ClientBuilder client = Client.builder();

        client.nameOfCustomer( clientDto.getNameOfCustomer() );
        List<String> list = clientDto.getContacts();
        if ( list != null ) {
            client.contacts( new ArrayList<String>( list ) );
        }
        client.dateOfRegistration( clientDto.getDateOfRegistration() );
        client.cars( carDtoListToCarList( clientDto.getCars() ) );
        client.reviewOnCar( reviewDtoListToReviewList( clientDto.getReviewOnCar() ) );

        return client.build();
    }

    @Override
    public CategoryDto categoryToCategoryDto(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDto.CategoryDtoBuilder categoryDto = CategoryDto.builder();

        categoryDto.body( category.getBody() );
        categoryDto.listOfCar( carListToCarDtoList( category.getListOfCar() ) );

        return categoryDto.build();
    }

    @Override
    public Category categoryDtoToCategory(CategoryDto categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        Category.CategoryBuilder category = Category.builder();

        category.body( categoryDto.getBody() );
        category.listOfCar( carDtoListToCarList( categoryDto.getListOfCar() ) );

        return category.build();
    }

    @Override
    public ReviewDto reviewToReviewDto(Review review) {
        if ( review == null ) {
            return null;
        }

        ReviewDto.ReviewDtoBuilder reviewDto = ReviewDto.builder();

        reviewDto.textReview( review.getTextReview() );
        reviewDto.rating( review.getRating() );
        reviewDto.client( clientToClientDto( review.getClient() ) );
        reviewDto.car( carToCarDto( review.getCar() ) );

        return reviewDto.build();
    }

    @Override
    public Review reviewDtoToReview(ReviewDto reviewDto) {
        if ( reviewDto == null ) {
            return null;
        }

        Review.ReviewBuilder review = Review.builder();

        review.textReview( reviewDto.getTextReview() );
        review.rating( reviewDto.getRating() );
        review.client( clientDtoToClient( reviewDto.getClient() ) );
        review.car( carDtoToCar( reviewDto.getCar() ) );

        return review.build();
    }

    protected List<CarDto> carListToCarDtoList(List<Car> list) {
        if ( list == null ) {
            return null;
        }

        List<CarDto> list1 = new ArrayList<CarDto>( list.size() );
        for ( Car car : list ) {
            list1.add( carToCarDto( car ) );
        }

        return list1;
    }

    protected List<Car> carDtoListToCarList(List<CarDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Car> list1 = new ArrayList<Car>( list.size() );
        for ( CarDto carDto : list ) {
            list1.add( carDtoToCar( carDto ) );
        }

        return list1;
    }

    protected List<ReviewDto> reviewListToReviewDtoList(List<Review> list) {
        if ( list == null ) {
            return null;
        }

        List<ReviewDto> list1 = new ArrayList<ReviewDto>( list.size() );
        for ( Review review : list ) {
            list1.add( reviewToReviewDto( review ) );
        }

        return list1;
    }

    protected List<ClientDto> clientListToClientDtoList(List<Client> list) {
        if ( list == null ) {
            return null;
        }

        List<ClientDto> list1 = new ArrayList<ClientDto>( list.size() );
        for ( Client client : list ) {
            list1.add( clientToClientDto( client ) );
        }

        return list1;
    }

    protected List<Review> reviewDtoListToReviewList(List<ReviewDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Review> list1 = new ArrayList<Review>( list.size() );
        for ( ReviewDto reviewDto : list ) {
            list1.add( reviewDtoToReview( reviewDto ) );
        }

        return list1;
    }

    protected List<Client> clientDtoListToClientList(List<ClientDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Client> list1 = new ArrayList<Client>( list.size() );
        for ( ClientDto clientDto : list ) {
            list1.add( clientDtoToClient( clientDto ) );
        }

        return list1;
    }
}
