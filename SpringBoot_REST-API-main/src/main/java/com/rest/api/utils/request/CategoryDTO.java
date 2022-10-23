package com.rest.api.utils.request;


import lombok.Data;

@Data
public class CategoryDTO {




        private int id;

        private String Name;

    public CategoryDTO(Long id, String name) {
    }
}

