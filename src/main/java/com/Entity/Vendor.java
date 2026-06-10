package com.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vendors")
public class Vendor {

    @Id
    @GeneratedValue(strategy =
        GenerationType.IDENTITY)
    private Long id;

    private String vendorName;

    private String phone;

    private String email;

    private String gstNumber;

    private String address;

    private Boolean isActive = true;

    public Vendor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(
        String vendorName) {

        this.vendorName =
            vendorName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(
        String phone) {

        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(
        String email) {

        this.email = email;
    }

    public String getGstNumber() {
        return gstNumber;
    }

    public void setGstNumber(
        String gstNumber) {

        this.gstNumber =
            gstNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(
        String address) {

        this.address = address;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(
        Boolean isActive) {

        this.isActive =
            isActive;
    }
}