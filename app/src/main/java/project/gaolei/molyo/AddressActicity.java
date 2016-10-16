package project.gaolei.molyo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AddressActicity extends AppCompatActivity {


    String address, phone, type, consumtor, openTime, longitude, latitude;
    ImageView open_map;
    TextView addr, phon, typ, consum, openTim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_acticity);
        initView();
        ininGetData();
        intSetData();
        initListener();
    }

    private void initListener() {
        open_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddressActicity.this, "打开地图", Toast.LENGTH_SHORT).show();
            }
        });

        addr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddressActicity.this, "打开地图===一样", Toast.LENGTH_SHORT).show();
            }
        });
        phon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddressActicity.this, " 打电话功能", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initView() {
        open_map = (ImageView) findViewById(R.id.address_image_Id);
        addr = (TextView) findViewById(R.id.address_textView_Id);
        phon = (TextView) findViewById(R.id.phone_textView_Id);
        typ = (TextView) findViewById(R.id.type_textView_Id);
        consum = (TextView) findViewById(R.id.consum_textView_Id);
        openTim = (TextView) findViewById(R.id.openTime_textView_Id);
    }

    private void intSetData() {

        addr.setText("地址: " + address);
        phon.setText("电话: " + phone);
        typ.setText("类型: " + type);
        consum.setText("人均: " + consumtor);
        openTim.setText("营业时间: " + openTime);
    }

    private void ininGetData() {
        address = getIntent().getExtras().getString("address");
        phone = getIntent().getExtras().getString("phone");
        type = getIntent().getExtras().getString("type");
        consumtor = getIntent().getExtras().getString("consumtor");
        openTime = getIntent().getExtras().getString("openTime");
        longitude = getIntent().getExtras().getString("longitude");
        latitude = getIntent().getExtras().getString("latitude");
    }
}
