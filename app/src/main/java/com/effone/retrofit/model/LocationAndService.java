package com.effone.retrofit.model;

/**
 * Created by sumanth.peddinti on 9/13/2017.
 */

public class LocationAndService {
    private int StatusCode;

    public int getStatusCode() { return this.StatusCode; }

    public void setStatusCode(int StatusCode) { this.StatusCode = StatusCode; }

    private com.effone.retrofit.model.LocationServicesss.Result Result;

    public com.effone.retrofit.model.LocationServicesss.Result getResult() { return this.Result; }

    public void setResult(com.effone.retrofit.model.LocationServicesss.Result Result) { this.Result = Result; }
}
