package ru.clevertec.dealer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
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

import java.lang.annotation.Target;


@Mapper
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    @Mapping(target = "carInStore", ignore = true)
    CarShowroomDto carShowroomToCarShowroomDto(CarShowroom carShowroom);
    CarShowroom carShowroomDtoToCarShowroom(CarShowroomDto carShowroomDto);

    CarDto carToCarDto(Car car);
    Car updateCarFromCarDto(CarDto carDto, @MappingTarget Car car);
    Car carDtoToCar(CarDto carDto);

    @Mappings({@Mapping(target = "cars", ignore = true), @Mapping(target = "reviewOnCar", ignore = true)})
    ClientDto clientToClientDto(Client client);
    Client clientDtoToClient(ClientDto clientDto);

    @Mapping(target = "listOfCar", ignore = true)
    CategoryDto categoryToCategoryDto(Category category);
    Category categoryDtoToCategory(CategoryDto categoryDto);

    @Mapping(target = "car", ignore = true)
    ReviewDto reviewToReviewDto(Review review);
    Review reviewDtoToReview(ReviewDto reviewDto);





}
