package com.DTO;

public class VendorRequestDTO {

    private String vendorName;

    private String phone;

    private String email;

    private String gstNumber;

    private String address;

    public VendorRequestDTO() {
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
}