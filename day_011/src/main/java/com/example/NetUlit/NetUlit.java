package com.example.NetUlit;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.Fragment;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetUlit {
    public boolean isgetConten(Context context){
        if(context!= null){
             ConnectivityManager  manager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = manager.getActiveNetworkInfo();
            if(info!=null){
                return info.isConnected();
            }
        }
        return  false;
    }
    public  static  String getcontenr(String URl){
        try {
            URL url = new URL(URl);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            int code = connection.getResponseCode();
            if(code == 200){
                InputStream stream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
                String str = "";
                while ((str  = reader.readLine())!=null) {
                    buffer.append(str);
                }
                return buffer.toString();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }
}
