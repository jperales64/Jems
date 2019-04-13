package com.example.jems;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.math.BigDecimal;

@Entity(tableName = "employee")
public class Employee   {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int employeeId;

    @ColumnInfo(name = "employee_first_name")
    String firstName;

    @ColumnInfo(name = "employee_last_name")
    String lastName;

    @ColumnInfo(name = "wage")
    String wageStr;
    @Ignore
    BigDecimal wage;

    @ColumnInfo(name = "start_date")
    String date;
    //Store in yyyy-mm-dd
            //Insert will take each as an argument and format it


    public Employee(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //test Constructor
    public Employee(){

    }

    public String getFirstName(){
        return this.firstName;
    }

    public void  setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }



    public int getEmployeeId(){
        return this.employeeId;
    }

    public void setEmployeeId(int employeeId){
        this.employeeId = employeeId;
    }
}


