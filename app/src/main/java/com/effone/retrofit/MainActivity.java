package com.effone.retrofit;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.effone.retrofit.activity.AppointmentDetailsActivity;
import com.effone.retrofit.activity.AppointmentHistoryActivity;
import com.effone.retrofit.activity.LocationServiceActivity;
import com.effone.retrofit.adapter.UpCommingAppointmentAdapter;
import com.effone.retrofit.model.Result;
import com.effone.retrofit.model.UpCommingAppointmentModel;
import com.effone.retrofit.rest.ApiClient;
import com.effone.retrofit.rest.ApiInterface;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {
    private static final String TAG = "";
    private ListView mLvAppo;
    private UpCommingAppointmentAdapter upCommingAppointmentAdapter;

    private TextView mTvBookingAppiontemnt, mTvHistory, mTvContactUs, mTvAboutUsText, mTvDateTime;
    private TextView mImgIcon;
    private Calendar mCalendar;
    private ImageView mIvBackBtn;
    private TextView mTvTitle;
    private String formattedDate;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCalendar = Calendar.getInstance();
        mLvAppo = (ListView) findViewById(R.id.lv_upcomingAppointent);
        upcomingAppointmentList();
        declarations();
        Realm.init(this);
        realm = Realm.getDefaultInstance();
        mLvAppo.setOnItemClickListener(this);
    }




    private void declarations() {
        mTvBookingAppiontemnt = (TextView) findViewById(R.id.tv_booking_app);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mIvBackBtn = (ImageView) findViewById(R.id.iv_back_btn);
        mIvBackBtn.setVisibility(View.GONE);
        mTvTitle.setText(getString(R.string.app_name));
        mTvContactUs = (TextView) findViewById(R.id.tv_contact_us);
        mTvHistory = (TextView) findViewById(R.id.tv_history);
        mTvAboutUsText = (TextView) findViewById(R.id.tv_about_text);
        mImgIcon = (TextView) findViewById(R.id.tv_comapany_name);
        mTvDateTime = (TextView) findViewById(R.id.tv_dateandtime);
        mTvBookingAppiontemnt.setOnClickListener(this);
        mTvHistory.setOnClickListener(this);
        mTvContactUs.setOnClickListener(this);
        settingData();
        settingAboutUs();

    }

    private void upcomingAppointmentList() {
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<UpCommingAppointmentModel> call = apiService.getUpCommingAppointmentDetails(getString(R.string.token), 1, "naveed.farooqui@effone.com");
        call.enqueue(new Callback<UpCommingAppointmentModel>() {
            @Override
            public void onResponse(Call<UpCommingAppointmentModel> call, Response<UpCommingAppointmentModel> response) {
                Result[] movies = response.body().getResult();
                List<Result> data = Arrays.asList(movies);
                upCommingAppointmentAdapter = new UpCommingAppointmentAdapter(MainActivity.this, data);


                mLvAppo.setAdapter(upCommingAppointmentAdapter);
            }

            @Override
            public void onFailure(Call<UpCommingAppointmentModel> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }


    private void settingData() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(mCalendar.getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        Date d = new Date();
        String dayOfTheWeek = sdf.format(d);
        if (formattedDate.contains("-")) {
            // Split it.
            String[] parts = formattedDate.split("-");
            String dayName = parts[0] + " " + parts[1] + " " + parts[2] + " " + "<font color='#0F3F7B'>" + dayOfTheWeek + "</font>";
            mTvDateTime.setText(Html.fromHtml(dayName));
        } else {
            throw new IllegalArgumentException("String " + formattedDate + " does not contain -");
        }

        Log.e("MainActivity", formattedDate + " " + dayOfTheWeek);
    }

    public void openActivity(Context context, Class<?> calledActivity) {
        Intent intent = new Intent(context, calledActivity);
        startActivity(intent);
    }


    private void settingAboutUs() {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Result results = (Result) mLvAppo.getItemAtPosition(i);
        Intent intent = new Intent(this, AppointmentDetailsActivity.class);
        intent.putExtra("selectedItem", results);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_booking_app:
                openActivity(this, LocationServiceActivity.class);
                break;
            case R.id.tv_history:
                openActivity(this, AppointmentHistoryActivity.class);
                break;
        }
    }

}
