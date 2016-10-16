package project.gaolei.molyo;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.molyo.bean.MolyoDetailsBean;
import com.project.load.HandlerUtils_MolyoGO;
import com.project.load.HandlerUtils_MolyoMyCoffee;
import com.squareup.picasso.Picasso;

import java.lang.ref.WeakReference;

public class MolyoGoDetailsActivity extends AppCompatActivity {

    String toltal_url, title, id, tipUrl;
    String tip = "http://www.molyo.com/mShop/tip/info?shopId=";
    ImageView hand_image, experience_image;
    TextView name, address, consum, learnMore, experience_text, hand_name;
    LinearLayout layout, addresslayout, experiencelayout;
    WebView webView;
    MolyoDetailsBean data;
    private final MyHandler handler=new MyHandler(this);
    private class MyHandler extends Handler{
        WeakReference<MolyoGoDetailsActivity> weakReference;
        public MyHandler(MolyoGoDetailsActivity activity){
            weakReference=new WeakReference<MolyoGoDetailsActivity>(activity);
        }
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 4) {
                data = (MolyoDetailsBean) msg.obj;
                if (data != null) {
                    initSetData();
                    initListener();
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_molyo_go_details);
        initGetIntent();
        initView();
        initLoadData(toltal_url);
    }

    private void initListener() {
        addresslayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String address = data.getBody().getArea() + "" + data.getBody().getAddress();
                String phone = data.getBody().getPhone();
                String type = data.getBody().getCategory().get(0).getName() + " " + data.getBody().getCategory().get(1).getName();
                String consumtor = data.getBody().getConsumeMin() + "-" + data.getBody().getConsumeMax();
                String openTime = data.getBody().getOpenTimes().get(0).getStartDate() + "至" + data.getBody().getOpenTimes().get(0).getEndDate()
                        + " " + data.getBody().getOpenTimes().get(0).getTime();
                String longitude = data.getBody().getLongitude();
                String latitude = data.getBody().getLatitude();
                Intent intent = new Intent(MolyoGoDetailsActivity.this, AddressActicity.class);
                intent.putExtra("address", address);
                intent.putExtra("phone", phone);
                intent.putExtra("type", type);
                intent.putExtra("consumtor", consumtor);
                intent.putExtra("openTime", openTime);
                intent.putExtra("longitude", longitude);
                intent.putExtra("latitude", latitude);
                startActivity(intent);
            }
        });
        learnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String learn_path = "http://www.molyo.com//mExperience/getList?cityId=&shopId=" + data.getBody().getId();
                Intent intent = new Intent(MolyoGoDetailsActivity.this, LearnMoreActivvity.class);
                intent.putExtra("learn_path", learn_path);
                startActivity(intent);
            }
        });
        experiencelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String path = "http://www.molyo.com//mExperience/getInfo?id=" + data.getBody().getHotExps().get(0).getId();
                Intent intent = new Intent(MolyoGoDetailsActivity.this, ExperienceActivity.class);
                intent.putExtra("experience_path", path);
                startActivity(intent);
            }
        });
    }

    private void initSetData() {
        String images = data.getBody().getImgs().get(0).getMImg();
        if (images != null && !TextUtils.isEmpty(images)) {
            Picasso.with(this).load(images).error(R.mipmap.ic_launcher).into(hand_image);
        }
        name.setText(data.getBody().getName());
        hand_name.setText(data.getBody().getName());
        String ads = data.getBody().getArea() + " " + data.getBody().getAddress();
        address.setText(ads);
        String con = "人均" + data.getBody().getConsumeMin() + "-" + data.getBody().getConsumeMax();
        consum.setText(con);
        webView.loadUrl(tipUrl);
        String u = data.getBody().getHotExps().get(0).getImg() + "";
        if (u != null && !TextUtils.isEmpty(u)) {
            Picasso.with(this).load(u).error(R.mipmap.ic_launcher).into(experience_image);
        }
        experience_text.setText(data.getBody().getHotExps().get(0).getDesc());
        collectionSetData();
    }

    private void collectionSetData() {
        final int size = data.getBody().getCollectUserList().size();
        Resources resources = this.getResources();
        Drawable drawable = resources.getDrawable(R.drawable.cicle_shape);
        final TextView textView = new TextView(this);
        textView.setBackground(drawable);
        for (int i = 0; i < size; i++) {
            final ImageView im = new ImageView(this);
            im.setAdjustViewBounds(true);
            im.setTag(i);
            if (i == size - 1) {
                layout.addView(textView, 40, 40);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MolyoGoDetailsActivity.this, "加载全部用户\nhaha", Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                Picasso.with(this).load(data.getBody().getCollectUserList().get(i).getImg()).error(R.mipmap.ic_launcher).into(im);
                im.setBackgroundResource(R.drawable.cicle_shape);
                layout.setDividerPadding(10);
                layout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
                layout.addView(im, 40, 40);
                im.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int i1 = (Integer) v.getTag();
                        if (i1 != size - 1) {
                            String user_path = "http://www.molyo.com//mMember/getInfoV1_7?accessToken=&userId=" + data.getBody().getCollectUserList().get(i1).getUserId();
                            Intent intent = new Intent(MolyoGoDetailsActivity.this, CollectionActivity.class);
                            intent.putExtra("user_path", user_path);
                            startActivity(intent);
                        }
                    }
                });
            }
        }

    }

    private void initView() {
        hand_image = (ImageView) findViewById(R.id.MyCoffee_hand_imageId);
        hand_name = (TextView) findViewById(R.id.hand_textId);
        experience_image = (ImageView) findViewById(R.id.MyCoffee_experience_imageId);
        name = (TextView) findViewById(R.id.MyCoffee_address_text1Id);
        address = (TextView) findViewById(R.id.MyCoffee_address_text2Id);
        consum = (TextView) findViewById(R.id.MyCoffee_address_text3Id);
        learnMore = (TextView) findViewById(R.id.MyCoffee_learnMore_textId);
        experience_text = (TextView) findViewById(R.id.MyCoffee_experience_textId);
        layout = (LinearLayout) findViewById(R.id.MyCoffee_collection_layoutId);
        webView = (WebView) findViewById(R.id.MyCoffee_webViewId);
        addresslayout = (LinearLayout) findViewById(R.id.MyCoffee_address_layoutId);
        experiencelayout = (LinearLayout) findViewById(R.id.MyCoffee_experience_Id);
    }

    private void initGetIntent() {
        toltal_url = getIntent().getExtras().getString("detailsUrl");
        title = getIntent().getExtras().getString("detailsTitle");
        id = getIntent().getExtras().getString("detailsId");
        tipUrl = tip + id;
    }

    private void initLoadData(String path) {
        HandlerUtils_MolyoMyCoffee otherHandler = new HandlerUtils_MolyoMyCoffee(handler);
        otherHandler.loadJstring(path);
    }
}
