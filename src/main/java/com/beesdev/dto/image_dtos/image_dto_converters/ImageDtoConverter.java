package com.beesdev.dto.image_dtos.image_dto_converters;

import com.beesdev.dto.image_dtos.ImageDto;
import com.beesdev.model.image_model.Image;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component

public class ImageDtoConverter {
    public List<ImageDto> convert(List<Image> from){
        return from.stream().map(this::convert).collect(Collectors.toList());
    }

    public ImageDto convert(Image from) {
        return new ImageDto(from.getId(),
                from.getName(),
                from.getUrl());
    }
}
