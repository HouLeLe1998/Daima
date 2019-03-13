package com.example.netulit;

import android.content.ContentValues;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.IDN;
import java.net.URL;

public class NetUlit  {
//    判断网络
    public static boolean isgetcontent(Context context){
        if(context !=null){
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = manager.getActiveNetworkInfo();
            if(info !=null){
                 return info.isConnected();
            }
        }
         return false;

    }
//    请求数据
    public    String getconten(String URldate){
        try {
            URL url = new URL(URldate);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            int code = connection.getResponseCode();
            if(code == 200){
                InputStream stream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
                String  str = "";
                while ((str=reader.readLine())!=null){
                    buffer.append(str);
                }
                return buffer.toString();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }
//    实现异步加载
    public  interface MyCallBack{
        void getDate(String s);
    }
    public static  void  MyAsyncTaca(String StringUrl,final MyCallBack myCallBack){
        new AsyncTask<String,Void,String>(){
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                myCallBack.getDate(s);
            }
            @Override
            protected String doInBackground(String... strings) {
                String getconten = new NetUlit().getconten(strings[0]);
                return getconten;
            }
        }.execute(StringUrl);

    }
}
