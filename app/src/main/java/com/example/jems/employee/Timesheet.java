package com.example.jems.employee;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.example.jems.TimeStampConverter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    @TypeConverters({TimeStampConverter.class})
    private LocalDateTime clockIn;

    @ColumnInfo(name = "clock_out")
    @TypeConverters({TimeStampConverter.class})
    private LocalDateTime clockOut;

    @ColumnInfo(name = "numHours")
    private double numHours;

    public Timesheet(int empId, LocalDateTime clockIn, LocalDateTime clockOut) {
        this.empId = empId;
        this.clockIn = clockIn;
        this.clockOut = clockOut;
    }

    protected Timesheet(Parcel in) {
        timeId = in.readInt();
        empId = in.readInt();
        String sIn = in.readString();
        String sOut = in.readString();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd HHmm");
        this.clockIn = LocalDateTime.parse(sIn, formatter);
        this.clockOut = LocalDateTime.parse(sOut, formatter);

        numHours = in.readDouble();
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

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd HHmm");
        String sIn = clockIn.format(formatter);
        parcel.writeString(sIn);

        parcel.writeDouble(numHours);
    }
}
