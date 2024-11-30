package ru.clevertec.dealer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.clevertec.dealer.dto.CarShowroomDto;
import ru.clevertec.dealer.entity.CarShowroom;


@Mapper
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    CarShowroomDto carShowroomToCarShowroomDto(CarShowroom carShowroom);
    CarShowroom carShowroomDtoToCarShowroom(CarShowroomDto carShowroomDto);


}
