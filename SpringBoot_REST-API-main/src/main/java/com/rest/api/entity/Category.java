package com.rest.api.entity;

import com.rest.api.utils.request.CategoryDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_id ")
    private Long id;
    @Column(name="Name", nullable = false)
    private String Name;

// save the data level all the data
    public CategoryDTO toDTO() {
        return new CategoryDTO(getId(),getName());
    }
}
