package com.hp.dit.mrodnev.generic;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.hp.dit.mrodnev.Modal.ResponsePojoGet;
import com.hp.dit.mrodnev.Modal.UploadObject;
import com.hp.dit.mrodnev.enums.TaskType;
import com.hp.dit.mrodnev.interfaces.AsyncTaskListenerObjectGet;
import com.hp.dit.mrodnev.network.HttpManager;

import org.json.JSONException;


public class Generic_Async_Get extends AsyncTask<UploadObject,Void , ResponsePojoGet> {


    String outputStr;
    ProgressDialog dialog;
    Context context;
    AsyncTaskListenerObjectGet taskListener;
    TaskType taskType;

    public Generic_Async_Get(Context context, AsyncTaskListenerObjectGet taskListener, TaskType taskType) {
        this.context = context;
        this.taskListener = taskListener;
        this.taskType = taskType;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog = ProgressDialog.show(context, "Loading", "Connecting to Server .. Please Wait", true);
        dialog.setCancelable(false);
    }

    @Override
    protected ResponsePojoGet doInBackground(UploadObject... uploadObjects) {
        ResponsePojoGet Data_From_Server = null;
        HttpManager http_manager = null;
        try {
            http_manager = new HttpManager();
            if(uploadObjects[0].getTasktype().toString().equalsIgnoreCase(TaskType.GET_DISTRICT.toString())){
                Log.e("We Here", uploadObjects[0].getMethordName());
                Data_From_Server = http_manager.GetData(uploadObjects[0]);
                return Data_From_Server;
            }
            else if(uploadObjects[0].getTasktype().toString().equalsIgnoreCase(TaskType.GET_BARRIERS.toString())){
                Log.e("We Here", uploadObjects[0].getMethordName());
                Data_From_Server = http_manager.GetData(uploadObjects[0]);
                return Data_From_Server;
            }
            else if(uploadObjects[0].getTasktype().toString().equalsIgnoreCase(TaskType.GET_VEHICLE_TYPE.toString())){
                Log.e("We Here", uploadObjects[0].getMethordName());
                Data_From_Server = http_manager.GetData(uploadObjects[0]);
                return Data_From_Server;
            }
            else if(uploadObjects[0].getTasktype().toString().equalsIgnoreCase(TaskType.GET_VEHICLE_TYPE_USER.toString())){
                Log.e("We Here", uploadObjects[0].getMethordName());
                Data_From_Server = http_manager.GetData(uploadObjects[0]);
                return Data_From_Server;
            }
            else if(uploadObjects[0].getTasktype().toString().equalsIgnoreCase(TaskType.GET_OTP.toString())){
                Log.e("We Here", uploadObjects[0].getMethordName());
                Data_From_Server = http_manager.GetData(uploadObjects[0]);
                return Data_From_Server;
            }
            else if(uploadObjects[0].getTasktype().toString().equalsIgnoreCase(TaskType.VEREIFY_OTP.toString())){
                Log.e("We Here", uploadObjects[0].getMethordName());
                Data_From_Server = http_manager.GetData(uploadObjects[0]);
                return Data_From_Server;
            }
            else if(uploadObjects[0].getTasktype().toString().equalsIgnoreCase(TaskType.SAARTHI.toString())){
                Log.e("We Here", uploadObjects[0].getMethordName());
                Data_From_Server = http_manager.GetData(uploadObjects[0]);
                return Data_From_Server;
            }



        } catch (Exception e) {
            Log.e("Value Saved",e.getLocalizedMessage().toString());
        }
        return Data_From_Server;

    }

    @Override
    protected void onPostExecute(ResponsePojoGet result) {
        super.onPostExecute(result);
        try {
            taskListener.onTaskCompleted(result, taskType);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        dialog.dismiss();
    }
}