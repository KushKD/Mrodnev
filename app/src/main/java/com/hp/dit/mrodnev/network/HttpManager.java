package com.hp.dit.mrodnev.network;


import com.hp.dit.mrodnev.Modal.ResponsePojoGet;
import com.hp.dit.mrodnev.Modal.UploadObject;
import com.hp.dit.mrodnev.security.EncryptDecrypt;
import com.hp.dit.mrodnev.utilities.Econstants;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
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
public class HttpManager {

    EncryptDecrypt ED;

    public HttpManager() throws NoSuchPaddingException, UnsupportedEncodingException, NoSuchAlgorithmException {
        ED = new EncryptDecrypt();
    }




    public ResponsePojoGet PostDataLogin(UploadObject data) {


            HttpURLConnection conn_ = null;
            StringBuilder sb = null;
            ResponsePojoGet responsePojoGet = null;

            String URL = null;


            try {

                URL = data.getUrl()+data.getMethordName();
                conn_ = NetworkUtils.getInputStreamConnection(URL);
                OutputStreamWriter out = new OutputStreamWriter(conn_.getOutputStream());
                out.write(ED.encrypt(data.getParam()));
                out.close();


                try {
                    int HttpResult = conn_.getResponseCode();
                    if (HttpResult != HttpURLConnection.HTTP_OK) {
                        sb = NetworkUtils.getErrorStream(conn_);
                        responsePojoGet = new ResponsePojoGet();
                        responsePojoGet = Econstants.createOfflineObject(URL, data.getParam(), sb.toString(), Econstants.HTTP_FALIURE);
                        System.out.println(sb.toString());
                        return responsePojoGet;

                    } else {
                        sb = NetworkUtils.getInputStream(conn_);
                        responsePojoGet = new ResponsePojoGet();
                        System.out.println("=========================================");
                        System.out.println(ED.decrypt(sb.toString()));
                        System.out.println("=========================================");
                        responsePojoGet = Econstants.createOfflineObject(URL, data.getParam(), ED.decrypt(sb.toString()), Econstants.HTTP_SUCCESS);


                    }

                } catch (Exception e) {
                    responsePojoGet = new ResponsePojoGet();
                    responsePojoGet = Econstants.createOfflineObject(URL, data.getParam(), sb.toString(), Econstants.HTTP_FALIURE);
                    return responsePojoGet;
                }



            } catch (NoSuchPaddingException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (BadPaddingException e) {
                e.printStackTrace();
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            } catch (IllegalBlockSizeException e) {
                e.printStackTrace();
            } catch (InvalidAlgorithmParameterException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (conn_ != null)
                    conn_.disconnect();
            }
            return responsePojoGet;
        }




    }
