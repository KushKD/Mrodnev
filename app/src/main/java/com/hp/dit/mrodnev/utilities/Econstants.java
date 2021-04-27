package com.hp.dit.mrodnev.utilities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Base64;
import android.util.Log;


import com.hp.dit.mrodnev.Modal.ResponsePojoGet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * @author Kush.Dhawan
 * @project HPePass
 * @Time 01, 05 , 2020
 */
public class Econstants {

    //Development
   // public static final String url = "http://staging12.hp.gov.in/api";
    public static final String url = " http://transportid.hp.gov.in/api";
    public static final String stateID = "9";
    public static final String blank = "";
    public static final String internetNotAvailable = "Internet not Available. Please Connect to Internet and try again.";
    public static final String methordGetDistrict = "/districts/";
    public static final String methordGetBarriers = "/barriers/";
    public static final String methordGetOTP = "/getotp/";
    public static final String methordVerifyOtp = "/verifyotp/";
    public static final String methordGetVehicleType = "/vehicletypes/";
    public static final String methodVehicleUserType = "/vehicleusertypes/";
    public static final String methordUploadData = "/uploadData/";
    public static final String methordverifyVehicle = "/verifyVehicle/";
    public static final String methordSaveVehicleTransaction = "/saveVehicleData/";
    public static final String methordSearchId = "/searchId/";

    public static final String Date_Format = "dd-MM-yyyy";

    public static final String vahan = "http://staging12.hp.gov.in/api/";
    public static final String getCarDetailsVahan = "getVehicleDetails";
    public static final String getDL = "getDlDetails/";
    public static final String getEngineDetailsVahan = "getEngineDetails";
    public static final String securityKeyAES = "hPeDisTRict@310720";
    public static final String clientId = "HPEDISTRICT";





    public static ResponsePojoGet createOfflineObject(String url, String requestParams, String response, String Code, String functionName) {
        ResponsePojoGet pojo = new ResponsePojoGet();
        pojo.setUrl(url);
        pojo.setRequestParams(requestParams);
        pojo.setResponse(response);
        pojo.setFunctionName(functionName);
        pojo.setResponseCode(Code);

        return pojo;
    }



    public static String generateAuthenticationPasswrd(String username, String password)
            throws UnsupportedEncodingException {
        StringBuilder SB = new StringBuilder();
        SB.append(username + ":" + password);
        System.out.println(Base64.encodeToString(SB.toString().getBytes(),Base64.DEFAULT));

        return Base64.encodeToString(SB.toString().getBytes(),Base64.DEFAULT);
      //  return Base64.getEncoder().encodeToString(SB.toString().getBytes("utf-8"));
    }

    public static boolean checkJsonObject(String data) throws JSONException {
        Object json = new JSONTokener(data).nextValue();
        if (json instanceof JSONObject)  return true;
        //you have an object
        else return false;
    }
}
