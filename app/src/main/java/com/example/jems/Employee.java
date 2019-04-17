package com.example.jems;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.math.BigDecimal;

@Entity(tableName = "employee")
public class Employee {
    @PrimaryKey(autoGenerate = true)
    private int employeeId;

    @ColumnInfo(name = "employee_first_name")
    private String firstName;

    @ColumnInfo(name = "employee_last_name")
    private String lastName;

    @ColumnInfo(name = "wage")
    String wageStr;
    @Ignore
    private BigDecimal wage;

    @ColumnInfo(name = "start_date")
    //Store in yyyy-mm-dd
            //Insert will take each as an argument and format it
            String date;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //test Constructor
    public Employee() {
        this.firstName = "Jeff";
        this.lastName = "LasatName";
        this.wage = new BigDecimal("16.00");
        this.wageStr = this.wage.toString();
        date = "2019-04-15";
    }

    public String getFirstName() {
        return this.firstName;
    }

    void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    String getLastName() {
        return this.lastName;
    }

    void setLastName(String lastName) {
        this.lastName = lastName;
    }


    int getEmployeeId() {
        return this.employeeId;
    }

    void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}


