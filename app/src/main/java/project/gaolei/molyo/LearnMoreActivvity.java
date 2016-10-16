package project.gaolei.molyo;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.molyo.bean.LearnMoreBean;
import com.project.adapter.LearnMoreRecycleAdapter;
import com.project.load.HandlerUtils_MolyoLearnMore;

import java.lang.ref.WeakReference;

public class LearnMoreActivvity extends AppCompatActivity {

    String learnMore_path;
    RecyclerView recyclerView;
    LearnMoreBean data;
    LearnMoreRecycleAdapter adapter;

    private final MyHandler handler=new MyHandler(this);
    private class MyHandler extends Handler{
        WeakReference<LearnMoreActivvity> weakReference;
        public MyHandler(LearnMoreActivvity activvity){
            weakReference=new WeakReference<LearnMoreActivvity>(activvity);
        }
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==8){
                data= (LearnMoreBean) msg.obj;
                adapter=new LearnMoreRecycleAdapter(data,getApplicationContext());
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_more_activvity);
        learnMore_path=getIntent().getExtras().getString("learn_path");
        recyclerView= (RecyclerView) findViewById(R.id.learnmore_recycleId);
        initGetData();
    }

    private void initGetData() {
        HandlerUtils_MolyoLearnMore more=new HandlerUtils_MolyoLearnMore(handler);
        more.loadJstring(learnMore_path);
    }

}
