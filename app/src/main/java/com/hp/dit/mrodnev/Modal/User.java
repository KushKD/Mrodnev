package com.hp.dit.mrodnev.Modal;

import java.io.Serializable;

public class User implements Serializable {

    private int userId;
    private String district;
    private String block;
    private String state;
    private String tehsil;
    private String userName;
    private Long mobileNumber;
    private String firstName;
    private String lastName;
    private String gramPanchayat;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTehsil() {
        return tehsil;
    }

    public void setTehsil(String tehsil) {
        this.tehsil = tehsil;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
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

    public String getGramPanchayat() {
        return gramPanchayat;
    }

    public void setGramPanchayat(String gramPanchayat) {
        this.gramPanchayat = gramPanchayat;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", district='" + district + '\'' +
                ", block='" + block + '\'' +
                ", state='" + state + '\'' +
                ", tehsil='" + tehsil + '\'' +
                ", userName='" + userName + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gramPanchayat='" + gramPanchayat + '\'' +
                '}';
    }
}
