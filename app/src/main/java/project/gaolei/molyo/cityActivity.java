package project.gaolei.molyo;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.molyo.bean.CityBean;
import com.project.adapter.CityBaseAdapter;
import com.project.load.HandlerUtils;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class cityActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    String PATH_CITY = "http://www.molyo.com//mArea/getCityListV1_7?enableFlag=1";
    List<CityBean.BodyBean.ListBean> datalist;
    CityBaseAdapter adapter;
    GridView gridView;

    private final MyHandler handler=new MyHandler(this);
    private class MyHandler extends Handler{

    WeakReference<cityActivity> weakReference;
      public MyHandler(cityActivity activity){
            weakReference=new WeakReference<cityActivity>(activity);
        }
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {

                case 1:
                    datalist = (List<CityBean.BodyBean.ListBean>) msg.obj;
                    adapter = new CityBaseAdapter(datalist, getApplicationContext());
                    gridView.setAdapter(adapter);
                    break;
            }

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_dialog_city);

        gridView = (GridView) findViewById(R.id.gridview_cityId);

        datalist = new ArrayList<>();
        HandlerUtils handlerUtils = new HandlerUtils(handler);
        handlerUtils.loadJstring(PATH_CITY);
        gridView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent=new Intent();
        intent.putExtra("city",datalist.get(position).getName());
        cityActivity.this.setResult(10,intent);
        cityActivity.this.finish();
    }
}
