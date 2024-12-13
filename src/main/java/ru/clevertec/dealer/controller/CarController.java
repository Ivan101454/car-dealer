package ru.clevertec.dealer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.clevertec.dealer.dto.CarDto;
import ru.clevertec.dealer.dto.ReviewDto;
import ru.clevertec.dealer.filter.CarParam;
import ru.clevertec.dealer.service.CarService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    @GetMapping("/byid")
    public ResponseEntity<CarDto> findCarById(@PathVariable Long id) {
        Optional<CarDto> byId = carService.findById(id);
        return byId.map(car -> new ResponseEntity<>(car, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<CarDto>> findAllCar(@RequestParam(defaultValue = "1") int pageNumber,
                                                   @RequestParam(defaultValue = "10") int pageSize) {
        List<CarDto> allCars = carService.findAllCars(pageNumber, pageSize);
        return new ResponseEntity<>(allCars, HttpStatus.OK);
    }

    @PostMapping("create")
    public Optional<CarDto> create(@RequestBody CarDto carDto) {
        return carService.create(carDto);
    }

    @PostMapping("/update")
    public void update(@PathVariable Long id, @RequestBody CarDto carDto) {
        carService.update(id, carDto);
    }

    @PostMapping("/delete")
    public void delete(@PathVariable Long id) {
        carService.delete(id);
    }

    @GetMapping("/finByParam")
    public ResponseEntity<List<CarDto>> findByCarParam(@RequestBody CarParam carParam,
                                                 @RequestParam(defaultValue = "1") int pageNumber,
                                                 @RequestParam(defaultValue = "10") int pageSize) {
        List<CarDto> carsByFilter = carService.getCarsByFilter(carParam, pageNumber, pageSize);
        return new ResponseEntity<>(carsByFilter, HttpStatus.OK);
    }

    @PostMapping("/addreview")
    public void addReview(Long id, @RequestBody ReviewDto reviewDto) {
        carService.addReviewOnCar(id, reviewDto);
    }
}
