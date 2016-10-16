package com.project.load;

import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;
import com.molyo.bean.CollectionPersonalBean;
import com.molyo.bean.MolyoDetailsBean;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 16-9-26.
 */
public class HandlerUtils_MolyoMyCollection {

    Handler handler;
    Gson gson = new Gson();
    CollectionPersonalBean collect;

    public HandlerUtils_MolyoMyCollection(Handler handler) {
        this.handler = handler;
    }

    public static ExecutorService executor = Executors.newFixedThreadPool(20);

    public void loadJstring(final String url) {

        executor.execute(new Runnable() {
            @Override
            public void run() {
                String string = DownLoadUtils.getJsonString(url);
                collect = gson.fromJson(string,CollectionPersonalBean.class);
                Message message = Message.obtain();
                if (collect != null) {
                    message.what = 7;
                    message.obj = collect;
                    handler.sendMessage(message);
                }

            }
        });

    }

}
