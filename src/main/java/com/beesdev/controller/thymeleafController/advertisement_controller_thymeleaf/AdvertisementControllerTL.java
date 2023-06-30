package com.beesdev.controller.thymeleafController.advertisement_controller_thymeleaf;

import com.beesdev.dto.advertisement_dtos.advertisement_dto.AdvertisementDto;
import com.beesdev.dto.advertisement_dtos.advertisement_dto.AdvertisementUserDto;
import com.beesdev.dto.advertisement_dtos.advertisement_dto.advertisement_dto_requests.CreateAdvertisementRequest;
import com.beesdev.dto.advertisement_dtos.category_dto.CategoryDto;
import com.beesdev.dto.image_dtos.image_dto_requests.ImageUploadRequest;
import com.beesdev.dto.user_dtos.user_dto.UserDto;
import com.beesdev.service.advertisement_service.AdvertisementService;
import com.beesdev.service.advertisement_service.CategoryService;
import com.beesdev.service.image_service.ImageService;
import com.beesdev.service.user_service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/v1/advertisement")
public class AdvertisementControllerTL {
    private final UserService userService;

        private final AdvertisementService advertisementService;
        private final CategoryService categoryService;
    private final ImageService imageService;


    public AdvertisementControllerTL(UserService userService, AdvertisementService advertisementService, CategoryService categoryService, ImageService imageService) {
        this.userService = userService;
        this.advertisementService = advertisementService;
            this.categoryService = categoryService;
        this.imageService = imageService;
    }

    @GetMapping("/tl-getAdvertisementById/{id}")
    public String getAdvertisementById(@PathVariable String id, Model model) {
        AdvertisementUserDto advertisement = advertisementService.getAdvertisementUserById(id);
        model.addAttribute("advertisement", advertisement);
        return "advertisement-details";
    }

    @GetMapping("/tl-archiveAdvertisementById/{id}")
    public String archiveAdvertisementById(@PathVariable String id, Model model) {
        AdvertisementUserDto advertisement = advertisementService.archiveAdvertisementByUser(id);
        model.addAttribute("advertisement", advertisement);
        return "redirect:/v1/advertisement/user-active-advertisements";
    }


    @GetMapping("/all/main-menu-advertisements")
    public String getActiveAdvertisements(Model model) {
        List<AdvertisementUserDto> advertisements = advertisementService.getActiveAdvertisementsUser();
        model.addAttribute("advertisements", advertisements);
        return "index";
    }





    @GetMapping("/all/advertisements-section")
    public String getActiveAdvertisementsSection(Model model) {
        List<AdvertisementUserDto> advertisements = advertisementService.getActiveAdvertisementsUser();
        model.addAttribute("advertisements", advertisements);
        return "advertisements";
    }
    @GetMapping("/user-active-advertisements")
    public String getUserActiveAdvertisements(Model model) {
        List<AdvertisementDto> advertisements = advertisementService.getActiveAdvertisementsAddedByUser();
        model.addAttribute("advertisements", advertisements);
        return "user-active-advertisements";
    }

    @GetMapping("/user-inactive-advertisements")
    public String getUserInActiveAdvertisements(Model model) {
        List<AdvertisementDto> advertisements = advertisementService.getArchivedAdvertisementsAddedByUser();
        model.addAttribute("advertisements", advertisements);
        return "user-inactive-advertisements";
    }

    @GetMapping("/all/about-us-section")
    public String aboutUs() {
        return "about";
    }


    @GetMapping("/admin/main-menu")
    public String getActiveAdvertisementsCount(Model model) {

        List<AdvertisementDto> activeAdvertisements = advertisementService.getActiveAdvertisements();
        model.addAttribute("activeAdvertisementsCount", activeAdvertisements.size());


        List<AdvertisementUserDto> allAdvertisements = advertisementService.getAdvertisementsUser();
        model.addAttribute("allAdvertisementsCount", allAdvertisements.size());



        List<AdvertisementUserDto> archivedAdvertisements = advertisementService.getArchivedAdvertisementsUser();
        model.addAttribute("archivedAdvertisements", archivedAdvertisements.size());

        List<UserDto> allUsers = userService.getAllUsers();
        model.addAttribute("allUsersCount", allUsers.size());


        List<CategoryDto> categoriesCount = categoryService.getAllCategories();
        model.addAttribute("categoriesCount", categoriesCount.size());
        return "admin-dashboard";
    }


    @GetMapping("showAdvertisementForm")
    public String showCreateForm(Model model) {
        model.addAttribute("advertisement", new CreateAdvertisementRequest());
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("imageUpload", new ImageUploadRequest());

        return "createAdvertisement";
    }

    @PostMapping("createAdvertisementForm")
    public String createAdvertisement(@ModelAttribute("advertisement") CreateAdvertisementRequest advertisement,
                                      @ModelAttribute("imageUpload") ImageUploadRequest imageUploadRequest,
                                      BindingResult bindingResult,
                                      Model model) throws IOException {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.getAllCategories());
            return "createAdvertisement"; // return the same page if there are errors
        }

       AdvertisementDto createdAdvertisement= advertisementService.createAdvertisement(advertisement);
        imageService.uploadImage(createdAdvertisement.getId(),imageUploadRequest);
        return "redirect:/v1/advertisement/tl-getAdvertisementById/" + createdAdvertisement.getId();
    }



//
//    @GetMapping("/all/advertisements-by-category")
//    public String getAdvertisementsByCategory(@RequestParam Long categoryId, Model model) {
//        model.addAttribute("category", categoryId);
//        return "advertisements-by-category";
//    }

    @GetMapping("/all/advertisements-by-category/{categoryId}")
    public String showActiveAdvertisementsByCategory(@PathVariable Long categoryId, Model model) {
        List<AdvertisementUserDto> advertisements = advertisementService.getActiveAdvertisementsByCategoryIdV1(categoryId);
        CategoryDto category = categoryService.getCategoryById(categoryId);
        model.addAttribute("advertisements", advertisements);
        model.addAttribute("category", category);
        return "active-advertisements-by-category";
    }



    @GetMapping("/admin/getActiveAdvertisements")
    public String getActiveAdvertisementsAdmin(Model model) {
        List<AdvertisementUserDto> advertisements = advertisementService.getActiveAdvertisementsUser();
        model.addAttribute("advertisements", advertisements);
        return "admin-show-active-advertisements";
    }


    @GetMapping("admin/deactivateAdvertisement-tl/{id}")
    public String deactivateAdvertisementByIdAdmin(@PathVariable String id, Model model) {

        AdvertisementUserDto advertisement=advertisementService.archiveAdvertisement(id);

        model.addAttribute("advertisement", advertisement);
        return "redirect:/v1/advertisement/admin/getActiveAdvertisements";

    }

    @GetMapping("/admin/getInActiveAdvertisements")
    public String getActiveInAdvertisementsAdmin(Model model) {
        List<AdvertisementUserDto> advertisements = advertisementService.getArchivedAdvertisementsUser();
        model.addAttribute("advertisements", advertisements);
        return "admin-show-archived-advertisements";
    }


    @GetMapping("admin/delete_AdvertisementById/{id}")
    public String deleteAdvertisementById(@PathVariable String id, Model model) {

        AdvertisementDto advertisement=advertisementService.deleteAdvertisement(id);

        model.addAttribute("advertisement", advertisement);
        return "redirect:/v1/advertisement/admin/getInActiveAdvertisements";

    }

    @GetMapping("admin/activateAdvertisementId/{id}")
    public String activateAdvertisementById(@PathVariable String id, Model model) {

        AdvertisementDto advertisement=advertisementService.activateAdvertisement(id);

        model.addAttribute("advertisement", advertisement);
        return "redirect:/v1/advertisement/admin/getInActiveAdvertisements";

    }

}
