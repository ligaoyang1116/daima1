package com.gy.lgy20190102.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gy.lgy20190102.R;
import com.gy.lgy20190102.bean.LgyBean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class ShouYeAdapter extends BaseAdapter {
    Context context;
    List<LgyBean.DataBean.TuijianBean.ListBeanX> list;
    private TextView sy_t1;
    private TextView sy_t2;
    private ImageView sy_img1;

    public ShouYeAdapter(Context context, List<LgyBean.DataBean.TuijianBean.ListBeanX> list) {
        this.context = context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Viewholder holder=null;
        if (convertView==null){
            holder=new Viewholder();
            convertView=View.inflate(context, R.layout.sy_iteam,null);
            sy_t1 = holder.tee1 = convertView.findViewById(R.id.sy_t1);
            sy_t2 = holder.tee1 = convertView.findViewById(R.id.sy_t2);
            sy_img1 = holder.imgee = convertView.findViewById(R.id.sy_img1);
            convertView.setTag(holder);
        }else {
            holder= (Viewholder) convertView.getTag();
        }
        sy_t1.setText(list.get(position).getTitle());
        sy_t2.setText("￥"+list.get(position).getBargainPrice());
        ImageLoader.getInstance().displayImage(list.get(position).getImages(),holder.imgee);
        return convertView;
    }
    //viewholder
    class Viewholder{
        ImageView imgee;
        TextView tee1,tee2;
    }
}
