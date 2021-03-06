package com.effone.retrofit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.effone.retrofit.R;
import com.effone.retrofit.databaseModel.Locations;

import java.util.List;

/**
 * Created by sumanth.peddinti on 9/13/2017.
 */

public class LocationAdapter  extends BaseAdapter {
    Context context;
    List<Locations> mLocatin;
    LayoutInflater inflter;
    public LocationAdapter(Context context, List<Locations> mLocation) {
        this.context=context;
        this.mLocatin = mLocation;
        inflter = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return mLocatin.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.date_time_slot, null);
        TextView names = (TextView) view.findViewById(R.id.ad_tv_date_time);

        names.setText(mLocatin.get(i).getLocName());
        return view;
    }
}
