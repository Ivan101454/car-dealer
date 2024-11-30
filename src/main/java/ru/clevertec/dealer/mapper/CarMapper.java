package ru.clevertec.dealer.mapper;

import org.mapstruct.Mapper;
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


@Mapper
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    CarShowroomDto carShowroomToCarShowroomDto(CarShowroom carShowroom);
    CarShowroom carShowroomDtoToCarShowroom(CarShowroomDto carShowroomDto);

    CarDto carToCarDto(Car car);
    Car carDtoToCar(CarDto carDto);

    ClientDto clientToClientDto(Client client);
    Client clientDtoToClient(ClientDto clientDto);

    CategoryDto categoryToCategoryDto(Category category);
    Category categoryDtoToCategory(CategoryDto categoryDto);

    ReviewDto reviewToReviewDto(Review review);
    Review reviewDtoToReview(ReviewDto reviewDto);





}
