package project.gaolei.molyo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.common.BitMatrix;
import com.molyo.bean.MolyoBean;
import com.molyo.bean.MolyoGoBean;
import com.project.adapter.MolyoRecycleAdapter;
import com.project.custom.MyRecycleSpaceItemDecoration;
import com.project.custom.MySwipeRefreshLayout;
import com.project.load.HandlerUtils_Molyo;
import com.zxinggaolei.Zxing.Demo.CaptureActivity;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView textView1, ZxingText;
    BitMatrix matrix;//生成二维码的时候用的类
    MySwipeRefreshLayout mySwipeRefreshLayout;
    RecyclerView recycleview;
    private String MOLYO_PATH = "http://www.molyo.com//mIndex/getInfoV1_7?cityId=shenzhen&pageSize=8&currentPage=";
    private String MOLYO_SUBID = "http://www.molyo.com//mSubject/getInfoV1_7?id=";
    private static int page = 1;
    private static int s, s1;
    MolyoBean molyoBean;
    MolyoRecycleAdapter adapter;
    List<MolyoBean.BodyBean.SubjectListBean> data = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    private int lastvisiableItem;

    private final MyHandler handler=new MyHandler(this);
    private class MyHandler extends Handler {
        WeakReference<MainActivity> weakReference;

        public MyHandler(MainActivity activity) {
            weakReference = new WeakReference<MainActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 2) {
                molyoBean = (MolyoBean) msg.obj;
                s = Integer.valueOf(molyoBean.getBody().getTotalPages());
                data = molyoBean.getBody().getSubjectList();
                data.addAll(data);
                if (data != null) {
                    adapter = new MolyoRecycleAdapter(getApplicationContext(), data);
                    recycleview.setAdapter(adapter);
                    //给recycleview设置间距
                    MyRecycleSpaceItemDecoration decoration = new MyRecycleSpaceItemDecoration(8);
                    recycleview.addItemDecoration(decoration);
                }
                linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                recycleview.setLayoutManager(linearLayoutManager);
                adapter.setOnClickListenerMolyo(new MolyoRecycleAdapter.OnClickListenerMolyo() {
                    @Override
                    public void OnClick(RecyclerView recyclerView, View view, int position, List<MolyoBean.BodyBean.SubjectListBean> list) {
                        String id = list.get(position).getSubId();
                        String url = MOLYO_SUBID + id;
                        Intent intent = new Intent(MainActivity.this, MolyoGoActivity.class);
                        intent.putExtra("MolyoUrl", url);
                        startActivity(intent);
                    }
                });
            }
        }
    }

    private void initGetData() {
        s1 = Integer.parseInt(molyoBean.getBody().getTotalPages());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        initLoadData(MOLYO_PATH + page);
        initListener();

    }

    private void initLoadData(String path) {
        HandlerUtils_Molyo otherHandler = new HandlerUtils_Molyo(handler);
        otherHandler.loadJstring(path);
    }

    private void initData() {

    }

    private void initListener() {

        //city的点击监听事件
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, cityActivity.class), 10);

            }
        });


        ZxingText.setOnClickListener(new View.OnClickListener() {
            //点击加载二维码
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, CaptureActivity.class), 100);

            }
        });

        //设置进度圈颜色切换
        mySwipeRefreshLayout.setColorSchemeColors(Color.GREEN, Color.RED, Color.BLACK);

        //来设置下拉刷新
        mySwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //开始刷新前设置刷新参数----true开始刷新
                                mySwipeRefreshLayout.setRefreshing(true);
                                //数据的加载
                                if (page < s) {
                                    page++;
                                    initLoadData(MOLYO_PATH + page);
                                    data.addAll(data);
                                    //设置子类的滑动
                                    mySwipeRefreshLayout.canChildScrollUp();
                                    adapter.notifyDataSetChanged();
                                    //刷新完成
                                } else {

                                    Toast.makeText(MainActivity.this, "亲,今天的么有了", Toast.LENGTH_SHORT).show();
                                }

                                mySwipeRefreshLayout.setRefreshing(false);
                            }
                        });
                    }
                }).start();
            }
        });

        recycleview.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastvisiableItem == (adapter.getItemCount() - 1)) {
                    if (page < s) {
                        page++;
                        initLoadData(MOLYO_PATH + page);
                        data.addAll(data);
                        //设置子类的滑动
                        mySwipeRefreshLayout.canChildScrollUp();
                        adapter.notifyDataSetChanged();
                        //刷新完成
                    } else {
                        Toast.makeText(MainActivity.this, "到底了", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastvisiableItem = linearLayoutManager.findLastVisibleItemPosition();
            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 10:
                String city_name = data.getExtras().getString("city");
                textView1.setText(city_name);
                break;
            case 100:
                String zxing = data.getExtras().getString("gl");
                Toast.makeText(this, "扫描完成" + zxing, Toast.LENGTH_SHORT).show();
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void initView() {

        textView1 = (TextView) findViewById(R.id.cityId);
        ZxingText = (TextView) findViewById(R.id.ZxingId);
        mySwipeRefreshLayout = (MySwipeRefreshLayout) findViewById(R.id.swipeId);
        recycleview = (RecyclerView) findViewById(R.id.molyou_recyclerViewId);
    }


}
