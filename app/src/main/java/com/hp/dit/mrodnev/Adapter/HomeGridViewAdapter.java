package com.hp.dit.mrodnev.Adapter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.blikoon.qrcodescanner.QrCodeActivity;
import com.hp.dit.mrodnev.Modal.ModulesPojo;
import com.hp.dit.mrodnev.R;
import com.hp.dit.mrodnev.activities.GenerateIDCard;
import com.hp.dit.mrodnev.activities.Registration;
import com.hp.dit.mrodnev.lazyloader.ImageLoader;
import com.hp.dit.mrodnev.presentation.CustomDialog;
import com.hp.dit.mrodnev.utilities.Preferences;

import java.text.ParseException;
import java.util.ArrayList;

/**
 * @author Kush.Dhawan
 * @project HPePass
 * @Time 01, 05 , 2020
 */
public class HomeGridViewAdapter extends BaseAdapter {
    Context c;
    ArrayList<ModulesPojo> gridHome;


    ImageLoader il = new ImageLoader(c);
    CustomDialog CD = new CustomDialog();


    public HomeGridViewAdapter(Context c, ArrayList<ModulesPojo> spacecrafts) {
        this.c = c;
        this.gridHome = spacecrafts;
    }

    @Override
    public int getCount() {
        return gridHome.size();
    }

    @Override
    public Object getItem(int i) {
        return gridHome.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(c).inflate(R.layout.home_gridview_model, viewGroup, false);
        }

        final ModulesPojo s = (ModulesPojo) this.getItem(i);

        ImageView img = (ImageView) view.findViewById(R.id.spacecraftImg);
        TextView nameTxt = (TextView) view.findViewById(R.id.nameTxt);


        nameTxt.setText(s.getName());


        if (s.getLogo().equalsIgnoreCase("null")) {
            //show uk icon
            String fnm = "uttarakhand";
            String PACKAGE_NAME = c.getApplicationContext().getPackageName();
            int imgId = this.c.getApplicationContext().getResources().getIdentifier(PACKAGE_NAME + ":drawable/" + fnm, null, null);
            System.out.println("IMG ID :: " + imgId);
            System.out.println("PACKAGE_NAME :: " + PACKAGE_NAME);
            img.setImageBitmap(BitmapFactory.decodeResource(c.getApplicationContext().getResources(), imgId));
        } else {
            String fnm = s.getLogo();
            String PACKAGE_NAME = c.getApplicationContext().getPackageName();
            int imgId = this.c.getApplicationContext().getResources().getIdentifier(PACKAGE_NAME + ":drawable/" + fnm, null, null);
            System.out.println("IMG ID :: " + imgId);
            System.out.println("PACKAGE_NAME :: " + PACKAGE_NAME);
            img.setImageBitmap(BitmapFactory.decodeResource(c.getApplicationContext().getResources(), imgId));
        }


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (s.getId() == "1") {
                    Intent i = new Intent(c.getApplicationContext(), GenerateIDCard.class);
                    (c).startActivity(i);

                }
                if (s.getId().equalsIgnoreCase("4")) {
                    Preferences.getInstance().loadPreferences(c.getApplicationContext());


                    Preferences.getInstance().district_id = "";
                    Preferences.getInstance().districtName = "";
                    Preferences.getInstance().barrierName = "";
                    Preferences.getInstance().barrier_id = "";
                    Preferences.getInstance().phone_number = "";
                    Preferences.getInstance().userid = "";
                    Preferences.getInstance().isLoggedIn = false;


                    Preferences.getInstance().savePreferences(c.getApplicationContext());
                    Toast.makeText(c.getApplicationContext(), "Logout Successful", Toast.LENGTH_LONG).show();

                    Intent mainIntent = new Intent(c.getApplicationContext(), Registration.class);
                    (c).startActivity(mainIntent);
                    ((Activity) c).finish();


                }
                if (s.getId().equalsIgnoreCase("2")) {
                    Intent i = new Intent(c.getApplicationContext(), QrCodeActivity.class);
                    ((Activity) c).startActivityForResult(i, 101);

                }
                if (s.getId().equalsIgnoreCase("3")) {
                   //TODO

                    CD.showDialogSearchByPassId((Activity) c);
                }




            }
        });

        return view;
    }


}
