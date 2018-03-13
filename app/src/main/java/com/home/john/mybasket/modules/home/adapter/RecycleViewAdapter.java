package com.home.john.mybasket.modules.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.home.john.mybasket.R;
import com.home.john.mybasket.modules.common.HomeActivity;

import java.util.List;

/**
 * Created by DONGHUANG on 2017/12/31.
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ItemHolder> {

    private final Context mContext;
    private final List<String> mData;
    private ItemClickListener ClickListener;


    public RecycleViewAdapter(Context context,List<String> datas) {
        this.mContext = context;
        this.mData = datas;
    }
    public RecycleViewAdapter setClickListener(ItemClickListener ClickListener){
        this.ClickListener = ClickListener;
        return this;
    }



    public class ItemHolder extends RecyclerView.ViewHolder {

        private final TextView mText_job_name;
//        private final TextView mText_job_infore;
//        private final TextView mText_job_salary;
//        private final TextView mText_job_time;
//        private final ImageView mImg_company;
//        private final TextView mText_companyname;
//        private final TextView mText_companyinf;
          public final Button mBtn_more;


        public ItemHolder(View itemView) {
            super(itemView);
            mText_job_name = (TextView) itemView.findViewById(R.id.home_joblist_job_name);
//            mText_job_infore = (TextView) itemView.findViewById(R.id.home_joblist_job_infor);
//            mText_job_salary = (TextView) itemView.findViewById(R.id.home_joblist_salary);
//            mText_job_time = (TextView) itemView.findViewById(R.id.home_joblist_time);
//            mImg_company = (ImageView) itemView.findViewById(R.id.imageview1);
//            mText_companyname = (TextView) itemView.findViewById(R.id.home_joblist_companyname);
//            mText_companyinf = (TextView) itemView.findViewById(R.id.home_joblist_companyinformation);
              mBtn_more = (Button) itemView.findViewById(R.id.home_joblist_more);

        }

        //多种类型怎么设置
        public void setData(String data) {
            mText_job_name.setText(data);

        }
    }

    @Override
    public RecycleViewAdapter.ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.job_itme,parent,false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(RecycleViewAdapter.ItemHolder holder, final int position) {
        String data = mData.get(position);
        holder.setData(data);
        holder.mBtn_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(mContext)
                        .setItems(new String[] {"投递职位","收藏职位","举报职位"}, null)
                        .setPositiveButton("确定", null)
                        .setNeutralButton("取消", null)
                        .show();

            }
        });
        holder.mText_job_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClickListener.OnItemClick(v,position);

            }
        });

    }

    @Override
    public int getItemCount() {
        if (mData != null){
            return mData.size();
        }
        return 0;
    }

    public interface ItemClickListener{

        void OnItemClick(View view,int position);

    }
}
