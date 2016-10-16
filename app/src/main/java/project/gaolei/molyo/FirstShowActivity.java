package project.gaolei.molyo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;

public class FirstShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //用来消除标题栏(ActionBar) 这样才能充满整个屏幕,显得更加美观
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_first_show);
        //定义一个计时器,timer中有一个线程,这个线程不断执行task
        Timer timer = new Timer();
        //timerTask实现Runnable接口,timerTask类就代表一个指定时间内执行的task
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(FirstShowActivity.this, MainActivity.class);
                startActivity(intent);
                //从栈中杀掉欢迎界面,这样就在返回的时候回到欢迎界面,注意哦
                FirstShowActivity.this.finish();
            }
        };
        //2秒后执行指定任务,自动跳转到指定activity
        timer.schedule(timerTask, 3000);
    }

    //还可以用线程做 让线程sleep后启动activity即可
}
