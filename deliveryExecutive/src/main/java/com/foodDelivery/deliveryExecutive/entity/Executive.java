package com.foodDelivery.deliveryExecutive.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Executive {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long executiveId;
    private String executiveName;
    private String phone;
    private Boolean status;
}
