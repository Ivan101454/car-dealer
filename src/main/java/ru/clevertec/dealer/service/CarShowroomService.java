package ru.clevertec.dealer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.clevertec.dealer.dto.CarDto;
import ru.clevertec.dealer.dto.CarShowroomDto;
import ru.clevertec.dealer.entity.CarShowroom;
import ru.clevertec.dealer.exception.NotFoundException;
import ru.clevertec.dealer.mapper.CarMapper;
import ru.clevertec.dealer.repository.CarShowroomRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class CarShowroomService {

    private final CarShowroomRepository carShowroomRepository;
    private final CarMapper INSTANCE;

    public Optional<CarShowroomDto> findById(Long id) {
        Optional<CarShowroomDto> carShowroomDto = carShowroomRepository.findById(id).map(INSTANCE::carShowroomToCarShowroomDto);
        carShowroomDto.orElseThrow(() -> new NotFoundException("Шоурум не найден по Id"));
        return carShowroomDto;
    }

    public List<CarShowroomDto> findAllStore(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return carShowroomRepository.findAll(pageable).stream().map(CarMapper.INSTANCE::carShowroomToCarShowroomDto).toList();
    }

    public Optional<CarShowroomDto> create(CarShowroomDto carShowroomDto) {
        CarShowroom carShowroom = INSTANCE.carShowroomDtoToCarShowroom(carShowroomDto);
        carShowroomRepository.save(carShowroom);
        return Optional.ofNullable(carShowroomDto);
    }

    public void update(Long id, CarShowroomDto carShowroomDto) {
        CarShowroom carShowroom = carShowroomRepository.findById(id).orElseThrow(() -> new NotFoundException("Не найден обновляемы шоурум по id"));
        INSTANCE.updateCarShowroomFromCarShowroomDto(carShowroomDto, carShowroom);
        carShowroomRepository.save(carShowroom);
    }

    public void delete(Long id) {
        Optional<CarShowroom> carShowroom = carShowroomRepository.findById(id);
        carShowroom.ifPresentOrElse(carShowroomRepository::delete, () -> new NotFoundException("Не найден удаляемы шоурум по id"));
    }

    public void addCarToStore(Long idOfCarShowroom, CarDto carDto) {
        Optional<CarShowroom> carShowroom = Optional.ofNullable(carShowroomRepository.findById(idOfCarShowroom)
                .orElseThrow(() -> new NotFoundException("Целевой шоурум не найден")));
        carShowroom.ifPresent(show -> show.addCarToStore(INSTANCE.carDtoToCar(carDto)));
        carShowroom.ifPresent(carShowroomRepository::save);
    }


}
