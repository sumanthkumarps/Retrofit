package com.effone.retrofit.databaseModel;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by sumanth.peddinti on 9/18/2017.
 */
@Table(name = "Services")
public class LocationXServices extends Model{

    @Column(name="LocId")
    public int LocId;
    @Column(name = "LocXServiceID")
    public int LocXServiceID;
    @Column(name = "ServiceID")
    public int ServiceID;


}
