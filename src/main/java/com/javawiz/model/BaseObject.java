package com.javawiz.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Getter
@Setter
public abstract class BaseObject {

    @Id
    protected String id;

    @CreatedBy
    protected String createUser;

    @CreatedDate
    protected Date createdDate;

    @LastModifiedBy
    protected String lastModifiedUser;

    @LastModifiedDate
    protected Date updateDate;
}