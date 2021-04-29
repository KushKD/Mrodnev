package com.hp.dit.mrodnev.json;

import android.util.Log;


import com.hp.dit.mrodnev.Modal.User;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Kush.Dhawan
 * @project HPePass
 * @Time 03, 05 , 2020
 */
public class JsonParse {

    public static User getUSerDetilas(String data) throws JSONException {

        JSONObject responseObject = new JSONObject(data);
        User sr = new User();
        sr.setUserName(responseObject.getString("user_name"));
        sr.setUserId(responseObject.getInt("user_id"));
        sr.setMobileNumber(responseObject.getLong("mobile_number"));
        Log.e("Data", sr.toString());
        return sr;
    }


}
