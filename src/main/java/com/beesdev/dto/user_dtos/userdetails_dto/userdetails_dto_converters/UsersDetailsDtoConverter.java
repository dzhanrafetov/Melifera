package com.beesdev.dto.user_dtos.userdetails_dto.userdetails_dto_converters;

import com.beesdev.dto.user_dtos.userdetails_dto.UserDetailsDto;
import com.beesdev.model.user_model.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsersDetailsDtoConverter {


    public UserDetailsDto convert(UserDetails from) {
        return new UserDetailsDto(
                from.getPhoneNumber(),
                from.getAddress(),
                from.getCity(),
                from.getState(),
                from.getPostCode(),
                from.getCountry(),
                from.getId());
    }

    public List<UserDetailsDto> convert(List<UserDetails> from) {
        return from.stream().map(this::convert).collect(Collectors.toList());
    }

}