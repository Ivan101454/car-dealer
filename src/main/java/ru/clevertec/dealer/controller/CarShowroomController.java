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
import ru.clevertec.dealer.dto.CarShowroomDto;
import ru.clevertec.dealer.service.CarShowroomService;


import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/carshowroom")
public class CarShowroomController {

    private final CarShowroomService carShowroomService;

    @GetMapping("/byid")
    public ResponseEntity<CarShowroomDto> findCarShowroomById(@PathVariable Long id) {
        Optional<CarShowroomDto> byId = carShowroomService.findById(id);
        return byId.map(showroom -> new ResponseEntity<>(showroom, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @GetMapping("/findall")
    public ResponseEntity<List<CarShowroomDto>> findAllCarShowroom(@RequestParam(defaultValue = "1") int pageNumber,
                                                                   @RequestParam(defaultValue = "10") int pageSize) {
        List<CarShowroomDto> allCars = carShowroomService.findAllStore(pageNumber, pageSize);
        return new ResponseEntity<>(allCars, HttpStatus.OK);
    }

    @PostMapping("create")
    public Optional<CarShowroomDto> create(@RequestBody CarShowroomDto carShowroomDto) {
        return carShowroomService.create(carShowroomDto);
    }

    @PostMapping("/update")
    public void update(@PathVariable Long id, @RequestBody CarShowroomDto carShowroomDto) {
        carShowroomService.update(id, carShowroomDto);
    }

    @PostMapping("/delete")
    public void delete(@PathVariable Long id) {
        carShowroomService.delete(id);
    }

    @PostMapping("/addCar")
    private void addCarToShowroom(Long id, @RequestBody CarDto carDto) {
        carShowroomService.addCarToStore(id, carDto);
    }
}
