package ru.clevertec.dealer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import ru.clevertec.dealer.dao.CarRepositoryCustom;
import ru.clevertec.dealer.dto.CarDto;
import ru.clevertec.dealer.dto.ReviewDto;
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
        Optional<CarDto> carDto = carRepository.findById(id).map(INSTANCE::carToCarDto);
        carDto.orElseThrow(() -> new NotFoundException("Авто найдено по id"));
        return carDto;
    }

    public List<CarDto> findAllCars(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return carRepository.findAll(pageable).stream().map(INSTANCE::carToCarDto).toList();
    }

    public Optional<CarDto> create(CarDto carDto) {
        Car car = INSTANCE.carDtoToCar(carDto);
        carRepository.save(car);
        return Optional.ofNullable(carDto);
    }

    public void update(Long id, CarDto carDto) {
        Car car = carRepository.findById(id).orElseThrow(() -> new NotFoundException("Обновляемый авто найдено по id"));
        Car carUpdate = INSTANCE.updateCarFromCarDto(carDto, car);
        carRepository.save(carUpdate);
    }

    public void delete(Long id) {
        Optional<Car> car = carRepository.findById(id);
        car.ifPresentOrElse(carRepository::delete, () -> {
            throw new NotFoundException("Удаляемый авто найдено по id");
        });
    }

    public List<CarDto> getCarsByFilter(CarParam carParam, int pageNumber, int pageSize) {
        List<Car> filterCar = carRepositoryCustom.getFilterCar(carParam, pageNumber, pageSize);
        return filterCar.stream().map(CarMapper.INSTANCE::carToCarDto).toList();
    }

    public void addReviewOnCar(Long carId, ReviewDto reviewDto) {
        Optional<Car> carById = Optional.ofNullable(carRepository.findById(carId).orElseThrow(() -> new NotFoundException("Авто для добавления ревью не найдено")));
        carById.ifPresent(car -> car.addReviewOnCar(INSTANCE.reviewDtoToReview(reviewDto)));
        carById.ifPresent(carRepository::save);
    }

}
