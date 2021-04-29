package com.hp.dit.mrodnev.generic;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.hp.dit.mrodnev.Modal.ResponsePojoGet;
import com.hp.dit.mrodnev.Modal.UploadObject;
import com.hp.dit.mrodnev.enums.TaskType;
import com.hp.dit.mrodnev.interfaces.AsyncTaskListenerObject;
import com.hp.dit.mrodnev.network.HttpManager;

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
public class GenericAsyncPostObject extends AsyncTask<UploadObject,Void , ResponsePojoGet> {

    ProgressDialog dialog;
    Context context;
    AsyncTaskListenerObject taskListener_;
    TaskType taskType;
    private ProgressDialog mProgressDialog;

    public GenericAsyncPostObject(Context context, AsyncTaskListenerObject taskListener, TaskType taskType){
        this.context = context;
        this.taskListener_ = taskListener;
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
        UploadObject data = null;
        data = uploadObjects[0];
        HttpManager http_manager = null;
        ResponsePojoGet Data_From_Server = null;
        boolean save = false;

        try{
            http_manager = new HttpManager();

            if(TaskType.LOGIN.toString().equalsIgnoreCase(data.getTasktype().toString())){
                Data_From_Server = http_manager.PostDataLogin(data);
                Log.e("Data hhghsds",Data_From_Server.toString());
                return Data_From_Server;
            }




        }catch(Exception e){
            return Data_From_Server;
        }


        return Data_From_Server;
    }

    @Override
    protected void onPostExecute(ResponsePojoGet result) {
        super.onPostExecute(result);

        try {
            taskListener_.onTaskCompleted(result, taskType);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }

        dialog.dismiss();
    }
}
