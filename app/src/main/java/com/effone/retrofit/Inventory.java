package com.effone.retrofit;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Belal on 5/26/2016.
 */

//This is our table name
@Table(name = "location")

public class Inventory extends Model {

    //The table consist only one field name
    @Column(name = "LocID ")
    public int LocID ;
    @Column(name = "LocName ")
    public String LocName ;
    @Column(name = "Phone1  ")
    public String Phone1  ;
    @Column(name = "Phone2  ")
    public String Phone2  ;

}
