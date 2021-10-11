package edu.web.application.api.mapper;

import edu.web.application.api.dto.HotelDto;
import edu.web.application.model.Hotel;
import org.springframework.stereotype.Component;

@Component
public class HotelMapper {

    public Hotel to(HotelDto hotelDto) {
        return Hotel.builder()
                .name(hotelDto.getName())
                .directorName(hotelDto.getDirectorName())
                .countVisitor(hotelDto.getCountVisitor())
                .address(hotelDto.getAddress())
                .build();
    }

    public HotelDto from(Hotel hotel) {
        return HotelDto.builder()
                .id(hotel.getId())
                .name(hotel.getName())
                .directorName(hotel.getDirectorName())
                .countVisitor(hotel.getCountVisitor())
                .address(hotel.getAddress())
                .build();
    }
}
