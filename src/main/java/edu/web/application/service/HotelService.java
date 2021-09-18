package edu.web.application.service;

import edu.web.application.api.dto.HotelDto;
import edu.web.application.exception.ProjectException;
import edu.web.application.model.specification.HotelSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HotelService {

    HotelDto get(Long id) throws ProjectException;

    HotelDto add(HotelDto HotelDto);

    HotelDto update(Long id, HotelDto HotelDto);

    void delete(Long id) throws ProjectException;

    Page<HotelDto> get(HotelSpecification specification, Pageable pageable);
}
