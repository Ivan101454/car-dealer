package ru.clevertec.dealer.mapper;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
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
import ru.clevertec.dealer.enums.Body;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-13T22:34:41+0300",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.4 (Amazon.com Inc.)"
)
@Component
public class CarMapperImpl implements CarMapper {

    @Override
    public CarShowroomDto carShowroomToCarShowroomDto(CarShowroom carShowroom) {
        if ( carShowroom == null ) {
            return null;
        }

        String nameOfShowroom = null;
        String addressOfShowroom = null;

        nameOfShowroom = carShowroom.getNameOfShowroom();
        addressOfShowroom = carShowroom.getAddressOfShowroom();

        List<CarDto> carInStore = null;

        CarShowroomDto carShowroomDto = new CarShowroomDto( nameOfShowroom, addressOfShowroom, carInStore );

        return carShowroomDto;
    }

    @Override
    public CarShowroom updateCarShowroomFromCarShowroomDto(CarShowroomDto carShowroomDto, CarShowroom carShowroom) {
        if ( carShowroomDto == null ) {
            return carShowroom;
        }

        carShowroom.setNameOfShowroom( carShowroomDto.nameOfShowroom() );
        carShowroom.setAddressOfShowroom( carShowroomDto.addressOfShowroom() );
        if ( carShowroom.getCarInStore() != null ) {
            List<Car> list = carDtoListToCarList( carShowroomDto.carInStore() );
            if ( list != null ) {
                carShowroom.getCarInStore().clear();
                carShowroom.getCarInStore().addAll( list );
            }
            else {
                carShowroom.setCarInStore( null );
            }
        }
        else {
            List<Car> list = carDtoListToCarList( carShowroomDto.carInStore() );
            if ( list != null ) {
                carShowroom.setCarInStore( list );
            }
        }

        return carShowroom;
    }

    @Override
    public CarShowroom carShowroomDtoToCarShowroom(CarShowroomDto carShowroomDto) {
        if ( carShowroomDto == null ) {
            return null;
        }

        CarShowroom.CarShowroomBuilder carShowroom = CarShowroom.builder();

        carShowroom.nameOfShowroom( carShowroomDto.nameOfShowroom() );
        carShowroom.addressOfShowroom( carShowroomDto.addressOfShowroom() );
        carShowroom.carInStore( carDtoListToCarList( carShowroomDto.carInStore() ) );

        return carShowroom.build();
    }

    @Override
    public CarDto carToCarDto(Car car) {
        if ( car == null ) {
            return null;
        }

        String carBrand = null;
        String carModel = null;
        int year = 0;
        BigDecimal price = null;
        CategoryDto categoryBody = null;
        CarShowroomDto carShowroom = null;
        List<ReviewDto> reviewsOnCar = null;
        List<ClientDto> clients = null;

        carBrand = car.getCarBrand();
        carModel = car.getCarModel();
        year = car.getYear();
        price = car.getPrice();
        categoryBody = categoryToCategoryDto( car.getCategoryBody() );
        carShowroom = carShowroomToCarShowroomDto( car.getCarShowroom() );
        reviewsOnCar = reviewListToReviewDtoList( car.getReviewsOnCar() );
        clients = clientListToClientDtoList( car.getClients() );

        CarDto carDto = new CarDto( carBrand, carModel, year, price, categoryBody, carShowroom, reviewsOnCar, clients );

        return carDto;
    }

    @Override
    public Car updateCarFromCarDto(CarDto carDto, Car car) {
        if ( carDto == null ) {
            return car;
        }

        car.setCarBrand( carDto.carBrand() );
        car.setCarModel( carDto.carModel() );
        car.setYear( carDto.year() );
        car.setPrice( carDto.price() );
        car.setCategoryBody( categoryDtoToCategory( carDto.categoryBody() ) );
        if ( carDto.carShowroom() != null ) {
            if ( car.getCarShowroom() == null ) {
                car.setCarShowroom( CarShowroom.builder().build() );
            }
            updateCarShowroomFromCarShowroomDto( carDto.carShowroom(), car.getCarShowroom() );
        }
        else {
            car.setCarShowroom( null );
        }
        if ( car.getReviewsOnCar() != null ) {
            List<Review> list = reviewDtoListToReviewList( carDto.reviewsOnCar() );
            if ( list != null ) {
                car.getReviewsOnCar().clear();
                car.getReviewsOnCar().addAll( list );
            }
            else {
                car.setReviewsOnCar( null );
            }
        }
        else {
            List<Review> list = reviewDtoListToReviewList( carDto.reviewsOnCar() );
            if ( list != null ) {
                car.setReviewsOnCar( list );
            }
        }
        if ( car.getClients() != null ) {
            List<Client> list1 = clientDtoListToClientList( carDto.clients() );
            if ( list1 != null ) {
                car.getClients().clear();
                car.getClients().addAll( list1 );
            }
            else {
                car.setClients( null );
            }
        }
        else {
            List<Client> list1 = clientDtoListToClientList( carDto.clients() );
            if ( list1 != null ) {
                car.setClients( list1 );
            }
        }

        return car;
    }

    @Override
    public Car carDtoToCar(CarDto carDto) {
        if ( carDto == null ) {
            return null;
        }

        Car.CarBuilder car = Car.builder();

        car.carBrand( carDto.carBrand() );
        car.carModel( carDto.carModel() );
        car.year( carDto.year() );
        car.price( carDto.price() );
        car.categoryBody( categoryDtoToCategory( carDto.categoryBody() ) );
        car.carShowroom( carShowroomDtoToCarShowroom( carDto.carShowroom() ) );
        car.reviewsOnCar( reviewDtoListToReviewList( carDto.reviewsOnCar() ) );
        car.clients( clientDtoListToClientList( carDto.clients() ) );

        return car.build();
    }

    @Override
    public ClientDto clientToClientDto(Client client) {
        if ( client == null ) {
            return null;
        }

        String nameOfCustomer = null;
        List<String> contacts = null;
        LocalDate dateOfRegistration = null;

        nameOfCustomer = client.getNameOfCustomer();
        List<String> list = client.getContacts();
        if ( list != null ) {
            contacts = new ArrayList<String>( list );
        }
        dateOfRegistration = client.getDateOfRegistration();

        List<CarDto> cars = null;
        List<ReviewDto> reviewOnCar = null;

        ClientDto clientDto = new ClientDto( nameOfCustomer, contacts, dateOfRegistration, cars, reviewOnCar );

        return clientDto;
    }

    @Override
    public Client clientDtoToClient(ClientDto clientDto) {
        if ( clientDto == null ) {
            return null;
        }

        Client.ClientBuilder client = Client.builder();

        client.nameOfCustomer( clientDto.nameOfCustomer() );
        List<String> list = clientDto.contacts();
        if ( list != null ) {
            client.contacts( new ArrayList<String>( list ) );
        }
        client.dateOfRegistration( clientDto.dateOfRegistration() );
        client.cars( carDtoListToCarList( clientDto.cars() ) );
        client.reviewOnCar( reviewDtoListToReviewList( clientDto.reviewOnCar() ) );

        return client.build();
    }

    @Override
    public CategoryDto categoryToCategoryDto(Category category) {
        if ( category == null ) {
            return null;
        }

        Body body = null;

        body = category.getBody();

        List<CarDto> listOfCar = null;

        CategoryDto categoryDto = new CategoryDto( body, listOfCar );

        return categoryDto;
    }

    @Override
    public Category categoryDtoToCategory(CategoryDto categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        Category.CategoryBuilder category = Category.builder();

        category.body( categoryDto.body() );
        category.listOfCar( carDtoListToCarList( categoryDto.listOfCar() ) );

        return category.build();
    }

    @Override
    public ReviewDto reviewToReviewDto(Review review) {
        if ( review == null ) {
            return null;
        }

        String textReview = null;
        int rating = 0;
        ClientDto client = null;

        textReview = review.getTextReview();
        rating = review.getRating();
        client = clientToClientDto( review.getClient() );

        CarDto car = null;

        ReviewDto reviewDto = new ReviewDto( textReview, rating, client, car );

        return reviewDto;
    }

    @Override
    public Review reviewDtoToReview(ReviewDto reviewDto) {
        if ( reviewDto == null ) {
            return null;
        }

        Review.ReviewBuilder review = Review.builder();

        review.textReview( reviewDto.textReview() );
        review.rating( reviewDto.rating() );
        review.client( clientDtoToClient( reviewDto.client() ) );
        review.car( carDtoToCar( reviewDto.car() ) );

        return review.build();
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
