package com.effone.retrofit.model.LocationServicesss;

import com.effone.retrofit.model.Location;
import com.effone.retrofit.model.LocationsXService;
import com.effone.retrofit.model.Service;

import java.util.ArrayList;

/**
 * Created by sumanth.peddinti on 9/13/2017.
 */

public class Result {
    public ArrayList<Location> Locations;

    public ArrayList<Location> getLocations() { return this.Locations; }

    public void setLocations(ArrayList<Location> Locations) { this.Locations = Locations; }

    public ArrayList<Service> Services;

    public ArrayList<Service> getServices() { return this.Services; }

    public void setServices(ArrayList<Service> Services) { this.Services = Services; }

    public ArrayList<LocationsXService> LocationsXServices;

    public ArrayList<LocationsXService> getLocationsXServices() { return this.LocationsXServices; }

    public void setLocationsXServices(ArrayList<LocationsXService> LocationsXServices) { this.LocationsXServices = LocationsXServices; }
}
