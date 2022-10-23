package com.rest.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rest.api.utils.request.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;




@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name = "product", uniqueConstraints = @UniqueConstraint(columnNames = "title"))
public class Product {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;
        @Column(name = "title")
        private String title;
        @Column(name = "title_ar")
        private String title_ar;
        @Column(name = "description")
        private String description;
        @Column(name = "description_ar")
        private String description_ar;
        @Column(name = "region_id")
        private String region_id;
        @Column(name = "price")
        private int price;
        @Column(name = "category_id")
        private Long category_id;
        @Column(name = "user_id")
        private int user_id;
        @Column(name = "email")
        private String email;
        @Column(name = "phone")
        private String phone;
        @Column(name = "promoted")
        private Promoted promoted;
        @Column(name = "paid_amount")
        private int paid_amount;
        @Column(name = "expiry_date")
        private Date expiry_date;
        @Column(name = "status")
        private Status status;
        @Column(name = "slug")
        private String slug;
        @Column(name = "views")
        private int views;
        @Column(name = "address")
        private String address;
        @Column(name = "lat")
        private String lat;
        @Column(name = "lng")
        private String lng;
        @Column(name = "reference_id")
        private String reference_id;
        @Column(name = "created_at")
        private Timestamp created_at;
        @Column(name = "updated_at")
        private Timestamp updated_at;


        public ProductDTO toDTO() {

                        return new ProductDTO(getId(),getTitle(),getTitle_ar()
                                ,getDescription(),getDescription_ar() ,getRegion_id(),getCategory_id()
                                ,getUser_id() ,getEmail(),getPhone(),getPromoted(),getPrice()
                                , getPaid_amount(),getExpiry_date(),getStatus()
                                ,getSlug(),getViews(),getAddress(),getLat(),getLng()
                                ,getReference_id(),getCreated_at(),getUpdated_at());
        }
}
