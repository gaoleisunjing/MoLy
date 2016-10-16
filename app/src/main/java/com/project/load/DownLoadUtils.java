package com.project.load;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 16-9-26.
 */
public class DownLoadUtils {

    public static String getJsonString(String url) {

        String jString = "";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        try {
            //非异步调用 可能会阻塞线程
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                jString = response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
       // Log.d("gl", "工具类下载====" + jString);
        return jString;
    }

    public static Bitmap getBitmap(String url) {
        URL address;
         Bitmap bitmap=null;
        try {
            address = new URL(url);

            HttpURLConnection connection = (HttpURLConnection) address.openConnection();
            connection.connect();
            if(connection.getResponseCode()==200){
                bitmap = BitmapFactory.decodeStream(connection.getInputStream());
            }else {

                Log.d("gl","下载工具类失效");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return  bitmap;
    }

    public static byte[] getImageBytes(String url){

        byte[] bytes=null;
        OkHttpClient client=new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        try {
            Response response = client.newCall(request).execute();
            bytes=response.body().bytes();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return  bytes;
    }




}
