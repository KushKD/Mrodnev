package com.hp.dit.mrodnev.Modal;

import java.io.Serializable;

public class VehicleDetailsObject implements Serializable {


    private String rcRegistrationNo;
    private String rcChassisNo;
    private String rcEngineNumber;
    private String rcFitUpto;
    private String rcRegisteredAt;
    private String rcStatus;
    private String rcStatusAsOn;
    private String rcOwnerName;

    public String getRcOwnerName() {
        return rcOwnerName;
    }

    public void setRcOwnerName(String rcOwnerName) {
        this.rcOwnerName = rcOwnerName;
    }

    public String getRcRegistrationNo() {
        return rcRegistrationNo;
    }

    public void setRcRegistrationNo(String rcRegistrationNo) {
        this.rcRegistrationNo = rcRegistrationNo;
    }

    public String getRcChassisNo() {
        return rcChassisNo;
    }

    public void setRcChassisNo(String rcChassisNo) {
        this.rcChassisNo = rcChassisNo;
    }

    public String getRcEngineNumber() {
        return rcEngineNumber;
    }

    public void setRcEngineNumber(String rcEngineNumber) {
        this.rcEngineNumber = rcEngineNumber;
    }

    public String getRcFitUpto() {
        return rcFitUpto;
    }

    public void setRcFitUpto(String rcFitUpto) {
        this.rcFitUpto = rcFitUpto;
    }

    public String getRcRegisteredAt() {
        return rcRegisteredAt;
    }

    public void setRcRegisteredAt(String rcRegisteredAt) {
        this.rcRegisteredAt = rcRegisteredAt;
    }

    public String getRcStatus() {
        return rcStatus;
    }

    public void setRcStatus(String rcStatus) {
        this.rcStatus = rcStatus;
    }

    public String getRcStatusAsOn() {
        return rcStatusAsOn;
    }

    public void setRcStatusAsOn(String rcStatusAsOn) {
        this.rcStatusAsOn = rcStatusAsOn;
    }

    @Override
    public String toString() {
        return "VehicleDetailsObject{" +
                "rcRegistrationNo='" + rcRegistrationNo + '\'' +
                ", rcChassisNo='" + rcChassisNo + '\'' +
                ", rcEngineNumber='" + rcEngineNumber + '\'' +
                ", rcFitUpto='" + rcFitUpto + '\'' +
                ", rcRegisteredAt='" + rcRegisteredAt + '\'' +
                ", rcStatus='" + rcStatus + '\'' +
                ", rcStatusAsOn='" + rcStatusAsOn + '\'' +
                ", rcOwnerName='" + rcOwnerName + '\'' +
                '}';
    }
}
