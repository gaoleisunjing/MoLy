package com.project.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.molyo.bean.CityBean;
import com.squareup.picasso.Picasso;

import java.util.List;

import project.gaolei.molyo.R;

/**
 * Created by gaoleideapple on 16/10/9.
 */

public class CityBaseAdapter extends BaseAdapter {


    List<CityBean.BodyBean.ListBean> listBeen;
    Context context;

    public CityBaseAdapter(List<CityBean.BodyBean.ListBean> listBeen, Context context) {
        this.listBeen = listBeen;
        this.context = context;
    }

    @Override
    public int getCount() {

        if (listBeen != null) {
            Log.d("gl","====getCount");
            return listBeen.size();
        } else {
            Log.d("gl","getCount=======000000");
            return 0;
        }


    }

    @Override
    public Object getItem(int position) {
        return listBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MyViewHolder viewHolder;

        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_city_adapter,parent,false);
            viewHolder=new MyViewHolder();
            viewHolder.textView= (TextView) convertView.findViewById(R.id.textview_cityId);
            viewHolder.imageView= (ImageView) convertView.findViewById(R.id.image_cityId);

            convertView.setTag(viewHolder);
        }else {

            viewHolder= (MyViewHolder) convertView.getTag();
        }


        String title=listBeen.get(position).getName();
        String imageUrl=listBeen.get(position).getImg();
        viewHolder.textView.setText(title);
        Picasso.with(context).load(imageUrl).error(R.mipmap.ic_launcher).into(viewHolder.imageView);

        return convertView;
    }


    class MyViewHolder {
        ImageView imageView;
        TextView textView;

    }
}
