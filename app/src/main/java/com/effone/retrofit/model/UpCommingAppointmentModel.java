package com.effone.retrofit.model;

/**
 * Created by sumanth.peddinti on 9/13/2017.
 */

public class UpCommingAppointmentModel {

    private String StatusCode;

    private Result[] Result;

    public String getStatusCode ()
    {
        return StatusCode;
    }

    public void setStatusCode (String StatusCode)
    {
        this.StatusCode = StatusCode;
    }

    public Result[] getResult ()
    {
        return Result;
    }

    public void setResult (Result[] Result)
    {
        this.Result = Result;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [StatusCode = "+StatusCode+", Result = "+Result+"]";
    }
}
