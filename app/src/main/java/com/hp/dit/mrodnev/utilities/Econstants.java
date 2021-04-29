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

    //Development  http://192.168.1.34:8080/eLahaulV23/api
    public static final String url = " http://192.168.1.34:8080/eLahaulV23/api";

    public static final String stateID = "9";
    public static final String blank = "";
    public static final String internetNotAvailable = "Internet not Available. Please Connect to Internet and try again.";

    public static final String methordLogin = "/login";
    public static final String methordGetCompleteApplication = "/getCompleteApplication";

    public static final String Date_Format = "dd-MM-yyyy";
    public static final String HTTP_FALIURE = "";
    public static final String HTTP_SUCCESS = "";


    public static ResponsePojoGet createOfflineObject(String url, String requestParams, String response, String Code) {
        ResponsePojoGet pojo = new ResponsePojoGet();
        pojo.setUrl(url);
        pojo.setRequestParams(requestParams);
        pojo.setResponse(response);
        pojo.setResponseCode(Code);

        return pojo;
    }





    public static boolean checkJsonObject(String data) throws JSONException {
        Object json = new JSONTokener(data).nextValue();
        if (json instanceof JSONObject)  return true;
        //you have an object
        else return false;
    }
}
