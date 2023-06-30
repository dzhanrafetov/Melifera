package com.beesdev.controller.advertisement_controller;

import com.beesdev.dto.advertisement_dtos.category_dto.CategoryDto;
import com.beesdev.dto.advertisement_dtos.category_dto.category_dto_requests.CreateCategoryRequest;
import com.beesdev.dto.advertisement_dtos.category_dto.category_dto_requests.UpdateCategoryRequest;
import com.beesdev.service.advertisement_service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/category")

public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("admin/createCategory")
    public ResponseEntity<CategoryDto> createCategory
            (@Valid @RequestBody CreateCategoryRequest categoryRequest) {
        return ResponseEntity.ok
                (categoryService.
                        create(categoryRequest));

    }


    @GetMapping("admin/getCategoryByName/{name}")
    public List<CategoryDto> getCategoryById(@PathVariable String name){
        return
                (categoryService.
                        findCategoryByName(name));

    }
    @GetMapping("admin/getCategoryById/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long id){
        return ResponseEntity.ok
                (categoryService.
                        getCategoryById(id));

    }

    @GetMapping("categories/")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());

    }

//    @GetMapping("categories/")
//    public String getAllCategories(Model model) {
//        List<CategoryDto> categories = categoryService.getAllCategories();
//        model.addAttribute("categories", categories);
//        return "index";
//    }






    @PutMapping("admin/updateCategoryById/{id}")
    public ResponseEntity<CategoryDto>
    updateCategory(@PathVariable Long id,
                   @Valid @RequestBody UpdateCategoryRequest updateCategoryRequest){
        return ResponseEntity.ok
                (categoryService.
                        updateCategory(id,updateCategoryRequest));

    }

    @DeleteMapping("admin/deleteCategoryById/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok().build();

    }


}
