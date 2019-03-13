package com.bawei.netulit;

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
 * @侯乐乐 判断网络
 * 请求数据
 * 异步加载
 */
public class NetUlit {
    //    判断网络
    public static boolean isGetContent(Context context) {
//        判断不能为空
        if (context != null) {
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = manager.getActiveNetworkInfo();
            if (info != null) {
                return info.isConnected();
            }
        }
        return false;
    }

    //    请求数据
    public String getCntent(String UrlDate) {
        try {
            URL url = new URL(UrlDate);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int code = connection.getResponseCode();
//            判断是否接收
            if (code == 200) {
                InputStream stream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
//                自定义字符创
                String str = "";
//                不能为空
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
//    异步加载
    public interface MyCallBack{
          void  getDate(String s);
    }
//    获取异步
    public static  void  MyAsync(String StringURl,final MyCallBack callBack){
        new AsyncTask<String,Void,String>(){
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                callBack.getDate(s);
            }
//获取数据
            @Override
            protected String doInBackground(String... strings) {
                String cntent = new NetUlit().getCntent(strings[0]);
                return cntent;
            }
        }.execute(StringURl);
    }
}
