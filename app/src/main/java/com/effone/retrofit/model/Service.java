package com.effone.retrofit.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by sumanth.peddinti on 9/13/2017.
 */

public class Service implements Serializable{
    private int ServiceID;

    public int getServiceID() { return this.ServiceID; }

    public void setServiceID(int ServiceID) { this.ServiceID = ServiceID; }

    private int OrgID;

    public int getOrgID() { return this.OrgID; }

    public void setOrgID(int OrgID) { this.OrgID = OrgID; }

    private String ServiceName;

    public String getServiceName() { return this.ServiceName; }

    public void setServiceName(String ServiceName) { this.ServiceName = ServiceName; }

    private String Description;

    public String getDescription() { return this.Description; }

    public void setDescription(String Description) { this.Description = Description; }

    private String Duration;

    public String getDuration() { return this.Duration; }

    public void setDuration(String Duration) { this.Duration = Duration; }

    private boolean IsIntrinsic;

    public boolean getIsIntrinsic() { return this.IsIntrinsic; }

    public void setIsIntrinsic(boolean IsIntrinsic) { this.IsIntrinsic = IsIntrinsic; }

    private boolean IsActive;

    public boolean getIsActive() { return this.IsActive; }

    public void setIsActive(boolean IsActive) { this.IsActive = IsActive; }

    private boolean IsDeleted;

    public boolean getIsDeleted() { return this.IsDeleted; }

    public void setIsDeleted(boolean IsDeleted) { this.IsDeleted = IsDeleted; }

    private boolean IsUnUsed;

    public boolean getIsUnUsed() { return this.IsUnUsed; }

    public void setIsUnUsed(boolean IsUnUsed) { this.IsUnUsed = IsUnUsed; }

    private int AuditID;

    public int getAuditID() { return this.AuditID; }

    public void setAuditID(int AuditID) { this.AuditID = AuditID; }

    private ArrayList<String> WorkHours;

    public ArrayList<String> getWorkHours() { return this.WorkHours; }

    public void setWorkHours(ArrayList<String> WorkHours) { this.WorkHours = WorkHours; }
}
