package project.gaolei.molyo;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.molyo.bean.CollectionPersonalBean;
import com.project.load.HandlerUtils_MolyoMyCollection;
import com.squareup.picasso.Picasso;

import java.lang.ref.WeakReference;

public class CollectionActivity extends AppCompatActivity {

    static String USER_PATH;
    static ImageView user_image;
    static TextView liveCity, experienceNum, noticeNum, fansNum, collect, interest, userName;
    static CollectionPersonalBean data;

    private final MyHandler handler = new MyHandler(this);

    //静态的问题 没有解决
    private  class MyHandler extends Handler {
        //若应用可以解决Handler的内存泄漏问题
        WeakReference<CollectionActivity> weakReference;

        public MyHandler(CollectionActivity activity) {
            weakReference = new WeakReference<CollectionActivity>(activity);
        }
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 7) {
                data = (CollectionPersonalBean) msg.obj;
                setData();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        USER_PATH = getIntent().getExtras().getString("user_path");
        Log.d("gl", "user_path====" + USER_PATH);

        initView();
        initDownLoad();
        initListener();
    }

    private void initDownLoad() {
        HandlerUtils_MolyoMyCollection hand = new HandlerUtils_MolyoMyCollection(handler);
        hand.loadJstring(USER_PATH);
    }

    private void initListener() {
        collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //收藏的用户
            }
        });

        interest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //感兴趣的活动
            }
        });
    }

    private void initView() {
        user_image = (ImageView) findViewById(R.id.collection_imageUser_Id);
        liveCity = (TextView) findViewById(R.id.collection_city_Id);
        experienceNum = (TextView) findViewById(R.id.collection_experienceNum_Id);
        noticeNum = (TextView) findViewById(R.id.collection_noticeNum_Id);
        fansNum = (TextView) findViewById(R.id.collection_fansNum_Id);
        collect = (TextView) findViewById(R.id.collection_collectClick_Id);
        interest = (TextView) findViewById(R.id.collection_interestedClick_Id);
        userName = (TextView) findViewById(R.id.collection_userName_Id);
    }

    private  void setData() {
        userName.setText(data.getBody().getNickName());
        Picasso.with(this).load(data.getBody().getImg()).error(R.mipmap.ic_launcher).into(user_image);
        experienceNum.setText(data.getBody().getExpCount());
        noticeNum.setText(data.getBody().getAttentionCount());
        fansNum.setText(data.getBody().getFansCount());

    }

    ;
}
