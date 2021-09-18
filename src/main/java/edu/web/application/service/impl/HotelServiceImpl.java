package edu.web.application.service.impl;

import edu.web.application.api.dto.HotelDto;
import edu.web.application.api.dto.HotelDto;
import edu.web.application.api.mapper.HotelMapper;
import edu.web.application.exception.ProjectException;
import edu.web.application.model.Hotel;
import edu.web.application.model.specification.HotelSpecification;
import edu.web.application.model.specification.HotelSpecification;
import edu.web.application.repository.HotelRepository;
import edu.web.application.service.HotelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;

    @Override
    public HotelDto get(Long id) throws ProjectException {
        Hotel Hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new ProjectException("Отель не найден."));
        return hotelMapper.from(Hotel);
    }

    @Override
    public HotelDto add(HotelDto HotelDto) {
        Hotel Hotel = hotelMapper.to(HotelDto);
        hotelRepository.save(Hotel);
        return hotelMapper.from(Hotel);
    }

    @Override
    public HotelDto update(Long id, HotelDto HotelDto) {
        Hotel Hotel = hotelMapper.to(HotelDto);
        hotelRepository.save(Hotel);
        return hotelMapper.from(Hotel);
    }

    @Override
    public void delete(Long id) throws ProjectException {
        Hotel Hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new ProjectException("Отель не найден."));
        hotelRepository.delete(Hotel);
    }

    @Override
    public Page<HotelDto> get(HotelSpecification specification, Pageable pageable) {
        return hotelRepository.findAll(specification, pageable).map(hotelMapper::from);
    }
}
