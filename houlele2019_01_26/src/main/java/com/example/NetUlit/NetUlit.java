package com.example.NetUlit;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @侯乐乐
 * 1.判断网络
 * 2.请求数据图片
 *
 */
public class NetUlit {
//    判断网络
    public boolean isgetcontent(Context context) {
        if (context != null) {
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = manager.getActiveNetworkInfo();
            if (info != null) {
            }
            return info.isConnected();
        }
        return false;
    }
//请求数据

    public static String getcontent(String URlDate) {
        try {
            URL url = new URL(URlDate);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int code = connection.getResponseCode();
//            判断
            if (code == 200) {
                InputStream stream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
                String str = "";
//                循环语句
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
}
