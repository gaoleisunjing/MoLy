package project.gaolei.molyo;

import android.media.Image;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.molyo.bean.ExperiencePersonalBean;
import com.project.load.HandlerUtils_MolyoMyExperience;
import com.squareup.picasso.Picasso;

import java.lang.ref.WeakReference;

public class ExperienceActivity extends AppCompatActivity {

    String experience_path;
    ImageView experience_imageStructor, experience_User;
    TextView User_name, creatTime, desc;
    ExperiencePersonalBean data;
    LinearLayout layout;

    private final MyHandler handler=new MyHandler(this);
    private class MyHandler extends Handler{
       WeakReference<ExperienceActivity> weakReference;
        public MyHandler(ExperienceActivity activity){
            weakReference=new WeakReference<ExperienceActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            Log.d("gl","super=====handler");
            super.handleMessage(msg);
            if (msg.what == 6) {
                Log.d("gl","=====执行了么");
                data = (ExperiencePersonalBean) msg.obj;
                Log.d("gl", "=======555" + data.getBody().getDesc());
                initGetData();
            }
        }
    }

    private void initGetData() {

        for (int i = 0; i < data.getBody().getImgs().size(); i++) {
            ImageView image = new ImageView(this);
            Picasso.with(this).load(data.getBody().getImgs().get(i)).error(R.mipmap.ic_launcher).into(image);
            layout.addView(image, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
        }
        Picasso.with(this).load(data.getBody().getUserImg()).error(R.mipmap.ic_launcher).into(experience_User);
        User_name.setText(data.getBody().getUserName());
        creatTime.setText(data.getBody().getCreateTime() + "  " + data.getBody().getShopName());
        desc.setText(data.getBody().getDesc());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience);
        initView();
        experience_path = getIntent().getExtras().getString("experience_path");
        initSetData();

    }

    private void initSetData() {
        HandlerUtils_MolyoMyExperience handString = new HandlerUtils_MolyoMyExperience(handler);
        handString.loadJstring(experience_path);
    }

    private void initView() {
        experience_imageStructor = (ImageView) findViewById(R.id.experience_imageStructor_Id);
        experience_User = (ImageView) findViewById(R.id.experience_UserImage_Id);
        User_name = (TextView) findViewById(R.id.experience_Username_Id);
        creatTime = (TextView) findViewById(R.id.experience_creatTime_Id);
        desc = (TextView) findViewById(R.id.experience_desc_Id);
        layout = (LinearLayout) findViewById(R.id.experience_lineLayout_Id);
    }

}
