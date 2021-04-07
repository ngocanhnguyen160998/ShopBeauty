package com.shop.model.request;

import java.time.LocalDate;

public class CheckOutRequest {
    private String firstName;
    private String lastName;
    private String CompanyName;
    private String email;
    private String phone;
    private String address;
    private String province;
    private String district;
    private String apartment;
    private String commune;
    private String postCode;
    private String specialNotes;
    private LocalDate modifiedDate;
    private Integer tongTien;
    private String paymentMethod;
    private Integer id_user;
    private String listProduct;

    public CheckOutRequest(String firstName, String lastName, String companyName, String email, String phone, String address, String province, String district, String apartment, String commune, String postCode, String specialNotes, LocalDate modifiedDate, Integer tongTien, String paymentMethod, Integer id_user, String listProduct) {
        this.firstName = firstName;
        this.lastName = lastName;
        CompanyName = companyName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.province = province;
        this.district = district;
        this.apartment = apartment;
        this.commune = commune;
        this.postCode = postCode;
        this.specialNotes = specialNotes;
        this.modifiedDate = modifiedDate;
        this.tongTien = tongTien;
        this.paymentMethod = paymentMethod;
        this.id_user = id_user;
        this.listProduct = listProduct;
    }

    public CheckOutRequest() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getSpecialNotes() {
        return specialNotes;
    }

    public void setSpecialNotes(String specialNotes) {
        this.specialNotes = specialNotes;
    }

    public LocalDate getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDate modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Integer getTongTien() {
        return tongTien;
    }

    public void setTongTien(Integer tongTien) {
        this.tongTien = tongTien;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public String getListProduct() {
        return listProduct;
    }

    public void setListProduct(String listProduct) {
        this.listProduct = listProduct;
    }

    @Override
    public String toString() {
        return "CheckOutRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", CompanyName='" + CompanyName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", province='" + province + '\'' +
                ", district='" + district + '\'' +
                ", apartment='" + apartment + '\'' +
                ", commune='" + commune + '\'' +
                ", postCode='" + postCode + '\'' +
                ", specialNotes='" + specialNotes + '\'' +
                ", modifiedDate=" + modifiedDate +
                ", tongTien=" + tongTien +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", id_user=" + id_user +
                ", listProduct='" + listProduct + '\'' +
                '}';
    }
}
