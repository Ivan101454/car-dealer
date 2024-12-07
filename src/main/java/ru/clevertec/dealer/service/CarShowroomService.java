package ru.clevertec.dealer.service;

import lombok.RequiredArgsConstructor;
import ru.clevertec.dealer.dto.CarDto;
import ru.clevertec.dealer.dto.CarShowroomDto;
import ru.clevertec.dealer.entity.CarShowroom;
import ru.clevertec.dealer.mapper.CarMapper;
import ru.clevertec.dealer.dao.CarShowroomRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CarShowroomService {

    private final CarShowroomRepository carShowroomRepository;

    public Optional<CarShowroomDto> findById(Long id) {
        return carShowroomRepository.finById(id).map(CarMapper.INSTANCE::carShowroomToCarShowroomDto);
    }

    public List<CarShowroomDto> findAllStore() {
        return carShowroomRepository.findAll().stream().map(CarMapper.INSTANCE::carShowroomToCarShowroomDto).toList();
    }

    public CarShowroom create(CarShowroomDto carShowroomDto) {
        CarShowroom carShowroom = CarMapper.INSTANCE.carShowroomDtoToCarShowroom(carShowroomDto);
        return carShowroomRepository.save(carShowroom);
    }

    public void update(CarShowroomDto carShowroomDto) {
        carShowroomRepository.update(CarMapper.INSTANCE.carShowroomDtoToCarShowroom(carShowroomDto));
    }

    public boolean delete(Long id) {
        Optional<CarShowroom> carShowroom = carShowroomRepository.finById(id);
        carShowroom.ifPresent(a -> carShowroomRepository.delete(a.getShowroomId()));
        return carShowroom.isPresent();
    }

    public void addCarToStore(CarDto carDto, Long idOfCarShowroom) {
        Optional<CarShowroom> carShowroom = Optional.ofNullable(carShowroomRepository.finById(idOfCarShowroom)
                .orElseThrow(() -> new RuntimeException("Шоурум не найден")));
        carShowroom.ifPresent(show -> show.addCarToStore(CarMapper.INSTANCE.carDtoToCar(carDto)));
        carShowroom.ifPresent(carShowroomRepository::update);
    }


}
