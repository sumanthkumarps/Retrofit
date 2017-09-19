package com.effone.retrofit.databaseModel;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.io.Serializable;
import java.util.ArrayList;

import io.realm.RealmObject;

/**
 * Created by sumanth.peddinti on 9/18/2017.
 */

public class Services extends RealmObject {
        public int ServiceID;

        public int getServiceID() { return this.ServiceID; }

        public void setServiceID(int ServiceID) { this.ServiceID = ServiceID; }

        public int OrgID;

        public int getOrgID() { return this.OrgID; }

        public void setOrgID(int OrgID) { this.OrgID = OrgID; }

        public String ServiceName;

        public String getServiceName() { return this.ServiceName; }

        public void setServiceName(String ServiceName) { this.ServiceName = ServiceName; }

        public String Description;

        public String getDescription() { return this.Description; }

        public void setDescription(String Description) { this.Description = Description; }

        public String Duration;

        public String getDuration() { return this.Duration; }

        public void setDuration(String Duration) { this.Duration = Duration; }

        public boolean IsIntrinsic;

        public boolean getIsIntrinsic() { return this.IsIntrinsic; }

        public void setIsIntrinsic(boolean IsIntrinsic) { this.IsIntrinsic = IsIntrinsic; }

        public boolean IsActive;

        public boolean getIsActive() { return this.IsActive; }

        public void setIsActive(boolean IsActive) { this.IsActive = IsActive; }

        public boolean IsDeleted;

        public boolean getIsDeleted() { return this.IsDeleted; }

        public void setIsDeleted(boolean IsDeleted) { this.IsDeleted = IsDeleted; }

        public boolean IsUnUsed;

        public boolean getIsUnUsed() { return this.IsUnUsed; }

        public void setIsUnUsed(boolean IsUnUsed) { this.IsUnUsed = IsUnUsed; }

        public int AuditID;

        public int getAuditID() { return this.AuditID; }

        public void setAuditID(int AuditID) { this.AuditID = AuditID; }


}
