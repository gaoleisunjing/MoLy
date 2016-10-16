package com.project.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.molyo.bean.LearnMoreBean;
import com.squareup.picasso.Picasso;

import project.gaolei.molyo.CollectionActivity;
import project.gaolei.molyo.ExperienceActivity;
import project.gaolei.molyo.LearnMoreActivvity;
import project.gaolei.molyo.R;

/**
 * Created by gaoleideapple on 16/10/12.
 */

public class LearnMoreRecycleAdapter extends RecyclerView.Adapter<LearnMoreRecycleAdapter.MyViewHolder> {

    LearnMoreBean list;
    Context context;
    RecyclerView recyclerView;

    public LearnMoreRecycleAdapter(LearnMoreBean list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_learnmore_adapter, parent, false);

        return new MyViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        Picasso.with(context).load(list.getBody().getList().get(position).getUserImg()).error(R.mipmap.ic_launcher).into(holder.user_image);
        Picasso.with(context).load(list.getBody().getList().get(position).getImg()).error(R.mipmap.ic_launcher).into(holder.toltal_imgae);
        holder.user_name.setText(list.getBody().getList().get(position).getUserName());
        holder.creatTime.setText(list.getBody().getList().get(position).getCreateTime());
        holder.desc.setText(list.getBody().getList().get(position).getDesc());

        holder.user_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击会跳到单个用户用户界面    "user_path"  http://www.molyo.com//mMember/getInfoV1_7?accessToken=&userId=  userId
                Intent intent=new Intent(context, CollectionActivity.class);
                intent.putExtra("user_path","http://www.molyo.com//mMember/getInfoV1_7?accessToken=&userId="+list.getBody().getList().get(position).getUserId());
                context.startActivity(intent);
            }
        });

        holder.toltal_imgae.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击跳到了单个体验的activity  "experience_path"  http://www.molyo.com//mExperience/getInfo?id=   +getId
                Intent intent=new Intent(context, ExperienceActivity.class);
                intent.putExtra("experience_path","http://www.molyo.com//mExperience/getInfo?id="+list.getBody().getList().get(position).getId());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.getBody().getList().size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        //还有评论和点赞的俩个textview没有写
        ImageView user_image, toltal_imgae;
        TextView user_name, creatTime, desc;

        public MyViewHolder(View itemView) {
            super(itemView);
            if (itemView instanceof CardView) {
                CardView cardView = (CardView) itemView;
                user_image = (ImageView) cardView.findViewById(R.id.learnmore_imageUser_Id);
                toltal_imgae = (ImageView) cardView.findViewById(R.id.learnmore_image_Id);
                user_name = (TextView) cardView.findViewById(R.id.learnmore_userName_Id);
                creatTime = (TextView) cardView.findViewById(R.id.learnmore_creatTime_Id);
                desc = (TextView) cardView.findViewById(R.id.learnmore_desc_Id);

            }
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.recyclerView = null;
    }

    //可能不会用到这俩个监听方法
    OnLearnMoreClickListenerImage listener1;
    public void setOnLearnMoreClickListenerImage(OnLearnMoreClickListenerImage listener) {
        this.listener1 = listener;
    }
    public interface OnLearnMoreClickListenerImage {
        void OnClick(RecyclerView recyclerView, View view, LearnMoreBean data, int position);
    }

    OnLearnMoreClickListenerUser listener;
    public void setOnLearnMoreClickListenerUser(OnLearnMoreClickListenerUser listener) {
        this.listener = listener;
    }
    public interface OnLearnMoreClickListenerUser {
        void OnClick(RecyclerView recyclerView, View view, LearnMoreBean data, int position);
    }
}
