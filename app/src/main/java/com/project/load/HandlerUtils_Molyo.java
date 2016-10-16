package com.project.load;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.google.gson.Gson;
import com.molyo.bean.CityBean;
import com.molyo.bean.MolyoBean;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 16-9-26.
 */
public class HandlerUtils_Molyo {

    Handler handler;
    Gson gson = new Gson();

    MolyoBean molyoBean;

    public HandlerUtils_Molyo(Handler handler) {
        this.handler = handler;
    }

    public static ExecutorService executor = Executors.newFixedThreadPool(20);

    public void loadJstring(final String url) {

        executor.execute(new Runnable() {
            @Override
            public void run() {
                String string = DownLoadUtils.getJsonString(url);
                molyoBean = gson.fromJson(string, MolyoBean.class);
                Message message = Message.obtain();
                if (molyoBean != null) {
                    message.what = 2;
                    message.obj = molyoBean;
                    handler.sendMessage(message);
                }

            }
        });

    }

}
