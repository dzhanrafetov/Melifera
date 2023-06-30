package com.beesdev.dto.advertisement_dtos.advertisement_dto.advertisement_dto_converters;

import com.beesdev.dto.advertisement_dtos.advertisement_dto.AdvertisementDto;
import com.beesdev.model.advertisement_model.Advertisement;
import com.beesdev.dto.image_dtos.image_dto_converters.ImageDtoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AdvertisementDtoConverter {
private final ImageDtoConverter ImageDtoConverter;

    public AdvertisementDtoConverter(ImageDtoConverter ImageDtoConverter) {
        this.ImageDtoConverter = ImageDtoConverter;
    }

    public AdvertisementDto convert(Advertisement from) {
    return new AdvertisementDto(
         from.getId(),
         from.getTitle(),
         from.getDescription(),
         from.getPrice(),
         from.getCreationDate(),
         from.getLastModifiedDate(),
         from.getUser().getId(),
         from.getCategory().getCategoryName(),
            from.getArchived(),
            ImageDtoConverter.convert(new ArrayList<>(from.getImagesSet())));

    }


    public List<AdvertisementDto> convert(List<Advertisement> from){
        return from.stream().map(this::convert).collect(Collectors.toList());
    }



}
