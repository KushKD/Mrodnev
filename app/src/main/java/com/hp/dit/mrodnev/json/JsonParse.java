package com.hp.dit.mrodnev.json;

import android.util.Log;


import com.hp.dit.mrodnev.Modal.IDCardOwnerServerVerify;
import com.hp.dit.mrodnev.Modal.IDCardServerObject;
import com.hp.dit.mrodnev.Modal.IdCardScanPojo;
import com.hp.dit.mrodnev.Modal.SaarthiObject;
import com.hp.dit.mrodnev.Modal.SuccessResponse;
import com.hp.dit.mrodnev.Modal.User;
import com.hp.dit.mrodnev.Modal.VehicleDetailsObject;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Kush.Dhawan
 * @project HPePass
 * @Time 03, 05 , 2020
 */
public class JsonParse {

    public static IdCardScanPojo getObjectSave(String qrcodeData) throws JSONException {
        JSONObject responseObject = new JSONObject(qrcodeData);
        IdCardScanPojo data = new IdCardScanPojo();
        data.setVehicle_number(responseObject.getString("vehicle_number"));
        data.setId_card_number(responseObject.getString("id_card_number"));
        data.setMobile_number(responseObject.getLong("mobile_number"));


        return data;
    }

    public static SuccessResponse getSuccessResponse(String data) throws JSONException {

        JSONObject responseObject = new JSONObject(data);
        SuccessResponse sr = new SuccessResponse();
        sr.setStatus(responseObject.getString("STATUS"));
        sr.setMessage(responseObject.getString("MSG"));
        sr.setResponse(responseObject.getString("RESPONSE"));

        return sr;
    }

    public static User getUSerDetilas(String data) throws JSONException {

        JSONObject responseObject = new JSONObject(data);
        User sr = new User();
        sr.setUserName(responseObject.getString("user_name"));
        sr.setUserId(responseObject.getInt("user_id"));
        sr.setMobileNumber(responseObject.getLong("mobile_number"));
        Log.e("Data", sr.toString());
        return sr;
    }


    public static IDCardServerObject getIdCardUserServerDetails(String data) throws JSONException {

        JSONObject responseObject = new JSONObject(data);
        IDCardServerObject sr = new IDCardServerObject();
        sr.setImageUrl(responseObject.getString("fileDownloadUri"));
        sr.setGenerateIDCardUrl_(responseObject.getString("generateIDCardUrl_"));

        JSONObject responseObject2 = responseObject.getJSONObject("ownerData");

        sr.setDriverName(responseObject2.getString("vehicleOwnerName"));
        sr.setIdCardNumber(responseObject2.getString("idCardNumber"));
        sr.setPhoneNumber(responseObject2.getString("vehicleOwnerMobileNumber"));

        return sr;
    }


    public static VehicleDetailsObject getVehicleDataVahan (String data) throws JSONException {

        JSONObject responseObject = new JSONObject(data);

        VehicleDetailsObject obj = new VehicleDetailsObject();
        obj.setRcChassisNo(responseObject.getString("rcChassisNo"));
        obj.setRcEngineNumber(responseObject.getString("rcEngineNumber"));
        obj.setRcFitUpto(responseObject.getString("rcFitUpto"));
        obj.setRcRegisteredAt(responseObject.getString("rcRegisteredAt"));
        obj.setRcStatus(responseObject.getString("rcStatus"));
        obj.setRcRegistrationNo(responseObject.getString("rcRegistrationNo"));
        obj.setRcStatusAsOn(responseObject.getString("rcStatusAsOn"));
        obj.setRcOwnerName(responseObject.getString("rcOwnerName"));
        System.out.println(data.toString());

        return obj;
    }


    public static IDCardOwnerServerVerify getIdCardUserServerDetailsComplete(String data) throws JSONException {

        JSONObject responseObject = new JSONObject(data);
        IDCardOwnerServerVerify sr = new IDCardOwnerServerVerify();
        sr.setImageurl(responseObject.optString("fileDownloadUri"));
        sr.setIdcardUrl(responseObject.optString("generateIDCardUrl_"));
        JSONObject responseObject2 = responseObject.getJSONObject("ownerData");
        JSONObject responseObject3 = responseObject2.getJSONObject("districtMaster");
        Log.e("Object3", responseObject3.toString());
        JSONObject responseObject4 = responseObject2.getJSONObject("barriermaster");
        Log.e("Object4", responseObject4.toString());
        JSONObject responseObject5 = responseObject2.getJSONObject("vehicleType");
        JSONObject responseObject6 = responseObject2.getJSONObject("vehicleUser");
        sr.setVehicleOwnerName(responseObject2.optString("vehicleOwnerName"));
        sr.setIdCardNumber(responseObject2.optString("idCardNumber"));
        sr.setVehicleOwnerMobileNumber(responseObject2.getLong("vehicleOwnerMobileNumber"));
        sr.setIsValidFrom(responseObject2.optString("isValidFrom"));
        sr.setIsValidUpto(responseObject2.optString("isValidUpto"));
        sr.setVehicleOwnerAadhaarNumber(responseObject2.optString("vehicleOwnerAadhaarNumber"));
        sr.setVehicleOwnerChassisNumber(responseObject2.optString("vehicleOwnerChassisNumber"));
        sr.setVehicleOwnerDrivingLicence(responseObject2.optString("vehicleOwnerDrivingLicence"));
        sr.setVehicleOwnerEngineNumber(responseObject2.optString("vehicleOwnerEngineNumber"));
        sr.setVehicleOwnerVehicleNumber(responseObject2.optString("vehicleOwnerVehicleNumber"));
        sr.setDataEnteredBy(responseObject2.optInt("dataEnteredBy"));
        sr.setVehicleBarrierId(responseObject4.optInt("barrierId"));
        sr.setVehicleBarrierName(responseObject4.optString("barrierName"));
        sr.setVehicleDistrictId(responseObject3.optInt("districtId"));
        sr.setVehicleDistrictName(responseObject3.optString("districtName"));
        sr.setVehicleOwnerId(responseObject2.optInt("vehicleOwnerId"));
        sr.setVehicleOwnerType(responseObject6.optString("vehicleOwnerTypeName"));
        sr.setVehicleTypeName(responseObject5.optString("vehicleName"));

        return sr;
    }


    public static SaarthiObject parseJson(String data) throws JSONException {
        SaarthiObject object = null;
        if (data != null) {
            object = new SaarthiObject();
            JSONObject o = new JSONObject(data);
            System.out.println(o.toString());
            object.setDlLicName(o.optString("dlLicName"));
            object.setDlLicNum(o.optString("dlLicNum"));
            object.setDlLicStatus(o.optString("dlLicStatus"));
            object.setDlNonTransValidTill(o.optString("dlNonTransValidTill"));
            object.setErrorCode(o.optInt("errorCode"));
            object.setErrorMessage(o.optString("errorMessage"));
            object.setIssuing_authority(o.optString("issuing_authority"));
            object.setDlTransValidTill(o.optString("dlTransValidTill"));
        }
        return object;
    }


}
