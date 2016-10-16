package com.project.load;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.molyo.bean.CityBean;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 16-9-26.
 */
public class HandlerUtils {

    Handler handler;
    Gson gson;

    CityBean cityBean;
    List<CityBean.BodyBean.ListBean> cityList;

    public HandlerUtils(Handler handler){
        this.handler=handler;
    }

    public static ExecutorService executor= Executors.newFixedThreadPool(20);

    public void  loadJstring(final String url){

        executor.execute(new Runnable() {
            @Override
            public void run() {
                String string=DownLoadUtils.getJsonString(url);
                gson=new Gson();
                cityBean=gson.fromJson(string,CityBean.class);
                cityList=cityBean.getBody().getList();

//                try {
//                    JSONObject object=new JSONObject(string);
//                    String s=object.getJSONArray("tabs").get(1).toString();
//                    JSONObject object1=new JSONObject(s);
//                    String s1 =object1.getJSONArray("data").toString();
//                    Type type = new TypeToken<List<Selection4>>() {
//                    }.getType();
//                     data4  = gson.fromJson(s1, type);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }


                Message message=Message.obtain();
//                message.what=1;
//                message.obj=data;
//                message.what=2;
//                message.obj=tabsBeanList;

                if(cityList!=null){
                    message.what=1;
                    message.obj=cityList;
                    handler.sendMessage(message);
                }

            }
        });

    }

}
