package com.project.load;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.google.gson.Gson;
import com.molyo.bean.MolyoDetailsBean;
import com.molyo.bean.MolyoGoBean;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 16-9-26.
 */
public class HandlerUtils_MolyoMyCoffee {

    Handler handler;
    Gson gson = new Gson();
    MolyoDetailsBean molyoDetailsBean;

    public HandlerUtils_MolyoMyCoffee(Handler handler) {
        this.handler = handler;
    }

    public static ExecutorService executor = Executors.newFixedThreadPool(20);

    public void loadJstring(final String url) {

        executor.execute(new Runnable() {
            @Override
            public void run() {
                String string = DownLoadUtils.getJsonString(url);
                molyoDetailsBean = gson.fromJson(string, MolyoDetailsBean.class);
                Message message = Message.obtain();
                if (molyoDetailsBean != null) {
                    message.what = 4;
                    message.obj = molyoDetailsBean;
                    handler.sendMessage(message);
                }

            }
        });

    }

}
