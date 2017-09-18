package com.effone.retrofit.rest;

import com.effone.retrofit.model.AppointmentBookingModel;
import com.effone.retrofit.model.DateTime;
import com.effone.retrofit.model.LocationAndService;
import com.effone.retrofit.model.UpCommingAppointmentModel;

import java.util.Date;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by sumanth.peddinti on 9/13/2017.
 */

public interface ApiInterface {
    @GET("UserAppointment/GetUserAppointmentDetails")
    Call<UpCommingAppointmentModel> getUpCommingAppointmentDetails(@Header("Token") String apiKey, @Query("orgID") int locId,
                                                      @Query("email") String email);

    @Headers("Content-type: application/json")
    @POST("Appointment/ManageAppointment")
    Call<AppointmentBookingModel> createAppointment(@Header("Token") String apiKey, @Body AppointmentBookingModel mAppointmentBookingModel);

    @GET("Appointment/GetLocationsNServices")
    Call<LocationAndService> getLocationNService(@Header("Token") String apiKey, @Query("orgID") int locId);

    @GET("Appointment/GetAppointmentSlots")
    Call<DateTime> getDateTimeSlots(@Header("Token") String apiKey, @Query("locId") int locId,
                                    @Query("serviceId") int serviceId, @Query("startTime") String date, @Query("localTimeZone") String timeZone);



}
