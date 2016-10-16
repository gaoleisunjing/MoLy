package com.project.custom;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Toast;

/**
 * Created by gaoleideapple on 16/10/10.
 */

public class MySwipeRefreshLayout extends SwipeRefreshLayout {


    boolean isRefreshing = false;
    RecyclerView recycleview;//使用此变量设置滑动的方法
    int touchSlot = 0;//定义滑动的最小值
    float downY, lastY;
    boolean isUpto = false;


    public MySwipeRefreshLayout(Context context) {
        this(context, null);
        //获取移动最小值
        touchSlot= ViewConfiguration.getTouchSlop();
       // touchSlot = 300;
    }

    public MySwipeRefreshLayout(Context context, AttributeSet attrs) {
        //改成super
        super(context, attrs);
    }


    //来对view进行布局
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        if (recycleview == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View view = getChildAt(i);
                if (view instanceof RecyclerView) {
                    //拿到recycleview设置滑动监听
                    recycleview= (RecyclerView) view;
                }
            }
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(ev);
    }

    //事件分发
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int action=ev.getAction();

        switch (action){
            case MotionEvent.ACTION_DOWN:
                downY=ev.getY();//获取开始滑动的位置
                break;
            case MotionEvent.ACTION_UP:
                if(downY==lastY){
                    isUpto=true;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                lastY=ev.getY();
                break;
        }
        return super.dispatchTouchEvent(ev);
    }


    //提供一个方法来设置是否刷新
    public void setUpReFreshing(boolean isRefresh){

        if (isRefresh){
            isRefreshing=true;
            //在此处添加尾部视图
            Toast.makeText(getContext(), "开始刷新", Toast.LENGTH_SHORT).show();
        }else {
            isRefreshing=false;
            Toast.makeText(getContext(), "刷新结束", Toast.LENGTH_SHORT).show();
        }
    }

    //定义一个接口让外界访问  没有用到
    OnUpRefreshListener onUpRefreshListener;
    public void setOnUpRefreshListener(OnUpRefreshListener onUpRefreshListener){
        this.onUpRefreshListener=onUpRefreshListener;
    }
    public interface OnUpRefreshListener{
        void OnUpRefresh();
    }

}
