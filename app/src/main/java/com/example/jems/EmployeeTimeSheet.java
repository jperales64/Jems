package com.example.jems;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.icu.text.SimpleDateFormat;
import android.support.annotation.NonNull;

import java.util.Date;

@Entity(tableName = "timesheetJP")
public class EmployeeTimeSheet {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="timesheet_Id")
    private int timeSheetId;


    @ColumnInfo(name="employee_id")
    private int empId;


    @ColumnInfo(name="project_id")
    private int projectId;

    @NonNull
    @ColumnInfo(name="clock_in")
    private String clockIn;

    @ColumnInfo(name="clock_out")
    private String clockOut;

     EmployeeTimeSheet(int empId, int projectId){
        this.empId = empId;
        this.projectId = projectId;
        this.clockIn = getCurrentTimeStamp();

    }

     int getTimeSheetId() {
        return timeSheetId;
    }

     void setTimeSheetId(int timeSheetId) {
        this.timeSheetId = timeSheetId;
    }

     int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

     int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

     @NonNull
     String getClockIn() {
        return clockIn;
    }

     void setClockIn(@NonNull String clockIn) {
        this.clockIn = clockIn;
    }

     String getClockOut() {
        return clockOut;
    }

     void setClockOut(String clockOut) {
        this.clockOut = clockOut;
    }

     private static String getCurrentTimeStamp(){
        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            return dateFormat.format(new Date());
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }
}
