package com.example.splitwise.entity;


import lombok.Data;

import java.util.Date;

@Data
public class Base {

    private Date createdAt;
    private Date modifiedAt;
    private String createdBy;
    private String updatedBy;
}
