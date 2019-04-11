package com.example.jems;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface EmployeeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Employee employee);

    @Update
    void updat(Employee employee);

    @Delete
    void delete(Employee employee);

    @Query("SELECT * FROM employee")
    List<Employee> getAll();


    @Query("DELETE FROM employee")
    void nukeTable();
}
