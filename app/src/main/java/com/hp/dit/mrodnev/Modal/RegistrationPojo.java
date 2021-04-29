package com.hp.dit.mrodnev.Modal;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class RegistrationPojo implements Serializable {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "RegistrationPojo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String toJSON() {
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("username", getUsername());
            jsonObject.put("password", getPassword());


            return jsonObject.toString();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "";
        }
    }
}
