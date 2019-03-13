package com.bwie.netuilt;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *请求网络
 * 请求数据
 * 使用异步接口
 * 封装网络请求工具类
 */
public class NetUilt {
    //    请求网络
    public static boolean IsGetContent(Context context) {
        if (context != null) {
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = manager.getActiveNetworkInfo();
            if (info != null) {
                return info.isConnected();
            }
        }
        return false;
    }

    //请求数据
    public static String getContent(String Url) {

        try {
            URL url = new URL(Url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int code = connection.getResponseCode();
//            判断
            if (code == 200) {
                InputStream stream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
                String str = "";
//                while
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
//异步接口
    public interface MyCallBack {
        void getDate(String s);
    }
    //        封装网络请求工具类
    public static void MyAnck(String StringUrl, final MyCallBack callBack) {
        new AsyncTask<String, Void, String>() {
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                callBack.getDate(s);
            }
//方法
            @Override
            protected String doInBackground(String... strings) {
                String content = NetUilt.getContent(strings[0]);
                return content;
            }
        }.execute(StringUrl);

    }
}
