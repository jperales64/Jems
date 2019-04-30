package com.example.jems;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {WorkProject.class, Customer.class, ToDoItem.class, Employee.class, EmployeeTimeSheet.class, EmployeesOnJob.class, Timesheet.class, EmployeesOnTheClock.class},  version = 25)
public abstract class WorkProjectDatabase extends RoomDatabase {

    public abstract WorkProjectDao workProjectDao();
    public abstract CustomerDao customerDao();
    public abstract ToDoListDao toDoListDao();
    public abstract EmployeeDao employeeDao();
    public abstract TimesheetDao timesheetDao();
    public abstract EmployeeOnJobDao employeesOnJobDao();
    public abstract EmployeesOnTheClockDao onTheClockDao();

    private static WorkProjectDatabase firstInstance = null;
     public static WorkProjectDatabase getInstance(Context context){
        if(firstInstance == null){
           firstInstance = Room.databaseBuilder(context, WorkProjectDatabase.class, "work_project_db").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        }
        return firstInstance;

    }
}
