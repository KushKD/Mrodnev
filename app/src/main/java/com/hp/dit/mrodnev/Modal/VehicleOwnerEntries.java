package com.hp.dit.mrodnev.Modal;


import com.hp.dit.mrodnev.utilities.CommonUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.Date;


public class VehicleOwnerEntries implements Serializable {

    private Long vehicleOwnerId;
    private String idCardNumber;
    private int vehicleDistrictId;
    private int vehicleBarrierId;
    private int vehicleTypeId;
    private int vehicleOwnerTypeId;
    private String vehicleOwnerName;
    private String vehicleOwnerImageName;
    private Long vehicleOwnerMobileNumber;
    private String isValidFrom;
    private String isValidUpto;
    private String vehicleOwnerAadhaarNumber;
    private String vehicleOwnerVehicleNumber;
    private String vehicleOwnerChassisNumber;
    private String vehicleOwnerEngineNumber;
    private String vehicleOwnerDrivingLicence;
    private String mobileInformation;
    private String otherInformation;
    private int dataEnteredBy;
    private boolean active;
    private String vehicleOwnerAddress;
    private String vehicleDriverAddress;
    private String card_created_on;

    public String getCard_created_on() {
        return card_created_on;
    }

    public void setCard_created_on(String card_created_on) {
        this.card_created_on = card_created_on;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Long getVehicleOwnerId() {
        return vehicleOwnerId;
    }

    public void setVehicleOwnerId(Long vehicleOwnerId) {
        this.vehicleOwnerId = vehicleOwnerId;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public int getVehicleDistrictId() {
        return vehicleDistrictId;
    }

    public void setVehicleDistrictId(int vehicleDistrictId) {
        this.vehicleDistrictId = vehicleDistrictId;
    }

    public int getVehicleBarrierId() {
        return vehicleBarrierId;
    }

    public void setVehicleBarrierId(int vehicleBarrierId) {
        this.vehicleBarrierId = vehicleBarrierId;
    }

    public int getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(int vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    public int getVehicleOwnerTypeId() {
        return vehicleOwnerTypeId;
    }

    public void setVehicleOwnerTypeId(int vehicleOwnerTypeId) {
        this.vehicleOwnerTypeId = vehicleOwnerTypeId;
    }

    public String getVehicleOwnerName() {
        return vehicleOwnerName;
    }

    public void setVehicleOwnerName(String vehicleOwnerName) {
        this.vehicleOwnerName = vehicleOwnerName;
    }

    public String getVehicleOwnerImageName() {
        return vehicleOwnerImageName;
    }

    public void setVehicleOwnerImageName(String vehicleOwnerImageName) {
        this.vehicleOwnerImageName = vehicleOwnerImageName;
    }

    public Long getVehicleOwnerMobileNumber() {
        return vehicleOwnerMobileNumber;
    }

    public void setVehicleOwnerMobileNumber(Long vehicleOwnerMobileNumber) {
        this.vehicleOwnerMobileNumber = vehicleOwnerMobileNumber;
    }

    public String getIsValidFrom() {
        return isValidFrom;
    }

    public void setIsValidFrom(String isValidFrom) {
        this.isValidFrom = isValidFrom;
    }

    public String getIsValidUpto() {
        return isValidUpto;
    }

    public void setIsValidUpto(String isValidUpto) {
        this.isValidUpto = isValidUpto;
    }

    public String getVehicleOwnerAadhaarNumber() {
        return vehicleOwnerAadhaarNumber;
    }

    public void setVehicleOwnerAadhaarNumber(String vehicleOwnerAadhaarNumber) {
        this.vehicleOwnerAadhaarNumber = vehicleOwnerAadhaarNumber;
    }

    public String getVehicleOwnerVehicleNumber() {
        return vehicleOwnerVehicleNumber;
    }

    public void setVehicleOwnerVehicleNumber(String vehicleOwnerVehicleNumber) {
        this.vehicleOwnerVehicleNumber = vehicleOwnerVehicleNumber;
    }

    public String getVehicleOwnerChassisNumber() {
        return vehicleOwnerChassisNumber;
    }

    public void setVehicleOwnerChassisNumber(String vehicleOwnerChassisNumber) {
        this.vehicleOwnerChassisNumber = vehicleOwnerChassisNumber;
    }

    public String getVehicleOwnerEngineNumber() {
        return vehicleOwnerEngineNumber;
    }

    public void setVehicleOwnerEngineNumber(String vehicleOwnerEngineNumber) {
        this.vehicleOwnerEngineNumber = vehicleOwnerEngineNumber;
    }

    public String getVehicleOwnerDrivingLicence() {
        return vehicleOwnerDrivingLicence;
    }

    public void setVehicleOwnerDrivingLicence(String vehicleOwnerDrivingLicence) {
        this.vehicleOwnerDrivingLicence = vehicleOwnerDrivingLicence;
    }

    public String getMobileInformation() {
        return mobileInformation;
    }

    public void setMobileInformation(String mobileInformation) {
        this.mobileInformation = mobileInformation;
    }

    public String getOtherInformation() {
        return otherInformation;
    }

    public void setOtherInformation(String otherInformation) {
        this.otherInformation = otherInformation;
    }

    public int getDataEnteredBy() {
        return dataEnteredBy;
    }

    public void setDataEnteredBy(int dataEnteredBy) {
        this.dataEnteredBy = dataEnteredBy;
    }

    public String getVehicleOwnerAddress() {
        return vehicleOwnerAddress;
    }

    public void setVehicleOwnerAddress(String vehicleOwnerAddress) {
        this.vehicleOwnerAddress = vehicleOwnerAddress;
    }

    public String getVehicleDriverAddress() {
        return vehicleDriverAddress;
    }

    public void setVehicleDriverAddress(String vehicleDriverAddress) {
        this.vehicleDriverAddress = vehicleDriverAddress;
    }

    public String getCreatedDate() {
        return card_created_on;
    }

    public void setCreatedDate(String createdDate) {
        this.card_created_on = createdDate;
    }

    public String toJSON() {

        JSONObject jsonObject = new JSONObject();
        JSONObject  district = new JSONObject();
        JSONObject barrier = new JSONObject();
        JSONObject vehicleType = new JSONObject();
        JSONObject usertype = new JSONObject();
        try {
            jsonObject.put("vehicleOwnerId", getVehicleOwnerId());
            jsonObject.put("idCardNumber", getIdCardNumber());
            jsonObject.put("districtMaster", district.put("districtId",getVehicleDistrictId()));
            jsonObject.put("barriermaster", barrier.put("barrierId",getVehicleBarrierId()));
            jsonObject.put("vehicleType", vehicleType.put("vehicleId",getVehicleTypeId()));
            jsonObject.put("vehicleUser", usertype.put("vehicleOwnerTypeId",getVehicleOwnerTypeId()));
            jsonObject.put("vehicleOwnerName", getVehicleOwnerName());
            jsonObject.put("vehicleOwnerImageName", getVehicleOwnerImageName());
            jsonObject.put("vehicleOwnerMobileNumber", getVehicleOwnerMobileNumber());
            jsonObject.put("isValidFrom", getIsValidFrom());
            jsonObject.put("isValidUpto", "31-12-2020");
            jsonObject.put("vehicleOwnerAadhaarNumber", getVehicleOwnerAadhaarNumber());
            jsonObject.put("vehicleOwnerVehicleNumber", getVehicleOwnerVehicleNumber());
            jsonObject.put("vehicleOwnerChassisNumber", getVehicleOwnerChassisNumber());
            jsonObject.put("vehicleOwnerEngineNumber", getVehicleOwnerEngineNumber());
            jsonObject.put("vehicleOwnerDrivingLicence", getVehicleOwnerDrivingLicence());
            jsonObject.put("mobileInformation", getMobileInformation());
            jsonObject.put("otherInformation", getOtherInformation());
            jsonObject.put("dataEnteredBy", getDataEnteredBy());
            jsonObject.put("vehicleOwnerAddress", getVehicleOwnerAddress());
            jsonObject.put("vehicleDriverAddress", getVehicleDriverAddress());
            jsonObject.put("active",true);
            jsonObject.put("cardCreation", CommonUtils.getCurrentDate());

            return jsonObject.toString();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "";
        }

    }


}
