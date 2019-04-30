package com.example.jems;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "toDoList")
public class ToDoItem {
    @PrimaryKey(autoGenerate = true)
    private int toDoItemId;

    @ColumnInfo(name = "project_id")
    private int projectId;

    @ColumnInfo(name = "to_do_item")
    private String toDoItem;

    ToDoItem(String toDoItem, int projectId){
        this.toDoItem = toDoItem;
        this.projectId = projectId;
    }

    String getToDoItem() {
        return toDoItem;
    }

    public void setToDoItem(String toDoItem){
        this.toDoItem = toDoItem;
    }

    public void setProjectId(int projectId){
        this.projectId = projectId;
    }

    int getProjectId(){
        return this.projectId;
    }

    int getToDoItemId(){
        return toDoItemId;
    }

    void setToDoItemId(int toDoItemId){
        this.toDoItemId = toDoItemId;
    }
}
