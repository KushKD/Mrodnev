package com.hp.dit.mrodnev.interfaces;



import com.hp.dit.mrodnev.Modal.ResponsePojoGet;
import com.hp.dit.mrodnev.enums.TaskType;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * @author Kush.Dhawan
 * @project HPePass
 * @Time 03, 05 , 2020
 */
public interface AsyncTaskListenerObject {
    void onTaskCompleted(ResponsePojoGet result, TaskType taskType) throws JSONException, NoSuchPaddingException, UnsupportedEncodingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, InvalidKeyException;
}
