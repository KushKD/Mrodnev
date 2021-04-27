package com.hp.dit.mrodnev.interfaces;



import com.hp.dit.mrodnev.Modal.ResponsePojoGet;
import com.hp.dit.mrodnev.enums.TaskType;

import org.json.JSONException;

/**
 * @author Kush.Dhawan
 * @project HPePass
 * @Time 03, 05 , 2020
 */
public interface AsyncTaskListenerObject {
    void onTaskCompleted(ResponsePojoGet result, TaskType taskType) throws JSONException;
}
