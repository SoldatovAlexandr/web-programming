package edu.web.application.api;

import edu.web.application.api.dto.HotelDto;
import edu.web.application.exception.ProjectException;
import edu.web.application.model.specification.HotelSpecification;
import edu.web.application.service.HotelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/hotel")
public class HotelController {

    private final HotelService hotelService;

    @GetMapping("/{id}")
    public HotelDto get(@PathVariable("id") Long id) throws ProjectException {
        log.info("Get hotel bu id [{}]", id);
        return hotelService.get(id);
    }

    @PostMapping("/")
    public HotelDto add(@Valid @RequestBody HotelDto HotelDto) {
        log.info("Add new hotel with request [{}]", HotelDto);
        return hotelService.add(HotelDto);
    }

    @PutMapping("/{id}")
    public HotelDto update(@PathVariable("id") Long id, @Valid @RequestBody HotelDto HotelDto) {
        log.info("Update hotel with request [{}]", HotelDto);
        return hotelService.update(id, HotelDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws ProjectException {
        log.info("Delete hotel by id [{}]", id);
        hotelService.delete(id);
    }

    @GetMapping("/")
    public Page<HotelDto> get(HotelSpecification specification, Pageable pageable) {
        log.info("Get hotel by specification [{}]", specification);
        return hotelService.get(specification, pageable);
    }
}
