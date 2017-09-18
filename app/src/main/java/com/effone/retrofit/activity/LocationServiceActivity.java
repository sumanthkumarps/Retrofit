package com.effone.retrofit.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSpinner;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Model;
import com.activeandroid.query.Select;

import com.effone.retrofit.Locations;
import com.effone.retrofit.R;
import com.effone.retrofit.adapter.LocationAdapter;
import com.effone.retrofit.adapter.ServiceTypeAdapter;

import com.effone.retrofit.databaseModel.LocationXServices;
import com.effone.retrofit.databaseModel.Services;
import com.effone.retrofit.model.Location;
import com.effone.retrofit.model.LocationAndService;
import com.effone.retrofit.model.LocationsXService;
import com.effone.retrofit.model.Service;
import com.effone.retrofit.rest.ApiClient;
import com.effone.retrofit.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sumanth.peddinti on 9/13/2017.
 */

public class LocationServiceActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {

    private static final String TAG = "LocationServiceActivity";
    private ListView mLvServiceType;
    private TextView mTvTitle, mTvBookAppoin;
    private ServiceTypeAdapter mServiceTypeAdapter;
    private AppCompatSpinner mSpinner;
    private ArrayList<Location> mLocation;
    private ArrayList<Service> mService;
    private ArrayList<LocationsXService> mLocationXService;
    private int countOfServiceType = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getLocationDetails();


    }

    private void getLocationDetails() {
        final int[] count = {0};
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<LocationAndService> call = apiService.getLocationNService(getString(R.string.token), 1);
        call.enqueue(new Callback<LocationAndService>() {
            @Override
            public void onResponse(Call<LocationAndService> call, Response<LocationAndService> response) {
                com.effone.retrofit.model.LocationServicesss.Result locationAndService = response.body().getResult();
                mLocation = locationAndService.getLocations();
                mService = locationAndService.getServices();
                mLocationXService = locationAndService.getLocationsXServices();


                gotDataFromServer();
            }

            @Override
            public void onFailure(Call<LocationAndService> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });

    }

    private void insertLocationDataIntoDatabase() {
        for (int i = 0; i < mLocation.size(); i++) {
            //If name is not blank creating a new Inventory object
            Locations inventory = new Locations();
            //Adding the given name to inventory name
            inventory.LocID = mLocation.get(i).getLocID();
            inventory.LocName=mLocation.get(i).getLocName();
            inventory.Phone1=mLocation.get(i).getPhone1();
            inventory.Phone2=mLocation.get(i).getPhone2();
            inventory.AptEndRangeDate=mLocation.get(i).getAptEndRangeDate();
            inventory.AptStartRangeDate=mLocation.get(i).getAptStartRangeDate();
            inventory.AdvanceBookingDays=mLocation.get(i).getAdvanceBookingDays();
            inventory.AuditID=mLocation.get(i).getAuditID();
            inventory.CutOffTime=mLocation.get(i).getCutOffTime();
            inventory.Fax=mLocation.get(i).getFax();
            inventory.IsIntrinsic=mLocation.get(i).getIsIntrinsic();
            inventory.IsUnUsed=mLocation.get(i).getIsUnUsed();
            inventory.Longitude=mLocation.get(i).getLongitude();
            inventory.LocationTimeZone=mLocation.get(i).getLocationTimeZone();
            inventory.Latitude=mLocation.get(i).getLatitude();
            inventory.OrgID=mLocation.get(i).getOrgID();
            inventory.IsActive=mLocation.get(i).getIsActive();
            inventory.IsAppointmentsForever=mLocation.get(i).getIsAppointmentsForever();
            inventory.LeadTime=mLocation.get(i).getLeadTime();
            inventory.AddressLine1=mLocation.get(i).getAddress().getAddressLine1();
            inventory.AddressLine2=mLocation.get(i).getAddress().getAddressLine2();
            inventory.AddressLine3=mLocation.get(i).getAddress().getAddressLine3();
            inventory.City=mLocation.get(i).getAddress().getCity();
            inventory.State=mLocation.get(i).getAddress().getState();
            inventory.Zip=mLocation.get(i).getAddress().getZip();
            inventory.Country=mLocation.get(i).getAddress().getCountry();
            //Saving name to sqlite database
            inventory.save();

        }


    }

    private void gotDataFromServer() {
        ActiveAndroid.beginTransaction();
        try {
            insertLocationDataIntoDatabase();
            insertServiceDataIntoDatabase();
            insertLocXServDataIntoDatabase();
            ActiveAndroid.setTransactionSuccessful();
        }finally {
            ActiveAndroid.endTransaction();
        }


        if (mService == null || mService.size() > 1) {
            setContentView(R.layout.activity_location_service);
        } else {
            setContentView(R.layout.location_service2);
        }

        mLvServiceType = (ListView) findViewById(R.id.lv_service_type);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mTvTitle.setText(getString(R.string.service_type));
        mSpinner = (AppCompatSpinner) findViewById(R.id.sp_location);

        if (mLocation != null) {
            ArrayList<String> locations = new ArrayList<>();
            LocationAdapter mLocationAdapter = new LocationAdapter(getApplicationContext(), getAllLocation());

            mSpinner.setAdapter(mLocationAdapter);
            if (countOfServiceType > 1) {
                mServiceTypeAdapter = new ServiceTypeAdapter(this, getAllService(), getAllLocXSer());
            } else {
                // basedOnCondition();
                mServiceTypeAdapter = new ServiceTypeAdapter(this,  getAllService(), getAllLocXSer());
            }
        }
        mLvServiceType.setAdapter(mServiceTypeAdapter);
        if (mService == null || mService.size() > 1) {
            mLvServiceType.setOnItemClickListener(this);
        } else {
            mLvServiceType.setClickable(false);
            basedOnCondition();
        }

    }

    private List<LocationXServices> getAllLocXSer() {
        return new Select()
                .from(LocationXServices.class)
                .execute();
    }

    private List<Services> getAllService() {
        return new Select()
                .from(Services.class)
                .execute();
    }

    private void insertLocXServDataIntoDatabase() {
        for(int i=0;i<mLocationXService.size();i++){
            LocationXServices locationsXService=new LocationXServices();
            locationsXService.LocXServiceID=mLocationXService.get(i).getLocXServiceID();
            locationsXService.LocId=mLocationXService.get(i).getLocID();
            locationsXService.ServiceID=mLocationXService.get(i).getServiceID();
            locationsXService.save();
        }

    }

    private void insertServiceDataIntoDatabase() {

        for(int i=0;i<mService.size();i++) {
            Services service=new Services();
            service.ServiceID = mService.get(i).getServiceID();
            service.ServiceName=mService.get(i).getServiceName();
            service.Description=mService.get(i).getDescription();
            service.Duration=mService.get(i).getDuration();
            service.IsActive=mService.get(i).getIsActive();
            service.save();
        }
    }

    private List<Locations> getAllLocation() {
        //Getting all items stored in Inventory table
        return new Select()
                .from(Locations.class)
                .execute();
    }

    private void basedOnCondition() {
        mTvBookAppoin = (TextView) findViewById(R.id.tv_book_appointment);
        mTvBookAppoin.setOnClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Service mSpService = (Service) mLvServiceType.getItemAtPosition(i);
        Location mLoLocation = (Location) mSpinner.getItemAtPosition(i);
        Intent inte = new Intent(this, AppointementBookingActivity.class);
        inte.putExtra("location", mLoLocation);
        inte.putExtra("service", mSpService);
        startActivity(inte);
    }

    @Override
    public void onClick(View view) {
        Intent inte = new Intent(this, AppointementBookingActivity.class);
        startActivity(inte);
    }
}
