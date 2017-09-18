package com.effone.retrofit.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;


import com.effone.retrofit.R;

import java.util.ArrayList;

public class AppointmentHistoryActivity extends AppCompatActivity {
    private TextView mTvTitle;
    private ListView mLvAppointmentHistoryList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_history);
        init();
    }

    private void init() {
        mTvTitle=(TextView)findViewById(R.id.tv_title);
        mTvTitle.setText(getString(R.string.appointment_history));
        mLvAppointmentHistoryList=(ListView)findViewById(R.id.lv_appointment_history);


    }
}
