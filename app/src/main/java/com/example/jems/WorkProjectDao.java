package com.example.jems;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface WorkProjectDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(WorkProject project);

    @Update
    void update(WorkProject project);

    @Delete
    void delete(WorkProject project);

    @Query("SELECT * FROM project")
    List<WorkProject> getAll();


    @Query("DELETE FROM project")
     void nukeTable();

}
