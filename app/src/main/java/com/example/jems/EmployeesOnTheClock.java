package com.example.jems;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import javax.annotation.Nonnull;

@Entity(tableName = "onTheClock")
public class EmployeesOnTheClock {

    @PrimaryKey(autoGenerate = true)
    @Nonnull
    private int id;

    @ColumnInfo(name = "timesheet_id")
    private int tsId;

    @ColumnInfo(name = "emp_id")
    private int empId;

    public EmployeesOnTheClock(int tsId, int empId) {
        this.tsId = tsId;
        this.empId = empId;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getTsId() {
        return tsId;
    }

    public void setTsId(int tsId) {
        this.tsId = tsId;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }


}
