package com.effone.retrofit.adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.effone.retrofit.R;
import com.effone.retrofit.model.Result;
import com.effone.retrofit.model.UpCommingAppointmentModel;

import java.util.List;

import retrofit2.Callback;

/**
 * Created by sumanth.peddinti on 9/13/2017.
 */

public class UpCommingAppointmentAdapter extends BaseAdapter {
    private  Context mContext;
    private List<Result> mAppointmentDateTime;
    private LayoutInflater mLayoutInflater ;
    public UpCommingAppointmentAdapter(Context context, List<Result> data) {
        mContext=context;
        this.mAppointmentDateTime=data;

        mLayoutInflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    }

    @Override
    public int getCount() {
        return mAppointmentDateTime.size();
    }

    @Override
    public Object getItem(int i) {
        return mAppointmentDateTime.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View vi=view ;
        final AppointmentListItems holder;
        if(vi==null) {
            vi = mLayoutInflater.inflate(R.layout.date_time_slot, null);
            holder=new AppointmentListItems();
            holder.mTvDateTime= (TextView) vi.findViewById(R.id.ad_tv_date_time);
            vi.setTag(holder);

        }else
            holder = (AppointmentListItems) vi.getTag();


        holder.mTvDateTime.setText(Html.fromHtml(mAppointmentDateTime.get(position).getAppointmentDateTime()));

        return vi;
    }

    public static class AppointmentListItems{
        public TextView mTvDateTime;

    }
}
