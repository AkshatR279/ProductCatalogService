package com.pratice.productcatalogservice.model.entity;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.util.Date;

@MappedSuperclass
public abstract class BaseModel {
    @Id
    private Long id;

    private String name;
    private Date createdOn;
    private Date updatedOn;
}
