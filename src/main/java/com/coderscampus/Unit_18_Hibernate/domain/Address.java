package com.coderscampus.Unit_18_Hibernate.domain;

import jakarta.persistence.*;

@Entity
public class Address {
    private Long userId; // Not sure about this one
    private User user;
    private String getAddressLine1;
    private String addressLine2;
    private String city;
    private String region;
    private String country;
    private String zipCode;

    @Id
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(length = 200)
    public String getGetAddressLine1() {
        return getAddressLine1;
    }

    public void setGetAddressLine1(String getAddressLine1) {
        this.getAddressLine1 = getAddressLine1;
    }

    @Column(length = 200)
    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    @Column(length = 100)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(length = 100)
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Column(length = 100)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(length = 15)
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}