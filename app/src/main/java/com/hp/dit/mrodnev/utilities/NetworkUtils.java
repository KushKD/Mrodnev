package com.hp.dit.mrodnev.utilities;


import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;


public class NetworkUtils {

    /**
     * SSL Handshake
     */
    public static SSLSocketFactory getSSLSocketFactory() {
        SSLContext sslContext = null;
        try {
            TrustManager[] tm = {
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }
                    }
            };
            sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, tm, null);
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sslContext.getSocketFactory();
    }

    public static HttpURLConnection getInputStreamConnection(String url) {
        HttpURLConnection conn = null;
        try {
            URL url_ = new URL(url);
            conn = (HttpURLConnection) url_.openConnection();
            if (url_.toString().startsWith("https")) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) conn;
                httpsURLConnection.setSSLSocketFactory(getSSLSocketFactory());
            } else {
                conn = (HttpURLConnection) url_.openConnection();
            }
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setUseCaches(false);
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(10000);
            conn.setRequestProperty("Content-Type", "application/text");
            conn.setInstanceFollowRedirects(true);
            conn.connect();
        } catch (Exception e) {

        }
        return conn;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static StringBuilder getErrorStream(HttpURLConnection conn_) throws IOException {
        StringBuilder sb = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(conn_.getErrorStream(), StandardCharsets.UTF_8));
        String line = null;
        sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line + "\n");
        }
        br.close();
        Log.e("Error", sb.toString());
        return sb;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static StringBuilder getInputStream(HttpURLConnection conn_) throws IOException {
        StringBuilder sb = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(conn_.getInputStream(), StandardCharsets.UTF_8));
        String line = null;
        sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line + "\n");
        }
        br.close();
        Log.e("Data=--=-", sb.toString());
        return sb;
    }
}
