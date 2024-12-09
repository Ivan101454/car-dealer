package ru.clevertec.dealer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import ru.clevertec.dealer.dao.CarRepositoryCustom;
import ru.clevertec.dealer.dto.CarDto;
import ru.clevertec.dealer.entity.Car;
import ru.clevertec.dealer.exception.NotFoundException;
import ru.clevertec.dealer.filter.CarParam;
import ru.clevertec.dealer.mapper.CarMapper;
import ru.clevertec.dealer.repository.CarRepository;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final CarRepositoryCustom carRepositoryCustom;
    private final CarMapper INSTANCE;

    public Optional<CarDto> findById(Long id) {
        carRepository.findById(id).map(INSTANCE::carToCarDto).orElseThrow(() -> new NotFoundException("Не найдено по id"));
        return carRepository.findById(id).map(INSTANCE::carToCarDto);
    }

    public List<CarDto> findAllCars() {
        return carRepository.findAll().stream().map(INSTANCE::carToCarDto).toList();
    }

    public Optional<CarDto> create(CarDto carDto) {
        Car car = INSTANCE.carDtoToCar(carDto);
        carRepository.save(car);
        return Optional.ofNullable(carDto);
    }

    public void update(Long id, CarDto carDto) {
        Car car = carRepository.findById(id).orElseThrow(() -> new NotFoundException("Не найдено по id"));
        Car carUpdate = INSTANCE.updateCarFromCarDto(carDto, car);
        carRepository.save(carUpdate);
    }

    public void delete(Long id) {
        Optional<Car> car = carRepository.findById(id);
        car.ifPresentOrElse(carRepository::delete, () -> {
            throw new NotFoundException("Не найдено по id");
        });
    }

    public List<CarDto> getCarsByFilter(CarParam carParam, int pageNumber, int pageSize) {
        List<Car> filterCar = carRepositoryCustom.getFilterCar(carParam, pageNumber, pageSize);
        return filterCar.stream().map(CarMapper.INSTANCE::carToCarDto).toList();
    }

}
