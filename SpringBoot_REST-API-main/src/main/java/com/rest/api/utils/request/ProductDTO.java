package com.rest.api.utils.request;

import com.rest.api.entity.Category;
import com.rest.api.entity.Promoted;
import com.rest.api.entity.Status;

import lombok.Data;


import java.sql.Timestamp;
import java.util.Date;
@Data

public class ProductDTO {

    private String title;

    private String title_ar;

    private String description;

    private String description_ar;

    private String region_id;

    private int price;

    private long category_id;

    private int user_id;

    private String email;

    private String phone;

    private Promoted promoted;

    private int paid_amount;

    private Date expiry_date;

    private Status status;

    private String slug;

    private int views;

    private String address;

    private String lat;

    private String lng;

    private String reference_id;

    private Timestamp created_at;

    private Timestamp updated_at;
    private Category category;

    public ProductDTO(Long id, String title, String title_ar, String description, String description_ar, String region_id, long category_id, int user_id, String email, String phone, Promoted promoted, int price, int paid_amount, Date expiry_date, Status status, String slug, int views, String address, String lat, String lng, String reference_id, Timestamp created_at, Timestamp updated_at) {
    }
}
 // class product  fiel declaration