package com.effone.retrofit.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by sumanth.peddinti on 9/13/2017.
 */

public class Location implements Serializable {
    private int LocID;

    public int getLocID() { return this.LocID; }

    public void setLocID(int LocID) { this.LocID = LocID; }

    private int OrgID;

    public int getOrgID() { return this.OrgID; }

    public void setOrgID(int OrgID) { this.OrgID = OrgID; }

    private String LocName;

    public String getLocName() { return this.LocName; }

    public void setLocName(String LocName) { this.LocName = LocName; }

    private String Phone1;

    public String getPhone1() { return this.Phone1; }

    public void setPhone1(String Phone1) { this.Phone1 = Phone1; }

    private String Phone2;

    public String getPhone2() { return this.Phone2; }

    public void setPhone2(String Phone2) { this.Phone2 = Phone2; }

    private String Fax;

    public String getFax() { return this.Fax; }

    public void setFax(String Fax) { this.Fax = Fax; }

    private int Latitude;

    public int getLatitude() { return this.Latitude; }

    public void setLatitude(int Latitude) { this.Latitude = Latitude; }

    private int Longitude;

    public int getLongitude() { return this.Longitude; }

    public void setLongitude(int Longitude) { this.Longitude = Longitude; }

    private boolean IsIntrinsic;

    public boolean getIsIntrinsic() { return this.IsIntrinsic; }

    public void setIsIntrinsic(boolean IsIntrinsic) { this.IsIntrinsic = IsIntrinsic; }

    private boolean IsAppointmentsForever;

    public boolean getIsAppointmentsForever() { return this.IsAppointmentsForever; }

    public void setIsAppointmentsForever(boolean IsAppointmentsForever) { this.IsAppointmentsForever = IsAppointmentsForever; }

    private String AptStartRangeDate;

    public String getAptStartRangeDate() { return this.AptStartRangeDate; }

    public void setAptStartRangeDate(String AptStartRangeDate) { this.AptStartRangeDate = AptStartRangeDate; }

    private String AptEndRangeDate;

    public String getAptEndRangeDate() { return this.AptEndRangeDate; }

    public void setAptEndRangeDate(String AptEndRangeDate) { this.AptEndRangeDate = AptEndRangeDate; }

    private int AdvanceBookingDays;

    public int getAdvanceBookingDays() { return this.AdvanceBookingDays; }

    public void setAdvanceBookingDays(int AdvanceBookingDays) { this.AdvanceBookingDays = AdvanceBookingDays; }

    private String LocationTimeZone;

    public String getLocationTimeZone() { return this.LocationTimeZone; }

    public void setLocationTimeZone(String LocationTimeZone) { this.LocationTimeZone = LocationTimeZone; }

    private int LeadTime;

    public int getLeadTime() { return this.LeadTime; }

    public void setLeadTime(int LeadTime) { this.LeadTime = LeadTime; }

    private String CutOffTime;

    public String getCutOffTime() { return this.CutOffTime; }

    public void setCutOffTime(String CutOffTime) { this.CutOffTime = CutOffTime; }

    private boolean IsActive;

    public boolean getIsActive() { return this.IsActive; }

    public void setIsActive(boolean IsActive) { this.IsActive = IsActive; }

    private boolean IsUnUsed;

    public boolean getIsUnUsed() { return this.IsUnUsed; }

    public void setIsUnUsed(boolean IsUnUsed) { this.IsUnUsed = IsUnUsed; }

    private int AuditID;

    public int getAuditID() { return this.AuditID; }

    public void setAuditID(int AuditID) { this.AuditID = AuditID; }

    private Address Address;

    public Address getAddress() { return this.Address; }

    public void setAddress(Address Address) { this.Address = Address; }

    private ArrayList<WorkHour> WorkHours;

    public ArrayList<WorkHour> getWorkHours() { return this.WorkHours; }

    public void setWorkHours(ArrayList<WorkHour> WorkHours) { this.WorkHours = WorkHours; }

    private ArrayList<ServicesProvided> ServicesProvided;

    public ArrayList<ServicesProvided> getServicesProvided() { return this.ServicesProvided; }

    public void setServicesProvided(ArrayList<ServicesProvided> ServicesProvided) { this.ServicesProvided = ServicesProvided; }

    private ArrayList<Holiday> Holidays;

    public ArrayList<Holiday> getHolidays() { return this.Holidays; }

    public void setHolidays(ArrayList<Holiday> Holidays) { this.Holidays = Holidays; }
}
