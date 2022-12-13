package com.beesdev.shop.controller;

import com.beesdev.shop.dto.CreateUserRequest;
import com.beesdev.shop.dto.UpdateUserRequest;
import com.beesdev.shop.dto.UserDto;
import com.beesdev.shop.model.User;
import com.beesdev.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("id/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));

    }

    @GetMapping("mail/{mail}")
    public ResponseEntity<UserDto> getUserByMail(@PathVariable String mail){
        return ResponseEntity.ok(userService.getUserByMail(mail));
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserRequest userRequest) {
        return ResponseEntity.ok(userService.createUser(userRequest));

    }

    @PutMapping("id/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UpdateUserRequest updateUserRequest) {
        return ResponseEntity.ok(userService.updateUser(id, updateUserRequest));
    }

    //GDPR ako sobstenika na akaunta kaje iztriy mi akaunta trqbva da go iztriem
    @PatchMapping("deactive/{id}")
    public ResponseEntity<Void> deactiveUser(@PathVariable("id") Long id) {
        userService.deactiveUser(id);
        return ResponseEntity.ok().build();

    }

    @PatchMapping("active/{id}")
    public ResponseEntity<Void> activeUser(@PathVariable("id") Long id) {
        userService.activeUser(id);
        return ResponseEntity.ok().build();

    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();


    }


}