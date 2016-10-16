package com.project.load;

import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;
import com.molyo.bean.LearnMoreBean;
import com.molyo.bean.MolyoGoBean;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 16-9-26.
 */
public class HandlerUtils_MolyoLearnMore {

    Handler handler;
    Gson gson = new Gson();

    LearnMoreBean learn;

    public HandlerUtils_MolyoLearnMore(Handler handler) {
        this.handler = handler;
    }

    public static ExecutorService executor = Executors.newFixedThreadPool(20);

    public void loadJstring(final String url) {

        executor.execute(new Runnable() {
            @Override
            public void run() {
                String string = DownLoadUtils.getJsonString(url);
                learn = gson.fromJson(string, LearnMoreBean.class);
                Message message = Message.obtain();
                if (learn != null) {
                    message.what = 8;
                    message.obj = learn;
                    handler.sendMessage(message);
                }

            }
        });

    }

}
