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
import android.widget.Toast;
import com.molyo.bean.MolyoGoBean;
import com.squareup.picasso.Picasso;
import java.util.List;
import project.gaolei.molyo.R;

/**
 * Created by gaoleideapple on 16/10/11.
 */

public class MolyoGoRecycleAdapter extends RecyclerView.Adapter {

    List<MolyoGoBean.BodyBean.ContentsBean> list;
    MolyoGoBean.BodyBean bodyBean;
    Context context;
    RecyclerView recyclerView;
    private int TYPE_0 = 0;
    private int TYPE_1 = 1;

    public MolyoGoRecycleAdapter(List<MolyoGoBean.BodyBean.ContentsBean> list, MolyoGoBean.BodyBean bodyBean, Context context) {
        this.list = list;
        this.bodyBean = bodyBean;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == TYPE_0) {
            CardView cardView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_molyogo_adapter, parent, false);
            return new MyViewHolder(cardView);
        }
        if (viewType == TYPE_1) {
            CardView cardView2 = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_molyogo_adapter2, parent, false);
            return new MyViewHolder2(cardView2);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof MyViewHolder) {
            String temp = bodyBean.getImage();
            ((MyViewHolder) holder).title.setText(bodyBean.getTitle());
            ((MyViewHolder) holder).subtitle.setText(bodyBean.getSubTitle());
            ((MyViewHolder) holder).descr.setText(bodyBean.getDescr());
            ((MyViewHolder) holder).image1.setTag(temp);
            ((MyViewHolder) holder).image1.setImageResource(R.mipmap.ic_launcher);
            String url = bodyBean.getImage();
            if (TextUtils.isEmpty(url) || url == null) {
                Log.d("gl", "image_url=====空空");
                Toast.makeText(context, "地址为空", Toast.LENGTH_SHORT).show();
            } else {
                if (((MyViewHolder) holder).image1.getTag() != null && ((MyViewHolder) holder).image1.getTag().equals(temp)) {
                    Picasso.with(context).load(url).error(R.mipmap.ic_launcher).into(((MyViewHolder) holder).image1);
                }
            }
        }

        if (holder instanceof MyViewHolder2) {
            String temp = list.get(position-1).getImg();
            ((MyViewHolder2) holder).title2.setText(list.get(position-1).getTitle());
            ((MyViewHolder2) holder).descr2.setText(list.get(position-1).getDescr());
            ((MyViewHolder2) holder).image2.setTag(temp);
            ((MyViewHolder2) holder).image2.setImageResource(R.mipmap.ic_launcher);
            String url = list.get(position-1).getImg();
            if (TextUtils.isEmpty(url) || url == null) {
                Log.d("gl", "image_url=====空空");
                Toast.makeText(context, "地址为空", Toast.LENGTH_SHORT).show();
            } else {
                if (((MyViewHolder2) holder).image2.getTag() != null && ((MyViewHolder2) holder).image2.getTag().equals(temp)) {
                    Picasso.with(context).load(url).error(R.mipmap.ic_launcher).into(((MyViewHolder2) holder).image2);
                }
            }
            ((MyViewHolder2) holder).button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnClick(recyclerView,v,position,bodyBean);
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {

        return position == 0 ? TYPE_0 : TYPE_1;
    }

    @Override
    public int getItemCount() {
        return list.size()+1;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView image1;
        TextView title, subtitle, descr;

        public MyViewHolder(View itemView) {
            super(itemView);
            if (itemView instanceof CardView) {
                CardView cardView = (CardView) itemView;
                image1 = (ImageView) cardView.findViewById(R.id.image_molyoGo_adpterId);
                title = (TextView) cardView.findViewById(R.id.title_molyoGo_adapterId);
                subtitle = (TextView) cardView.findViewById(R.id.subtitle_molyoGo_adapterId);
                descr = (TextView) cardView.findViewById(R.id.descr_molyoGo_adapterId);
            }

        }
    }


    class MyViewHolder2 extends RecyclerView.ViewHolder {

        ImageView image2;
        TextView title2, descr2, button;

        public MyViewHolder2(View itemView) {
            super(itemView);
            if (itemView instanceof CardView) {
                CardView cardView = (CardView) itemView;
                image2 = (ImageView) cardView.findViewById(R.id.image_molyoGo_adpter2Id);
                title2 = (TextView) cardView.findViewById(R.id.descr_molyoGo_adapter2Id);
                descr2 = (TextView) cardView.findViewById(R.id.title_molyoGo_adapter2Id);
                button = (TextView) cardView.findViewById(R.id.knowmore_molyo_adapterId);
            }
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView=recyclerView;
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.recyclerView=null;
    }

    OnClickListenerMolyoGo listener;
    public void setOnClickListenerMolyoGo(OnClickListenerMolyoGo listener){
            this.listener=listener;
    }
    public interface OnClickListenerMolyoGo{
        void OnClick(RecyclerView recyclerview,View view,int position,MolyoGoBean.BodyBean body);
    }

}
