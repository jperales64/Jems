package com.example.jems.employee;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

@Entity(tableName = "employee")
public class Employee implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int employeeId;

    @ColumnInfo(name = "employee_first_name")
    private String firstName;

    @ColumnInfo(name = "employee_last_name")
    private String lastName;

    @ColumnInfo(name = "hours")
    double hours = 0;

    @ColumnInfo(name = "wage")
    private double wage;

    public Employee() {}
    @Ignore
    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Employee(String firstName, String lastName, double wage) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.wage = wage;
    }

    public Employee(Parcel in){
        this.employeeId = in.readInt();
        this.firstName = in.readString();
        this.lastName = in.readString();
        this.hours = in.readDouble();
        this.wage = in.readDouble();

    }

    public static final Creator<Employee> CREATOR = new Creator<Employee>() {
        @Override
        public Employee createFromParcel(Parcel in) {
            return new Employee(in);
        }

        @Override
        public Employee[] newArray(int size) {
            return new Employee[size];
        }
    };

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

    public double getWage(){ return this.wage;}

    public void setWage(double wage){
        this.wage = wage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeInt(employeeId);
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeDouble(hours);
        dest.writeDouble(wage);

    }


}
