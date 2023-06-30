package com.aws_amazon_file_uploading.dto;

import com.aws_amazon_file_uploading.model.V1_Image;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class V1_ImageDtoConverter {

    public List<V1_ImageDto> convert(List<V1_Image> from){
        return from.stream().map(this::convert).collect(Collectors.toList());
    }

        public V1_ImageDto convert(V1_Image from) {
        return new V1_ImageDto(from.getId(),
                 from.getName(),
                from.getUrl());
    }

}







