package com.example.jems;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.icu.text.SimpleDateFormat;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity(tableName = "timesheet")
public class Timesheet implements Parcelable{
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int timeId;

    @ForeignKey(entity = Employee.class,
            parentColumns = "employeeId",
            childColumns = "empId")
    @ColumnInfo(name = "empId")
    private int empId;

    @ColumnInfo(name = "clock_in")
//    @TypeConverters({TimeStampConverter.class})
    private String clockIn;

    @ColumnInfo(name = "clock_out")
//    @TypeConverters({TimeStampConverter.class})
    private String clockOut;

    @ColumnInfo(name = "numHours")
    private double numHours;

    @ForeignKey(entity = WorkProject.class, parentColumns = "id", childColumns = "projectId")
    @ColumnInfo(name = "projectId")
    private int projId;

    public Timesheet(int empId) {
        this.empId = empId;
        this.clockIn = getCurrentTimeStamp();
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

//    @Ignore
//    public Timesheet(int empId, LocalDateTime clockIn, LocalDateTime clockOut, double numHours) {
//        this.empId = empId;
//        this.clockIn = clockIn;
//        this.clockOut = clockOut;
//        this.numHours = numHours;
////        this.projId = projId;
//    }
//
//    @Ignore
//    public Timesheet(int empId, LocalDateTime clockIn, LocalDateTime clockOut, double numHours, int projId) {
//        this.empId = empId;
//        this.clockIn = clockIn;
//        this.clockOut = clockOut;
//        this.numHours = numHours;
//        this.projId = projId;
//    }

    protected Timesheet(Parcel in) {
        timeId = in.readInt();
        empId = in.readInt();
        clockIn = in.readString();
        clockOut = in.readString();

//        String sIn = in.readString();
//        String sOut = in.readString();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd HHmm");
//        this.clockIn = LocalDateTime.parse(sIn, formatter);
//        this.clockOut = LocalDateTime.parse(sOut, formatter);

        numHours = in.readDouble();
        projId = in.readInt();
    }

    public static final Creator<Timesheet> CREATOR = new Creator<Timesheet>() {
        @Override
        public Timesheet createFromParcel(Parcel in) {
            return new Timesheet(in);
        }

        @Override
        public Timesheet[] newArray(int size) {
            return new Timesheet[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(timeId);
        parcel.writeInt(empId);

        parcel.writeString(clockIn);
        parcel.writeString(clockOut);

//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd HHmm");
//        String sIn = clockIn.format(formatter);
//        parcel.writeString(sIn);

        parcel.writeDouble(numHours);
        parcel.writeInt(projId);
    }

    public int getTimeId() {
        return timeId;
    }

    public void setTimeId(int timeId) {
        this.timeId = timeId;
    }

    public String getClockIn() {
        return clockIn;
    }

    public void setClockIn(String clockIn) {
        this.clockIn = clockIn;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getClockOut() {
        return clockOut;
    }

    public void setClockOut(String clockOut) {
        this.clockOut = clockOut;
    }

    public double getNumHours() {
        return numHours;
    }

    public void setNumHours(double numHours) {
        this.numHours = numHours;
    }

    public int getProjId() {
        return projId;
    }

    public void setProjId(int projId) {
        this.projId = projId;
    }
}
