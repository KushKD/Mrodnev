package com.hp.dit.mrodnev.json;

import android.util.Log;


import com.hp.dit.mrodnev.Modal.SuccessResponse;
import com.hp.dit.mrodnev.Modal.User;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Kush.Dhawan
 * @project HPePass
 * @Time 03, 05 , 2020
 */
public class JsonParse {

    public static SuccessResponse getSuccessResponse(String data) throws JSONException {

        JSONObject responseObject = new JSONObject(data);
        SuccessResponse sr = new SuccessResponse();
        sr.setStatus(responseObject.getString("STATUS"));
        sr.setMessage(responseObject.getString("MSG"));
        sr.setResponse(responseObject.getString("RESPONSE"));

        return sr;
    }


}
