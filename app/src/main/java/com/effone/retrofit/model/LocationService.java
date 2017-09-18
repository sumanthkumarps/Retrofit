package com.effone.retrofit.model;

import java.util.ArrayList;

/**
 * Created by sumanth.peddinti on 9/13/2017.
 */

public class LocationService {
    public ArrayList<Location> Locations;

    public ArrayList<Location> getLocations() { return this.Locations; }

    public void setLocations(ArrayList<Location> Locations) { this.Locations = Locations; }

    public ArrayList<Service> Services;

    public ArrayList<Service> getServices() { return this.Services; }

    public void setServices(ArrayList<Service> Services) { this.Services = Services; }

    public ArrayList<LocationsXService> LocationsXServices;

    public ArrayList<LocationsXService> getLocationsXServices() { return this.LocationsXServices;}
}
