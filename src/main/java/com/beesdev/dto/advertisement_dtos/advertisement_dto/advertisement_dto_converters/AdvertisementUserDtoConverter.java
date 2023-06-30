package com.beesdev.dto.advertisement_dtos.advertisement_dto.advertisement_dto_converters;

import com.beesdev.dto.advertisement_dtos.advertisement_dto.AdvertisementUserDto;
import com.beesdev.dto.user_dtos.user_dto.user_dto_converters.UserDtoConverter;
import com.beesdev.dto.user_dtos.userdetails_dto.userdetails_dto_converters.UsersDetailsDtoConverter;
import com.beesdev.model.advertisement_model.Advertisement;
import com.beesdev.dto.image_dtos.image_dto_converters.ImageDtoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AdvertisementUserDtoConverter {
    private final AdvertisementDtoConverter advertisementDtoConverter;
    private final ImageDtoConverter ImageDtoConverter;
    private final UsersDetailsDtoConverter usersDetailsDtoConverter;

    public AdvertisementUserDtoConverter(AdvertisementDtoConverter advertisementDtoConverter, ImageDtoConverter ImageDtoConverter, UserDtoConverter userDtoConverter, UsersDetailsDtoConverter usersDetailsDtoConverter) {
        this.advertisementDtoConverter = advertisementDtoConverter;
        this.ImageDtoConverter = ImageDtoConverter;
        this.usersDetailsDtoConverter = usersDetailsDtoConverter;
    }

    public AdvertisementUserDto convert(Advertisement from) {
        return new AdvertisementUserDto(
                from.getId(),
                from.getTitle(),
                from.getDescription(),
                from.getCategory().getCategoryName(),
                from.getPrice(),
                from.getCreationDate(),
                from.getLastModifiedDate(),
                from.getUser().getUsername(),
                from.getUser().getMail(),
                ImageDtoConverter.convert(new ArrayList<>(from.getImagesSet())),
                advertisementDtoConverter.convert(new ArrayList<>
                        (from.getUser().getAdvertisementSet())),
                usersDetailsDtoConverter.convert(new ArrayList<>(from.getUser().getUserDetailsSet()))
                );



    }
    public List<AdvertisementUserDto> convert(List<Advertisement> from){
        return from.stream().map(this::convert).collect(Collectors.toList());
    }

}
