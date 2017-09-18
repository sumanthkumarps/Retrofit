package com.effone.retrofit.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.effone.retrofit.R;
import com.effone.retrofit.model.Time;
import com.effone.retrofit.model.TimeSlotStrings;
import com.effone.retrofit.model.TimeSlots;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Created by sumanth.peddinti on 9/13/2017.
 */

public class TimeSlotAdapter  extends BaseAdapter {
    private Context mContext;
    private ArrayList<TimeSlotStrings> web;
    private String formattedDate;


    public TimeSlotAdapter(Context c, ArrayList<TimeSlotStrings> web ) {
        mContext = c;
        this.web = web;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return web.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_single, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm aa", Locale.US);
            DateFormat timeFormat = new SimpleDateFormat("hh:mm aa", Locale.US);

            try {
                formattedDate = timeFormat.format(dateFormat.parse(web.get(position).getStartTime()));
                textView.setText(formattedDate);
            } catch (Exception e) {
                Log.e("DATE", "" + e);
            }






        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}
