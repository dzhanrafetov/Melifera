package com.beesdev.controller.thymeleafController;

import com.beesdev.service.user_service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginForm(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            // User is already logged in, redirect to the appropriate page
            return redirectToUserRole();
        }

        return "login";
    }

    private String redirectToUserRole() {
        String userRole = String.valueOf(userService.getCurrentUser().getRole());
          if (userRole.equals("ROLE_USER")) {
            return "redirect:/v1/advertisement/all/main-menu-advertisements";
        }
          else  if (userRole.equals("ROLE_ADMIN")) {
                return "redirect:/v1/advertisement/admin/main-menu";
        }else

        return "redirect:/login";
    }
}
