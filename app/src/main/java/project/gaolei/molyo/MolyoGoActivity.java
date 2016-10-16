package project.gaolei.molyo;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.molyo.bean.MolyoGoBean;
import com.project.adapter.MolyoGoRecycleAdapter;
import com.project.custom.MyRecycleSpaceItemDecoration;
import com.project.load.HandlerUtils_Molyo;
import com.project.load.HandlerUtils_MolyoGO;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class MolyoGoActivity extends AppCompatActivity {


    private Button button;
    private RecyclerView recyclerView;
    MolyoGoBean molyoGoBean;
    List<MolyoGoBean.BodyBean.ContentsBean> datago=new ArrayList<>();
    MolyoGoBean.BodyBean bodyBean;
    MolyoGoRecycleAdapter molyoGoRecycleAdapter;
    String Path_Details="http://www.molyo.com//mShop/getInfoV1_7?id=";

    private final MyHandler handler=new MyHandler(this);
    private class MyHandler extends Handler{
        WeakReference<MolyoGoActivity> weakReference;
        public MyHandler(MolyoGoActivity activity){
            weakReference=new WeakReference<MolyoGoActivity>(activity);
        }
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==3){
                molyoGoBean= (MolyoGoBean) msg.obj;
                if(molyoGoBean!=null){
                    bodyBean=molyoGoBean.getBody();
                    datago=molyoGoBean.getBody().getContents();
                    molyoGoRecycleAdapter=new MolyoGoRecycleAdapter(datago,bodyBean,getApplicationContext());
                    recyclerView.setAdapter(molyoGoRecycleAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
                    MyRecycleSpaceItemDecoration decoration=new MyRecycleSpaceItemDecoration(4);
                    recyclerView.addItemDecoration(decoration);
                    molyoGoRecycleAdapter.setOnClickListenerMolyoGo(new MolyoGoRecycleAdapter.OnClickListenerMolyoGo() {
                        @Override
                        public void OnClick(RecyclerView recyclerview, View view, int position, MolyoGoBean.BodyBean body) {
                            //position是从1开始的
                            String id=body.getContents().get(position-1).getBusinessId();
                            String url=Path_Details+id;
                            String title=body.getContents().get(position-1).getTitle();
                            Intent intent=new Intent(MolyoGoActivity.this,MolyoGoDetailsActivity.class);
                            intent.putExtra("detailsId",id);
                            intent.putExtra("detailsUrl",url);
                            intent.putExtra("detailsTitle",title);
                            startActivity(intent);
                        }
                    });
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_molyo_go);
        initView();
        String url=getIntent().getExtras().getString("MolyoUrl");
        initLoadData(url);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initView() {
        button = (Button)findViewById(R.id.button_text_Id);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView_MolyoGoId);
    }

    private void initLoadData(String path) {
        HandlerUtils_MolyoGO otherHandler = new HandlerUtils_MolyoGO(handler);
        otherHandler.loadJstring(path);
    }
}
