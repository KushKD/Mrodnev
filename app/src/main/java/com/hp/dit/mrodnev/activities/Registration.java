package com.hp.dit.mrodnev.activities;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.hp.dit.mrodnev.Modal.RegistrationPojo;
import com.hp.dit.mrodnev.Modal.ResponsePojoGet;
import com.hp.dit.mrodnev.Modal.SuccessResponse;
import com.hp.dit.mrodnev.Modal.UploadObject;
import com.hp.dit.mrodnev.R;
import com.hp.dit.mrodnev.enums.TaskType;
import com.hp.dit.mrodnev.generic.GenericAsyncPostObject;
import com.hp.dit.mrodnev.interfaces.AsyncTaskListenerObject;
import com.hp.dit.mrodnev.json.JsonParse;
import com.hp.dit.mrodnev.presentation.CustomDialog;
import com.hp.dit.mrodnev.security.EncryptDecrypt;
import com.hp.dit.mrodnev.utilities.AppStatus;
import com.hp.dit.mrodnev.utilities.Econstants;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class Registration extends AppCompatActivity implements AsyncTaskListenerObject {



    CustomDialog CD = new CustomDialog();


    EditText username, password;
    Button register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        requestPermissions();



        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);




        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Test","dfdfd");
                if (!username.getText().toString().isEmpty()) {
                    if(!password.getText().toString().isEmpty()){
                        if (AppStatus.getInstance(Registration.this).isOnline()) {

                            RegistrationPojo registrationPojo = new RegistrationPojo();
                            registrationPojo.setUsername(username.getText().toString().trim());
                            registrationPojo.setPassword(password.getText().toString().trim());


                            UploadObject object = new UploadObject();
                            object.setUrl(Econstants.url);
                            object.setMethordName(Econstants.methordLogin);
                            object.setTasktype(TaskType.LOGIN);
                            object.setParam(registrationPojo.toJSON());
                            Log.e("Object", object.toString());
                            new GenericAsyncPostObject(
                                    Registration.this,
                                    Registration.this,
                                    TaskType.LOGIN).
                                    execute(object);
                        } else {
                            CD.showDialog(Registration.this, Econstants.internetNotAvailable);
                        }
                    }else{
                        CD.showDialog(Registration.this,"Please enter Password.");
                    }
                }
            else {
                    CD.showDialog(Registration.this, "Please enter Username");
                }
            }
        });





    }






    private void requestPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(getApplicationContext(),
                    Manifest.permission.ACCESS_COARSE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,

                        Manifest.permission.INTERNET,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.ACCESS_NETWORK_STATE,
                        Manifest.permission.CHANGE_NETWORK_STATE,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_BACKGROUND_LOCATION,
                        Manifest.permission.CAMERA,
                        Manifest.permission.VIBRATE,
                        Manifest.permission.SEND_SMS,
                        Manifest.permission.RECEIVE_SMS


                }, 0);
            }
        }


    }


    @Override
    public void onTaskCompleted(ResponsePojoGet result, TaskType taskType) throws JSONException, NoSuchPaddingException, UnsupportedEncodingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, InvalidKeyException {


        if (TaskType.LOGIN == taskType) {
            System.out.println(result.toString());
            Log.e("Response", result.toString());

            SuccessResponse response  = JsonParse.getSuccessResponse(result.getResponse());
            EncryptDecrypt ED = new EncryptDecrypt();
            Log.e("Decrypted Data", ED.decrypt(response.getResponse()) );


        }


    }
}
