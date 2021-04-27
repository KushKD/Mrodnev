package com.hp.dit.mrodnev.interfaces;



import com.hp.dit.mrodnev.Modal.VahanObject;
import com.hp.dit.mrodnev.enums.TaskType;

import org.json.JSONException;
import org.xml.sax.SAXException;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

/**
 * @author Kush.Dhawan
 * @project HPePass
 * @Time 03, 05 , 2020
 */
public interface AsyncTaskListenerObjectVahan {
    void onTaskCompleted(VahanObject result, TaskType taskType) throws JSONException, IOException, SAXException, ParserConfigurationException;
}
