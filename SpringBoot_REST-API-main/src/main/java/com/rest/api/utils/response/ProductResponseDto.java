package com.rest.api.utils.response;

import com.rest.api.entity.Promoted;
import com.rest.api.entity.Status;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;
@Data
public class ProductResponseDto {

       private String title;

        private String title_ar;

        private String description;

        private String description_ar;

        private String region_id;

        private int price;

        private int category_id;

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

    }
