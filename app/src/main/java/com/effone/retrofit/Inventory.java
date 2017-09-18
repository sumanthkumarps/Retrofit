package com.effone.retrofit;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Belal on 5/26/2016.
 */

//This is our table name
@Table(name = "Inventory")
public class Inventory extends Model {

    @Column(name = "AdvanceBookingDays")
    public int AdvanceBookingDays;
    @Column(name = "Fax")
    public String Fax;
    @Column(name = "LeadTime")
    public int LeadTime;
    @Column(name = "IsIntrinsic")
    public Boolean IsIntrinsic;
    @Column(name = "IsUnUsed")
    public Boolean IsUnUsed;
    @Column(name = "AuditID")
    public int AuditID;
    @Column(name = "IsAppointmentsForever")
    public Boolean IsAppointmentsForever;
    @Column(name = "AptStartRangeDate")
    public String AptStartRangeDate;
    @Column(name = "IsActive")
    public Boolean IsActive;
    @Column(name = "OrgID")
    public int OrgID;
    @Column(name = "CutOffTime")
    public String CutOffTime;
    @Column(name = "Latitude")
    public int Latitude;
    @Column(name = "LocationTimeZone")
    public String LocationTimeZone;
    @Column(name = "Longitude")
    public int Longitude;
    @Column(name = "AptEndRangeDate")
    public String AptEndRangeDate;
    //The table consist only one field name
    @Column(name = "LocID")
    public int LocID;
    @Column(name = "LocName")
    public String LocName;
    @Column(name = "Phone1")
    public String Phone1;
    @Column(name = "Phone2")
    public String Phone2;

    @Column(name = "AddressLine1")
    public String AddressLine1;
    @Column(name = "AddressLine2")
    public String AddressLine2;
    @Column(name = "AddressLine3")
    public String AddressLine3;
    @Column(name = "City")
    public String City;
    @Column(name = "State")
    public String State;
    @Column(name = "Zip")
    public String Zip;
    @Column(name = "Country")
    public String Country;


}
