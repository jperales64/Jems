package com.example.jems;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface CustomerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Customer customer);

    @Update
    void update(Customer customer);

    @Delete
    void delete(Customer customer);

    @Query("SELECT * FROM customer")
    List<Customer> getAll();


    @Query("DELETE FROM customer")
    void nukeTable();

    @Query("SELECT * FROM customer WHERE id IN(:custId)")
    Customer getCustbyId(int custId);

    @Query("SELECT * FROM customer WHERE first_name IN(:custFirstName) AND last_name IN(:custLastName)")
    Customer getCustbyName(String custFirstName, String custLastName);
}
