package com.beesdev.controller.thymeleafController.advertisement_controller_thymeleaf;

import com.beesdev.dto.advertisement_dtos.advertisement_dto.AdvertisementUserDto;
import com.beesdev.dto.advertisement_dtos.category_dto.CategoryDto;
import com.beesdev.dto.advertisement_dtos.category_dto.category_dto_requests.CreateCategoryRequest;
import com.beesdev.dto.user_dtos.user_dto.UserDto;
import com.beesdev.dto.user_dtos.user_dto.user_dto_requests.CreateUserRequest;
import com.beesdev.service.advertisement_service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/v1/category")
public class CategoryControllerTL {


        private final CategoryService categoryService;


    public CategoryControllerTL(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("categories-section-tl/")
    public String  getAllCategories(Model model) {
        List<CategoryDto> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "categories";
//        return ResponseEntity.ok(categoryService.getAllCategories());

    }



    @GetMapping("showCategoryForm")
    public String showCreateForm(Model model) {
        model.addAttribute("category", new CreateCategoryRequest());


        return "admin-create-category";
    }

    @PostMapping("createCategoryForm")
    public String createAdvertisement(@ModelAttribute("category") CreateCategoryRequest categoryRequest, RedirectAttributes attributes) {


        categoryService.create(categoryRequest);

        return "redirect:/v1/category/admin/show-categories/";
    }


    @GetMapping("admin/show-categories/")
    public String  getAllCategoriesAdmin(Model model) {
        List<CategoryDto> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "admin-show-categories";
//        return ResponseEntity.ok(categoryService.getAllCategories());

    }




    @GetMapping("admin/deleteCategoryById-tl/{id}")
    public String deleteCategoryById(@PathVariable Long id, Model model) {
        CategoryDto category = categoryService.deleteCategory(id);
        model.addAttribute("category", category);
        return "redirect:/v1/category/admin/show-categories/";
    }




}



