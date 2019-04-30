package com.example.jems;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity(tableName = "employee")
public class Employee implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int employeeId;

    @ColumnInfo(name = "employee_first_name")
    private String firstName;

    @ColumnInfo(name = "employee_last_name")
    private String lastName;

    @ColumnInfo(name = "start_date")
    @TypeConverters({TimeStampConverter.class})
    private String startDate;

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
    public Employee(String firstName, String lastName, String startDate, double wage) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.startDate = startDate;
        this.wage = wage;
    }

    public Employee(Parcel in){
        this.employeeId = in.readInt();
        this.firstName = in.readString();
        this.lastName = in.readString();
        this.startDate = in.readString();

//        String sDate = in.readString();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        this.startDate = LocalDate.parse(sDate, formatter);

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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
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

        dest.writeString(startDate);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        String sDate = startDate.format(formatter);
//        dest.writeString(sDate);

        dest.writeDouble(wage);

    }
}