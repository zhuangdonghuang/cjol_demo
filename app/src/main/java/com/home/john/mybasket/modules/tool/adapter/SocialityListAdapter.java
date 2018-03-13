package com.home.john.mybasket.modules.tool.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.home.john.mybasket.R;
import com.home.john.mybasket.modules.tool.bean.sociality_bean;
import com.home.john.mybasket.util.ImageLoader;

import java.util.List;


public class SocialityListAdapter extends BaseAdapter {
    private List<sociality_bean> exchangeLists;
    private LayoutInflater inflater;
    private ImageLoader imageLoader;



    public SocialityListAdapter(Context context, List<sociality_bean> exchangeLists) {
        this.exchangeLists = exchangeLists;
        inflater = LayoutInflater.from(context);
        imageLoader = ImageLoader.getInstance(context);
    }

    public SocialityListAdapter(List<sociality_bean> exchangeLists) {
        this.exchangeLists = exchangeLists;
    }

    @Override
    public int getCount() {
        return exchangeLists == null ? 0 : exchangeLists.size();
    }

    @Override
    public Object getItem(int position) {
        return exchangeLists == null ? null : exchangeLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.adapter_sociality_item, null);
            holder = new Holder();
            holder.ivIcon = (ImageView) convertView
                    .findViewById(R.id.adapter_sociality_list_icon_tv);
            holder.tvName = (TextView) convertView
                    .findViewById(R.id.adapter_sociality_list_name_tv);
            holder.tvContent = (TextView) convertView
                    .findViewById(R.id.adapter_sociality_list_content_tv);
            holder.tvDown = (TextView) convertView
                    .findViewById(R.id.adapter_sociality_list_prio_tv);

            convertView.setTag(holder);
        }
        holder = (Holder) convertView.getTag();

        sociality_bean exchangeList = exchangeLists.get(position);
        holder.tvName.setText(exchangeList.getName());
        holder.tvContent.setText("价值：" + exchangeList.getConsume() + "U币");
        holder.tvDown.setText("剩余：" + exchangeList.getRemain());

        imageLoader.displayImage(exchangeList.getIcon(), holder.ivIcon, false);
        return convertView;
    }

    class Holder {
        ImageView ivIcon;
        TextView tvName;
        TextView tvContent;
        TextView tvDown;
    }
}