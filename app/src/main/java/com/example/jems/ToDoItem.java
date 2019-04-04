package com.example.jems;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "toDoList")
public class ToDoItem {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int toDoItemId;

    @ColumnInfo(name = "project_id")
    private int projectId;

    @ColumnInfo(name = "to_do_item")
    private String toDoItem;

    public ToDoItem(String toDoItem, int projectId){
        this.toDoItem = toDoItem;
        this.projectId = projectId;
    }

    public String getToDoItem() {
        return toDoItem;
    }

    public void setToDoItem(String toDoItem){
        this.toDoItem = toDoItem;
    }

    public void setProjectId(int projectId){
        this.projectId = projectId;
    }

    public int getProjectId(){
        return this.projectId;
    }

    public int getToDoItemId(){
        return toDoItemId;
    }

    public void setToDoItemId(int toDoItemId){
        this.toDoItemId = toDoItemId;
    }
}
