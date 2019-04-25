package com.example.jems;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface EmployeeOnJobDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(EmployeesOnJob employee);

    @Update
    void update(EmployeesOnJob employee);

    @Delete
    void delete(EmployeesOnJob employee);

    @Query("SELECT * FROM employees_on_job where project_id = :projectId")
    List<EmployeesOnJob> getAll(int projectId);


    @Query("DELETE FROM employees_on_job")
    void nukeTable();
}
