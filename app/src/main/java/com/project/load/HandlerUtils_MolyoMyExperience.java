package com.project.load;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.google.gson.Gson;
import com.molyo.bean.ExperiencePersonalBean;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 16-9-26.
 */
public class HandlerUtils_MolyoMyExperience {

    Handler handler;
    Gson gson = new Gson();
    ExperiencePersonalBean data;
    public HandlerUtils_MolyoMyExperience(Handler handler) {
        this.handler = handler;
    }

    public static ExecutorService executor = Executors.newFixedThreadPool(20);

    public void loadJstring(final String url) {

        executor.execute(new Runnable() {
            @Override
            public void run() {
                String string = DownLoadUtils.getJsonString(url);
                Log.d("gl","string=======url"+url);
                data = gson.fromJson(string, ExperiencePersonalBean.class);
                if (data != null) {
                    Message message = Message.obtain();
                    message.what = 6;
                    message.obj = data;
                    Log.d("gl","data======"+data.getBody().getDesc());
                    handler.sendMessage(message);
                }

            }
        });

    }

}
