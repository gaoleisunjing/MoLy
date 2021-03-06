package com.project.load;

import android.os.Handler;
import android.os.Message;
import com.google.gson.Gson;
import com.molyo.bean.MolyoGoBean;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 16-9-26.
 */
public class HandlerUtils_MolyoGO {

    Handler handler;
    Gson gson = new Gson();

    MolyoGoBean molyoBean;

    public HandlerUtils_MolyoGO(Handler handler) {
        this.handler = handler;
    }

    public static ExecutorService executor = Executors.newFixedThreadPool(20);

    public void loadJstring(final String url) {

        executor.execute(new Runnable() {
            @Override
            public void run() {
                String string = DownLoadUtils.getJsonString(url);
                molyoBean = gson.fromJson(string, MolyoGoBean.class);
                Message message = Message.obtain();
                if (molyoBean != null) {
                    message.what = 3;
                    message.obj = molyoBean;
                    handler.sendMessage(message);
                }

            }
        });

    }

}
