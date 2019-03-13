package com.example.netuli;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

//判断网络
public class NetUlit {
    public static boolean isGetContent(Context context) {
        if (context !=null){
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = manager.getActiveNetworkInfo();
            if (info != null) {
                return info.isConnected();
            }
        }
        return false;
    }

    //      请求数据
    public static String getContent(String URLDate) {
        try {
            URL url = new URL(URLDate);
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
//    异步接口
    public interface MyCallBack {
            void GetDate(String s);
    }
    public static   void  MyAnck(String StringURl,final MyCallBack callBack){
        new AsyncTask<String,Void,String>(){
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                callBack.GetDate(s);
            }

            @Override
            protected String doInBackground(String... strings) {
                String content = new NetUlit().getContent(strings[0]);
                return content;
            }
        }.execute(StringURl);
    }
}
