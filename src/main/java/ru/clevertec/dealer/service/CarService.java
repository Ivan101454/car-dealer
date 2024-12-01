package ru.clevertec.dealer.service;

import lombok.RequiredArgsConstructor;
import ru.clevertec.dealer.dto.CarDto;
import ru.clevertec.dealer.dto.CarShowroomDto;
import ru.clevertec.dealer.entity.Car;
import ru.clevertec.dealer.entity.CarShowroom;
import ru.clevertec.dealer.mapper.CarMapper;
import ru.clevertec.dealer.repository.CarRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public Optional<CarDto> findById(Long id) {
        return carRepository.finById(id).map(CarMapper.INSTANCE::carToCarDto);
    }

    public List<CarDto> findAllStore() {
        return carRepository.findAll().stream().map(CarMapper.INSTANCE::carToCarDto).toList();
    }

    public Car create(CarDto carDto) {
        Car car = CarMapper.INSTANCE.carDtoToCar(carDto);
        return carRepository.save(car);
    }

    public void update(CarDto carDto) {
        carRepository.update(CarMapper.INSTANCE.carDtoToCar(carDto));
    }

    public boolean delete(Long id) {
        Optional<Car> car = carRepository.finById(id);
        car.ifPresent(a -> carRepository.delete(a.getCarId()));
        return car.isPresent();
    }

    public List<CarDto> findByBrand(String brand) {
        return null;
    }

}
