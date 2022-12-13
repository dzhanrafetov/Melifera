package com.beesdev.shop.service;


import com.beesdev.shop.controller.UserController;
import com.beesdev.shop.dto.CreateUserRequest;
import com.beesdev.shop.dto.UpdateUserRequest;
import com.beesdev.shop.dto.UserDto;
import com.beesdev.shop.dto.UserDtoConverter;
import com.beesdev.shop.exception.UserNotActiveException;
import com.beesdev.shop.exception.UserNotFoundException;
import com.beesdev.shop.model.User;
import com.beesdev.shop.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;//injection
    private final UserDtoConverter userDtoConverter;//injection


    public UserService(UserRepository userRepository, UserDtoConverter userDtoConverter) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
    }


    //API-a ne trqbva da vrushta direktno modela
    //dto trqbva da vrushta
    //DTO-DATA TRANSFER OBJECT
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(userDtoConverter::convert).collect(Collectors.toList());
    }

    public UserDto getUserById(Long id) {
        User user = findUserById(id);
        return userDtoConverter.convert(user);
    }

    public UserDto createUser(CreateUserRequest userRequest) {
        User user = new User(userRequest.getId(), userRequest.getFirstName(), userRequest.
                getLastName(), userRequest.getMail(),
                userRequest.getCreationTime(),//null
                userRequest.getPhoneNum(),true);
        return userDtoConverter.convert(userRepository.save(user));
    }

    public UserDto updateUser(Long id,UpdateUserRequest updateUserRequest) {
        User user = findUserById(id);
        if(!user.getActive() ) {
            logger.warn(String.format("User wanted update is not active! userID: %s "+id));

           throw new UserNotActiveException();
        }
        User updatedUser = new User(user.getId(), updateUserRequest.getFirstName(), updateUserRequest.getLastName(), updateUserRequest.getMail(), updateUserRequest.getUpdateTime(),
                updateUserRequest.getPhoneNum());
        return userDtoConverter.convert(user);

    }
    public UserDto getUserByMail(String mail) {
        User user = findUserByMail(mail);
        return userDtoConverter.convert(user);
    }

    private User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User couldn't found by id" + id));
    }
    private User findUserByMail(String mail) {
            return userRepository.findByMail(mail).orElseThrow(() -> new UserNotFoundException("User couldn't found by id" + mail));

    }
    public void deactiveUser(Long id){

    }
    public void activeUser(Long id){

    }

    public void deleteUser(Long id) {
    }
}
