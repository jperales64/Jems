package com.example.jems;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.math.BigDecimal;

@Entity(tableName = "employee")
class Employee {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int employeeId;

//    @ColumnInfo(name = "empId")
//    int empId;

    @ColumnInfo(name = "employee_first_name")
    String firstName;

    @ColumnInfo(name = "employee_last_name")
    String lastName;

    @ColumnInfo(name = "hours")
    double hours = 0;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //test Constructor
    public Employee() {

    }

    public Employee(String firstName, String lastName, Double wage) {

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

    public double getHours(){ return this.hours;}

    public void updateHours(int additonalHoursWorked){
        this.hours += additonalHoursWorked;
    }

    public void setHours(double hours){
        this.hours = hours;
    }

    public int getEmployeeId(){
        return this.employeeId;
    }

    public void setEmployeeId(int employeeId){
        this.employeeId = employeeId;
    }
}
