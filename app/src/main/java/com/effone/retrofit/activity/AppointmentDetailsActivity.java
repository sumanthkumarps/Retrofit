package com.effone.retrofit.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.effone.retrofit.R;
import com.effone.retrofit.model.AppointmentBookingModel;
import com.effone.retrofit.model.Result;
import com.effone.retrofit.rest.ApiClient;
import com.effone.retrofit.rest.ApiInterface;

import org.json.JSONObject;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

public class AppointmentDetailsActivity extends AppCompatActivity {
    private static final String TAG ="" ;
    private Result mAppointmentDateTime;
    private TextView mTvConfirmationId,mTvEmail,mTvUserName,mTvAppointmentID,mTvTitle,
    mTvLocName,mTvServiceName,mTvAppointmentDateTime,mTvScheduledTimeZone,mTvAddress;
    private Toolbar toolbar;
    private ImageView mIvBackBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_details);
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
        postingData();
    }

    private void postingData() {

        AppointmentBookingModel body = new AppointmentBookingModel();
        body.setAppointmentID("0");
        body.setLocID("1");
        body.setUserID("6");
        body.setConfirmationNo("0");
        body.setAppointmentTypeRefID("27");
        body.setServiceID("2");
        body.setStartTime("9/13/2017 3:30:00 PM");
        body.setEndTime("9/13/2017 4:00:00 PM");
        body.setDuration("30");
        body.setScheduledTimeZone("India Standard Time");
        body.setSendEmailReminder("0");
        body.setSendTextReminder("0");
        body.setAdditionalEmail("");
        body.setIsLoggedIn("0");
        body.setIsCheckedIn("0");
        body.setIsCancelled("0");
        body.setCancelTypeRefID("null");
        body.setCancelledBy("null");
        body.setIsAssigned("0");
        body.setAssignedTo("null");
        body.setAuditID("6");

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        Call<AppointmentBookingModel> response = apiService.createAppointment(getString(R.string.token), body);
        response.enqueue(new Callback<AppointmentBookingModel>()
        {
            @Override
            public void onResponse(Call<AppointmentBookingModel> call, retrofit2.Response<AppointmentBookingModel> rawResponse)
            {
                try
                {
                    Toast.makeText(AppointmentDetailsActivity.this,"done"+ rawResponse.toString(),Toast.LENGTH_SHORT).show();
                    //get your response....
                    Log.d(TAG, "RetroFit2.0 :RetroGetLogin: " + rawResponse.toString());
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<AppointmentBookingModel> call, Throwable throwable)
            {
                // other stuff...
                Log.d(TAG, "RetroFit2.0 :RetroGetLogin: " + throwable.toString());
            }
        });
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
        mTvAddress.setText(mAppointmentDateTime.getAppointmentTypeRefID());
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
