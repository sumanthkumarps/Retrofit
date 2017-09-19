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

import com.effone.retrofit.R;
import com.effone.retrofit.adapter.LocationAdapter;
import com.effone.retrofit.adapter.ServiceTypeAdapter;

import com.effone.retrofit.databaseModel.Locations;
import com.effone.retrofit.databaseModel.Services;
import com.effone.retrofit.model.Location;
import com.effone.retrofit.model.LocationAndService;
import com.effone.retrofit.model.LocationsXService;
import com.effone.retrofit.model.Service;
import com.effone.retrofit.rest.ApiClient;
import com.effone.retrofit.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
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
    private Realm realm;

    Locations mLoLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLocationDetails();
        this.realm = Realm.getDefaultInstance();
        countOfServiceType=getAllService().size();
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
            realm.beginTransaction();
            com.effone.retrofit.databaseModel.Locations inventory = realm.createObject(com.effone.retrofit.databaseModel.Locations.class);

            //Adding the given name to inventory name
            inventory.setLocID(mLocation.get(i).getLocID());
            inventory.setLocName(mLocation.get(i).getLocName());
            inventory.setPhone1(mLocation.get(i).getPhone1());
            inventory.setPhone2(mLocation.get(i).getPhone2());
            inventory.setAptEndRangeDate(mLocation.get(i).getAptEndRangeDate());
            inventory.setAptStartRangeDate(mLocation.get(i).getAptStartRangeDate());
            inventory.setAdvanceBookingDays(mLocation.get(i).getAdvanceBookingDays());
            inventory.setAuditID(mLocation.get(i).getAuditID());
            inventory.setCutOffTime(mLocation.get(i).getCutOffTime());
            inventory.setFax(mLocation.get(i).getFax());
           /* inventory.setIntrinsic(mLocation.get(i).getIsIntrinsic());
            inventory.setUnUsed(mLocation.get(i).getIsUnUsed());*/
            inventory.setLongitude(mLocation.get(i).getLongitude());
            inventory.setLocationTimeZone(mLocation.get(i).getLocationTimeZone());
            inventory.setLatitude(mLocation.get(i).getLatitude());
            inventory.setOrgID(mLocation.get(i).getOrgID());
            /*inventory.setActive(mLocation.get(i).getIsActive());
            inventory.setAppointmentsForever(mLocation.get(i).getIsAppointmentsForever());*/
            inventory.setLeadTime(mLocation.get(i).getLeadTime());
            inventory.setAddressLine1(mLocation.get(i).getAddress().getAddressLine1());
            inventory.setAddressLine2(mLocation.get(i).getAddress().getAddressLine2());
            inventory.setAddressLine3(mLocation.get(i).getAddress().getAddressLine3());
            inventory.setCity(mLocation.get(i).getAddress().getCity());
            inventory.setState(mLocation.get(i).getAddress().getState());
            inventory.setZip(mLocation.get(i).getAddress().getZip());
            inventory.setCountry(mLocation.get(i).getAddress().getCountry());
            // inventory.add(inventory);
           /* realm.beginTransaction();
            realm.copyToRealm(inventory);
            realm.commitTransaction();*/
            realm.insert(inventory);
            realm.commitTransaction();
        }

      /*  for (int i = 0; i < mLocation.size(); i++) {
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

        }*/


    }
    Service mSpService;
    private List<Locations> viewRecord() {
        RealmResults<com.effone.retrofit.databaseModel.Locations> results = realm.where(com.effone.retrofit.databaseModel.Locations.class).findAll();
        List<com.effone.retrofit.databaseModel.Locations> mLocations = new ArrayList<>();
        for (com.effone.retrofit.databaseModel.Locations student : results) {
            Locations locations = new Locations();
            locations.setLocName(student.getLocName());
            mLocations.add(locations);
        }
        return mLocations;
    }

    private void gotDataFromServer() {

        try {
            insertLocationDataIntoDatabase();
            insertServiceDataIntoDatabase();
            insertLocXServDataIntoDatabase();

        }catch (Exception e){

        }

        if (countOfServiceType == 0 || countOfServiceType > 1) {
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
            LocationAdapter mLocationAdapter = new LocationAdapter(getApplicationContext(), viewRecord());

            mSpinner.setAdapter(mLocationAdapter);



            mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> arg0, View arg1,
                                           int arg2, long arg3) {

                    mLoLocation = (Locations) mSpinner.getItemAtPosition(arg2);
                }

                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                    // TODO Auto-generated method stub
                    mLoLocation = (Locations) mSpinner.getItemAtPosition(0);
                }
            });
            if (countOfServiceType > 1) {
                mServiceTypeAdapter = new ServiceTypeAdapter(this, getAllService(), getAllLocXSer());
            } else {
                // basedOnCondition();
                mServiceTypeAdapter = new ServiceTypeAdapter(this, getAllService(), getAllLocXSer());
            }
        }
        mLvServiceType.setAdapter(mServiceTypeAdapter);
        if (countOfServiceType  > 1) {
            mLvServiceType.setOnItemClickListener(this);
        } else {
            mLvServiceType.setClickable(false);
            basedOnCondition();
        }

    }

    private List<LocationsXService> getAllLocXSer() {
        RealmResults<LocationsXService> results = realm.where(LocationsXService.class).findAll();
        List<LocationsXService> mService = new ArrayList<>();
        for (LocationsXService student : results) {
            LocationsXService locationsXService = new LocationsXService();
            locationsXService.setServiceID(student.getServiceID());
            locationsXService.setLocID(student.getLocID());
            locationsXService.setLocXServiceID(student.getLocXServiceID());
            locationsXService.setAppointmentDuration(student.getAppointmentDuration());

            mService.add(locationsXService);
        }
        return mService;
    }

    private List<Service> getAllService() {
        RealmResults<Services> results = realm.where(Services.class).findAll();
        List<Service> mService = new ArrayList<>();
        for (Services student : results) {
            Service service = new Service();
            service.setServiceID(student.getServiceID());
            service.setServiceName(student.getServiceName());
            service.setDescription(student.getDescription());
            service.setDuration(student.getDuration());

            mService.add(service);
        }
        return mService;
    }


    private void insertLocXServDataIntoDatabase() {
        for (int i = 0; i < mLocationXService.size(); i++) {
            realm.beginTransaction();
            LocationsXService locationsXService = realm.createObject(LocationsXService.class);
            locationsXService.setLocXServiceID (mLocationXService.get(i).getLocXServiceID());
            locationsXService.setLocID(mLocationXService.get(i).getLocID());
            locationsXService.setServiceID (mLocationXService.get(i).getServiceID());
            realm.insert(locationsXService);
            realm.commitTransaction();
        }

    }

    private void insertServiceDataIntoDatabase() {

        for (int i = 0; i < mService.size(); i++) {
            realm.beginTransaction();
            Services services=realm.createObject(Services.class);
            services.setServiceID(mService.get(i).getServiceID());
            services.setServiceName(mService.get(i).getServiceName());
            services.setDescription(mService.get(i).getDescription());
            services.setDuration(mService.get(i).getDuration());
            services.setIsActive(mService.get(i).getIsActive());
            realm.insert(services);
            realm.commitTransaction();
        }
    }


    private void basedOnCondition() {
        mTvBookAppoin = (TextView) findViewById(R.id.tv_book_appointment);
        mTvBookAppoin.setOnClickListener(this);
    }

   @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        chcekingLocations();
        mSpService= (Service) mLvServiceType.getItemAtPosition(i);
        Intent inte = new Intent(this, AppointementBookingActivity.class);
        inte.putExtra("location", mLoLocation);
        inte.putExtra("service", mSpService);
        startActivity(inte);
    }

    private void chcekingLocations() {
        if(mLoLocation == null)
        mLoLocation = (Locations) mSpinner.getItemAtPosition(0);
    }

    @Override
    public void onClick(View view) {
        chcekingLocations();
        mSpService= (Service) mLvServiceType.getItemAtPosition(0);
        Intent inte = new Intent(this, AppointementBookingActivity.class);
        inte.putExtra("location", mLoLocation);
        inte.putExtra("service", mSpService);
        startActivity(inte);

    }

}
