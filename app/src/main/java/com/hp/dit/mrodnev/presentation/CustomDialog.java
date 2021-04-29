package com.hp.dit.mrodnev.presentation;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.hp.dit.mrodnev.R;
import com.hp.dit.mrodnev.lazyloader.ImageLoader;

import org.json.JSONException;

/**
 * @author Kush.Dhawan
 * @project HPePass
 * @Time 01, 05 , 2020
 */
public class CustomDialog {
    int downloadIdOne;


    public void showDialog(final Activity activity, String msg) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_custom);

        int width = (int) (activity.getResources().getDisplayMetrics().widthPixels * 0.95);
        int height = (int) (activity.getResources().getDisplayMetrics().heightPixels * 0.50);
        dialog.getWindow().setLayout(width, height);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        TextView text = (TextView) dialog.findViewById(R.id.dialog_result);
        text.setMovementMethod(new ScrollingMovementMethod());
        text.setText(msg);

        Button dialog_ok = (Button) dialog.findViewById(R.id.dialog_ok);

        dialog_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // activity.finish();
                dialog.dismiss();
            }
        });

        dialog.show();

    }

    public void showDialogCloseActivity(final Activity activity, String msg) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_custom);

        int width = (int) (activity.getResources().getDisplayMetrics().widthPixels * 0.95);
        int height = (int) (activity.getResources().getDisplayMetrics().heightPixels * 0.50);
        dialog.getWindow().setLayout(width, height);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        TextView text = (TextView) dialog.findViewById(R.id.dialog_result);
        text.setText(msg);

        Button dialog_ok = (Button) dialog.findViewById(R.id.dialog_ok);

        dialog_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
                dialog.dismiss();
            }
        });

        dialog.show();

    }


    public void showDialogHTML(final Activity activity, final String msg, final String msgServer) throws JSONException {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_custom_web);

        int width = (int) (activity.getResources().getDisplayMetrics().widthPixels);
        int height = (int) (activity.getResources().getDisplayMetrics().heightPixels);
        dialog.getWindow().setLayout(width, height);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WebView webView = (WebView) dialog.findViewById(R.id.dialog_result);
        final EditText remarks = dialog.findViewById(R.id.remarks);
        webView.setVerticalScrollBarEnabled(true);
        webView.requestFocus();
        webView.getSettings().setDefaultTextEncodingName("utf-8");
        webView.getSettings().setJavaScriptEnabled(true);
        final String mimeType = "text/html";
        final String encoding = "UTF-8";


        webView.loadDataWithBaseURL("", msg, mimeType, encoding, "");
        Button dialog_ok = (Button) dialog.findViewById(R.id.dialog_ok);
        Button dialog_verified = (Button) dialog.findViewById(R.id.dialog_verified);

        dialog_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // activity.finish();
                dialog.dismiss();
            }
        });

        dialog_verified.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //TODO


                Intent intent = new Intent("verifyData");
                intent.setPackage(activity.getPackageName());
                Bundle bundle = new Bundle();

                intent.putExtras(bundle);
                activity.sendBroadcast(intent);
                dialog.dismiss();
            }
        });

        dialog.show();

    }















}
