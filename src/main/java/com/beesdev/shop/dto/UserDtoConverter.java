package com.beesdev.shop.dto;

import com.beesdev.shop.dto.UserDto;
import com.beesdev.shop.model.User;
import org.springframework.stereotype.Component;
//naprimer otkoga nqko user e aktiven

//tazi smetka se pravi v dto convertera  ne v service
//moje i druga smetka 2022-2004
@Component
public class UserDtoConverter {

    public UserDto convert(User from){
        //da kajem shte vzema informaciq,danni ot drug servis,tuka go dobavqm

        return new UserDto(from.getId(),from.getFirstName(),
                from.getLastName(),from.getMail(), from.getPhoneNum());

    }
}
