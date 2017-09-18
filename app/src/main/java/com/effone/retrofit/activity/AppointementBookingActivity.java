package com.effone.retrofit.activity;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;

import android.os.Build;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.effone.retrofit.R;
import com.effone.retrofit.adapter.TimeSlotAdapter;
import com.effone.retrofit.model.AppointmentBookingModel;
import com.effone.retrofit.model.DateTime;
import com.effone.retrofit.model.Time;
import com.effone.retrofit.model.TimeSlotStrings;
import com.effone.retrofit.rest.ApiClient;
import com.effone.retrofit.rest.ApiInterface;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutionException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppointementBookingActivity extends AppCompatActivity {
    private static final String TAG = "";
    private String[] arraySpinner;
    private Calendar myCalendar;
    private EditText mEtDate;
    private GridView mGvTimeSlots;
    private TextView mTvSubmit;
    private TextView mTvTitle;
    private ArrayList<Time> movies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointement_booking);
        myCalendar = Calendar.getInstance();
        this.arraySpinner = new String[]{
                " ", "Mr", "Miss", "Ms", "Mrs", "Dr"
        };
        mGvTimeSlots = (GridView) findViewById(R.id.gv_timeSlots);
        declarations();
    }

    private void settingDataIntoGrid(String Date) {
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<DateTime> call = apiService.getDateTimeSlots(getString(R.string.token),2,2,"09/15/2017","India Standard Time");
        call.enqueue(new Callback<DateTime>() {
            @Override
            public void onResponse(Call<DateTime> call, Response<DateTime> response) {
                try {
                    movies = response.body().getResult();
                    if (movies.size() > 0 && movies.get(0).getTimeSlotStrings().size() != 0) {
                        TimeSlotAdapter adapter = new TimeSlotAdapter(AppointementBookingActivity.this, movies.get(0).getTimeSlotStrings());
                        mGvTimeSlots.setAdapter(adapter);
                    } else {
                        Toast.makeText(AppointementBookingActivity.this, "No Time SLots", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e) {
                    Log.e(TAG, e.getMessage());

                }
            }

            @Override
            public void onFailure(Call<DateTime>call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }


    private void declarations() {
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {


            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };
        java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("MM/dd/yyyy");
        String formattedDate = df.format(myCalendar.getTime());
        mEtDate = (EditText) findViewById(R.id.et_date);
        mTvTitle=(TextView)findViewById(R.id.tv_title);
        mTvTitle.setText(getString(R.string.booking_app));
        mTvSubmit=(TextView)findViewById(R.id.tv_submit);
        mTvSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           //     openActivity(AppointementBookingActivity.this, AppointmentAcknowledgementActivity.class);
            }
        });
        mEtDate.setText(formattedDate);
        settingDataIntoGrid(formattedDate);
        mEtDate.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                new DatePickerDialog(AppointementBookingActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }


    private void updateLabel() {
        String myFormat = "MM/dd/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        mEtDate.setText(sdf.format(myCalendar.getTime()));
        settingDataIntoGrid(sdf.format(myCalendar.getTime()));
    }

}
