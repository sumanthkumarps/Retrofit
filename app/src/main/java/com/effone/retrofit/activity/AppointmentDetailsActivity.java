package com.effone.retrofit.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


import com.effone.retrofit.R;
import com.effone.retrofit.model.Result;

public class AppointmentDetailsActivity extends AppCompatActivity {
    private Result mAppointmentDateTime;
    private TextView mTvConfirmationId,mTvEmail,mTvUserName,mTvAppointmentID,mTvTitle,
    mTvLocName,mTvServiceName,mTvAppointmentDateTime,mTvScheduledTimeZone,mTvAddress;
    private Toolbar toolbar;
    private ImageView mIvBackBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_details);
     /*   toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setTitle(getString(R.string.upcomingAppointment));*/
        mAppointmentDateTime = (Result) getIntent().getSerializableExtra("selectedItem");
        getUpComingAppointmentList();
    }

    private void getUpComingAppointmentList() {
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mTvTitle.setText(getString(R.string.upcomingAppointment));
        mIvBackBtn = (ImageView) findViewById(R.id.iv_back_btn);
        mTvConfirmationId=(TextView)findViewById(R.id.tv_confimration);
        mTvEmail=(TextView)findViewById(R.id.tv_email);
        mTvUserName=(TextView)findViewById(R.id.tv_userName);
        mTvLocName=(TextView)findViewById(R.id.tv_locName);
        mTvAppointmentID=(TextView)findViewById(R.id.tv_appointment_id);
        mTvServiceName=(TextView)findViewById(R.id.tv_serviceName);
        mTvAppointmentDateTime=(TextView)findViewById(R.id.tv_appointment_date);
        mTvScheduledTimeZone=(TextView)findViewById(R.id.tv_timeZone);
        mTvAddress=(TextView)findViewById(R.id.tv_address);
        settingValues();
    }

    private void settingValues() {
        mTvConfirmationId.setText(mAppointmentDateTime.getConfirmationNo());
        mTvAppointmentID.setText(mAppointmentDateTime.getAppointmentID());
        mTvLocName.setText(mAppointmentDateTime.getLocName());
        mTvUserName.setText(mAppointmentDateTime.getUserName());
        mTvEmail.setText(mAppointmentDateTime.getEmail());
        mTvServiceName.setText(mAppointmentDateTime.getServiceName());
        mTvAppointmentDateTime.setText(Html.fromHtml(mAppointmentDateTime.getAppointmentDateTime()));
        mTvScheduledTimeZone.setText(mAppointmentDateTime.getScheduledTimeZone());
        mTvAddress.setText("");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }
        return super.onOptionsItemSelected(item);
    }
}
