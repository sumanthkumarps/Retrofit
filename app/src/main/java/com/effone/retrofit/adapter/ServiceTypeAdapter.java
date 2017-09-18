package com.effone.retrofit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.effone.retrofit.R;
import com.effone.retrofit.databaseModel.LocationXServices;
import com.effone.retrofit.databaseModel.Services;
import com.effone.retrofit.model.LocationsXService;
import com.effone.retrofit.model.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sumanth.peddinti on 8/24/2017.
 */

public class ServiceTypeAdapter extends BaseAdapter {
    private Context mContext;
    private List<Services> mAppointmentDateTime;
    private LayoutInflater mLayoutInflater ;
    private  int setVisiblity;
    private  List<LocationXServices> mLocationxService;


    public ServiceTypeAdapter(Context context, List<Services> list, List<LocationXServices> mLocationxService) {
        this.mContext=context;
        this.mAppointmentDateTime=list;
        mLayoutInflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mLocationxService=mLocationxService;


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
        View vi = view;
        final ServiceTypeItems holder;

        if(vi==null) {
            vi = mLayoutInflater.inflate(R.layout.service_type_list, null);
            holder = new  ServiceTypeItems();

            holder.mTvServiceType = (TextView)    vi.findViewById(R.id.tv_serviceType);
            holder.mTvServiceDescr=(TextView) vi.findViewById(R.id.tv_serviceDescrition);
            holder.mIvServiceTypeIcon=(ImageView)vi.findViewById(R.id.iv_appointment);
            vi.setTag( holder );
        }else
            holder = (ServiceTypeItems) vi.getTag();

        holder.mTvServiceType.setText(mAppointmentDateTime.get(position).ServiceName);
        holder.mTvServiceDescr.setText(mAppointmentDateTime.get(position).Description);
        if(mAppointmentDateTime.size() > 1 ){
            holder.mIvServiceTypeIcon.setVisibility(View.VISIBLE);
        }else
            holder.mIvServiceTypeIcon.setVisibility(View.INVISIBLE);

        return vi;
    }
    public static class ServiceTypeItems{
        public TextView mTvServiceType;
        public TextView mTvServiceDescr;
        public ImageView mIvServiceTypeIcon;
    }
}
