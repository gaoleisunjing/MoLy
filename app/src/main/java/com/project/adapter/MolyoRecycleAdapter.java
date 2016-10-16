package com.project.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.molyo.bean.MolyoBean;
import com.squareup.picasso.Picasso;

import java.util.List;

import project.gaolei.molyo.R;

/**
 * Created by gaoleideapple on 16/10/10.
 */

public class MolyoRecycleAdapter extends RecyclerView.Adapter<MolyoRecycleAdapter.MyViewHolder> {

    Context context;
    List<MolyoBean.BodyBean.SubjectListBean> list;
    RecyclerView recyclerView;//用于监听的实现 下面有绑贴方式


    public MolyoRecycleAdapter(Context context, List<MolyoBean.BodyBean.SubjectListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        CardView view = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_molyu_adapter, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        String url = list.get(position).getImg();

        holder.title.setText(list.get(position).getTitle());
        holder.subtitle.setText(list.get(position).getSubTitle());
        holder.tag.setText(list.get(position).getTag());

        holder.imageView.setTag(url);
        holder.imageView.setImageResource(R.mipmap.ic_launcher);

        String imageurl = list.get(position).getImg();
        if (TextUtils.isEmpty(imageurl) || imageurl == null) {
            holder.imageView.setImageResource(R.mipmap.ic_launcher);
            Log.d("gl", "adapter=====空空空空" + imageurl);
        } else {
            if (holder.imageView.getTag() != null && holder.imageView.getTag().equals(url)) {
                Picasso.with(context).load(imageurl).error(R.mipmap.ic_launcher).into(holder.imageView);
            }
        }
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListenerMolyo.OnClick(recyclerView, v, position,list);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView title, subtitle, tag;

        public MyViewHolder(View itemView) {
            super(itemView);
            if (itemView instanceof CardView) {
                CardView view = (CardView) itemView;
                imageView = (ImageView) view.findViewById(R.id.image_molyo_adpterId);
                title = (TextView) view.findViewById(R.id.title_molyo_adapterId);
                subtitle = (TextView) view.findViewById(R.id.subtitle_molyo_adapterId);
                tag = (TextView) view.findViewById(R.id.tag_molyo_adapterId);
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

    OnClickListenerMolyo onClickListenerMolyo;

    public void setOnClickListenerMolyo(OnClickListenerMolyo onClickListenerMolyo) {
        this.onClickListenerMolyo = onClickListenerMolyo;
    }

    public interface OnClickListenerMolyo {
        void OnClick(RecyclerView recyclerView, View view, int position,List<MolyoBean.BodyBean.SubjectListBean> list);
    }
}
