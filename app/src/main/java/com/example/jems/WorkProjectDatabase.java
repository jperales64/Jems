package com.example.jems;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {WorkProject.class, Customer.class},  version = 4)
public abstract class WorkProjectDatabase extends RoomDatabase {

    public abstract WorkProjectDao workProjectDao();
    public abstract CustomerDao customerDao();
}
