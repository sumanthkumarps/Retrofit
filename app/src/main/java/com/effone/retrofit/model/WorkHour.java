package com.effone.retrofit.model;

/**
 * Created by sumanth.peddinti on 9/13/2017.
 */

public class WorkHour {
    private int LocXWorkHourID;

    public int getLocXWorkHourID() { return this.LocXWorkHourID; }

    public void setLocXWorkHourID(int LocXWorkHourID) { this.LocXWorkHourID = LocXWorkHourID; }

    private int LocID;

    public int getLocID() { return this.LocID; }

    public void setLocID(int LocID) { this.LocID = LocID; }

    private int Weekday;

    public int getWeekday() { return this.Weekday; }

    public void setWeekday(int Weekday) { this.Weekday = Weekday; }

    private String WorkStartHour;

    public String getWorkStartHour() { return this.WorkStartHour; }

    public void setWorkStartHour(String WorkStartHour) { this.WorkStartHour = WorkStartHour; }

    private String WorkEndHour;

    public String getWorkEndHour() { return this.WorkEndHour; }

    public void setWorkEndHour(String WorkEndHour) { this.WorkEndHour = WorkEndHour; }

    private String BreakStartHour;

    public String getBreakStartHour() { return this.BreakStartHour; }

    public void setBreakStartHour(String BreakStartHour) { this.BreakStartHour = BreakStartHour; }

    private String BreakEndHour;

    public String getBreakEndHour() { return this.BreakEndHour; }

    public void setBreakEndHour(String BreakEndHour) { this.BreakEndHour = BreakEndHour; }

    private boolean IsWorkingDay;

    public boolean getIsWorkingDay() { return this.IsWorkingDay; }

    public void setIsWorkingDay(boolean IsWorkingDay) { this.IsWorkingDay = IsWorkingDay; }

    private boolean IsClosedForLunch;

    public boolean getIsClosedForLunch() { return this.IsClosedForLunch; }

    public void setIsClosedForLunch(boolean IsClosedForLunch) { this.IsClosedForLunch = IsClosedForLunch; }

    private String HoursRange;

    public String getHoursRange() { return this.HoursRange; }

    public void setHoursRange(String HoursRange) { this.HoursRange = HoursRange; }

    private int AuditID;

    public int getAuditID() { return this.AuditID; }

    public void setAuditID(int AuditID) { this.AuditID = AuditID; }
}
