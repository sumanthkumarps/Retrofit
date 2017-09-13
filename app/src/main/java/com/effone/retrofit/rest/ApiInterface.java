package com.effone.retrofit.rest;

import com.effone.retrofit.model.UpCommingAppointmentModel;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by sumanth.peddinti on 9/13/2017.
 */

public interface ApiInterface {
    @GET("UserAppointment/GetUserAppointmentDetails")
    Call<UpCommingAppointmentModel> getTopRatedMovies(@Header("Token") String apiKey, @Query("orgID") int locId,
                                                      @Query("email") String email);



}
