package com.effone.retrofit.databaseModel;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by sumanth.peddinti on 9/18/2017.
 */
@Table(name = "Services")
public class Services extends Model {

    @Column(name = "ServiceID")
    public int ServiceID;
    @Column(name="LocId")
    public int LocId;
    @Column(name = "ServiceName")
    public String ServiceName;
    @Column(name = "Description")
    public String  Description;
    @Column(name = "Duration")
    public String Duration;
    @Column(name = "IsActive")
    public Boolean IsActive;


}
