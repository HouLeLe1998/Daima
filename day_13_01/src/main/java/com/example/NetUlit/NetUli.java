package com.example.NetUlit;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetUli {
    public static boolean isgetconten(Context context) {
        if (context != null) {
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = manager.getActiveNetworkInfo();
            if (info != null) {
                return info.isConnected();
            }

        }
        return false;
    }

    public static String getDate(String Url) {
        try {
            URL url = new URL(Url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int code = connection.getResponseCode();
            if (code == 200) {
                InputStream stream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
                String str = "";
                while ((str = reader.readLine()) != null) {
                    buffer.append(str);
                }
                return buffer.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
//异步加载
    public interface MyCallBack {
        void getDate(String s);
    }

    public static void MyAsyncTaca(String StringURl, final MyCallBack callBack) {
        new AsyncTask<String, Void, String>() {
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                callBack.getDate(s);
            }

            @Override
            protected String doInBackground(String... strings) {
                String date = NetUli.getDate(strings[0]);
                return date;
            }
        }.execute(StringURl);
    }
}
