package com.beesdev.controller.thymeleafController.user_controller_thymeleaf;

import com.beesdev.dto.user_dtos.user_dto.UserDto;
import com.beesdev.dto.user_dtos.user_dto.user_dto_requests.CreateUserRequest;
import com.beesdev.dto.user_dtos.userdetails_dto.userdetails_dto_requests.CreateUserDetailsRequest;
import com.beesdev.service.user_service.UserDetailsService;
import com.beesdev.service.user_service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/v1/user")
public class UserControllerTL {
    private final UserService userService;
    private final UserDetailsService userDetailsService;

    public UserControllerTL(UserService userService, UserDetailsService userDetailsService) {
        this.userService = userService;
        this.userDetailsService = userDetailsService;
    }


    @GetMapping("/view-profile-section")
    public String getUserDetails(Model model) {
        UserDto userDto = userService.getUser();
        model.addAttribute("user", userDto);
        return "view-profile";
    }




    @GetMapping("admin/showAllActiveUsers")
    public String getAllUsers(Model model) {
        List<UserDto> getAllUsers = userService.getAllActiveUsers();

        model.addAttribute("allUser", getAllUsers);
        return "admin-show-all-active-users";
    }



    @GetMapping("showUserForm")
    public String showCreateForm(Model model) {
        model.addAttribute("user", new CreateUserRequest());


        return "register-user";
    }

    @PostMapping("createUserForm")
    public String createAdvertisement(@ModelAttribute("user") CreateUserRequest userRequest, RedirectAttributes attributes) {


         UserDto createdUser =userService.createUser(userRequest);
        attributes.addAttribute("userId", createdUser.getId());

        return "redirect:/v1/user/showUserDetailsForm";
    }




    @GetMapping("showUserDetailsForm")
    public String showUserDetailsForm(Model model) {
        model.addAttribute("userDetails", new CreateUserDetailsRequest());
        return "register-userDetails";
    }

    @PostMapping("createUserDetailsForm")
    public String processUserDetailsForm(CreateUserDetailsRequest userDetailsRequest, BindingResult result) {
        if (result.hasErrors()) {
            return "register-userDetails";
        }
        userDetailsService.createUserDetails(userDetailsRequest);
        return "redirect:/login";
    }

    ///////////////////////////////
    ///////////////////////////////

    @GetMapping("admin/activateUserById/{id}")
    public String activateUserById(@PathVariable Long id, Model model) {

        UserDto user=userService.activateUser(id);

        model.addAttribute("user", user);
        return "redirect:/v1/user/admin/showAllActiveUsers";

    }

    @GetMapping("admin/deactivateUserById/{id}")
    public String deactivateUserById(@PathVariable Long id, Model model) {

        UserDto user=userService.deactivateUser(id);

        model.addAttribute("user", user);
        return "redirect:/v1/user/admin/showAllInActiveUsers";

    }





    @GetMapping("admin/showAllInActiveUsers")
    public String getAllInActiveUsers(Model model) {
        List<UserDto> getAllInactiveUsers = userService.getAllInactiveUsers();

        model.addAttribute("inActiveUsers", getAllInactiveUsers);
        return "admin-show-all-inactive-users";
    }

    @GetMapping("admin/delete_UserById/{id}")
    public String deleteUserById(@PathVariable Long id, Model model) {

        UserDto user=userService.deleteUser(id);

        model.addAttribute("user", user);
        return "redirect:/v1/user/admin/showAllInActiveUsers";

    }





}
