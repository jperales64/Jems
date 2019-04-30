package com.example.jems;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface EmployeesOnTheClockDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(EmployeesOnTheClock entry);

    @Update
    void update(EmployeesOnTheClock entry);

    @Delete
    void delete(EmployeesOnTheClock entry);

    @Query("SELECT * FROM onTheClock")
    List<EmployeesOnTheClock> getAll();

    @Query("SELECT timesheet_id FROM ontheclock WHERE emp_id = (:empId)")
    int getTimesheetId(int empId);

    @Query("SELECT * FROM onTheClock WHERE emp_id = (:empId)")
    EmployeesOnTheClock getEOCbyId(int empId);

    @Query("DELETE FROM onTheClock")
    void nukeTable();


}
