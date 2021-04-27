package com.hp.dit.mrodnev.interfaces;


import com.hp.dit.mrodnev.Modal.IDCardPojo;
import com.hp.dit.mrodnev.enums.TaskType;

import org.json.JSONException;

public interface AsyncTaskListenerFile {

    void onTaskCompleted(IDCardPojo object, TaskType taskType) throws JSONException;
}
