package com.beesdev.dto.advertisement_dtos.category_dto.category_dto_converters;

import com.beesdev.dto.advertisement_dtos.category_dto.CategoryDto;
import com.beesdev.model.advertisement_model.Category;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryDtoConverter {

    public CategoryDto convert(Category from) {
        return new CategoryDto(
                from.getId(),
                from.getCategoryName());

    }
    public List<CategoryDto> convert(List<Category> from){
        return from.stream().map(this::convert).collect(Collectors.toList());
    }


}
