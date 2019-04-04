package com.example.jems;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface ToDoListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ToDoItem toDoItem);

    @Update
    void update(ToDoItem toDoItem);

    @Delete
    void delete(ToDoItem toDoItem);

    @Query("SELECT * FROM toDoList")
    List<ToDoItem> getAll();

    @Query("DELETE FROM TODOLIST")
    void nukeTable();
}
