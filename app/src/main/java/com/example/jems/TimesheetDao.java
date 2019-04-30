package com.example.jems;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface TimesheetDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(Timesheet employeeTimeSheet);

    @Update
    void update(Timesheet employeeTimeSheet);

    @Delete
    void delete(Timesheet employeeTimeSheet);

    @Query("SELECT * FROM timesheet")
    List<Timesheet> getAll();


    @Query("DELETE FROM timesheet")
    void nukeTable();

    @Query("SELECT * FROM timesheet WHERE timeId = (:tsId)")
    Timesheet getTimesheet(int tsId);

    @Query("SELECT * FROM timesheet WHERE empId = (:empId)")
    List<Timesheet> getTSbyEmpId(int empId);

    @Query("UPDATE timesheet SET clock_in = (:clockIn) WHERE timeId = (:timeId)")
    void updateClockIn(String clockIn, int timeId);

    @Query("UPDATE timesheet SET clock_out = (:clockOut) WHERE timeId = (:timeId)")
    void updateClockOut(String clockOut, int timeId);

    @Query("SELECT onTheClock.*, timesheet.* " +
            "FROM timesheet LEFT OUTER JOIN onTheClock " +
            "ON timesheet.timeId = onTheClock.timesheet_id")
    Timesheet findTSinEmpOnClockList();

}
