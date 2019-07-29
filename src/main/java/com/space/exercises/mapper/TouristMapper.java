package com.space.exercises.mapper;

import com.space.exercises.domain.Tourist;
import com.space.exercises.dto.TouristDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TouristMapper {

    public Tourist mapToTourist(TouristDto touristDto) {
        return new Tourist(touristDto.getId(),
                touristDto.getFirstname(),
                touristDto.getLastname(),
                touristDto.getMale(),
                touristDto.getCountry(),
                touristDto.getBirthDate());
    }

    public List<Tourist> mapToTouristList(List<TouristDto> touristDtos) {
        return touristDtos.stream()
                .map(touristDto ->  new Tourist(touristDto.getId(),
                        touristDto.getFirstname(),
                        touristDto.getLastname(),
                        touristDto.getMale(),
                        touristDto.getCountry(),
                        touristDto.getBirthDate()))
                .collect(Collectors.toList());
    }

    public TouristDto mapToTouristDto(Tourist tourist) {
        return new TouristDto(tourist.getId(),
                tourist.getFirstname(),
                tourist.getLastname(),
                tourist.getMale(),
                tourist.getCountry(),
                tourist.getBirthDate());
    }

    public List<TouristDto> mapToTouristDtoList(List<Tourist> tourists) {
        return tourists.stream()
                .map(tourist -> new TouristDto(tourist.getId(),
                        tourist.getFirstname(),
                        tourist.getLastname(),
                        tourist.getMale(),
                        tourist.getCountry(),
                        tourist.getBirthDate()))
                .collect(Collectors.toList());
    }
}
