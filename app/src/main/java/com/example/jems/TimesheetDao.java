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
    void insert(EmployeeTimeSheet employeeTimeSheet);

    @Update
    void update(EmployeeTimeSheet employeeTimeSheet);

    @Delete
    void delete(EmployeeTimeSheet employeeTimeSheet);

    @Query("SELECT * FROM timesheet")
    List<EmployeeTimeSheet> getAll();


    @Query("DELETE FROM timesheet")
    void nukeTable();
}
