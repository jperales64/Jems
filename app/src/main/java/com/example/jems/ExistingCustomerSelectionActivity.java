package com.example.jems;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ExistingCustomerSelectionActivity extends AppCompatActivity {

    private List<Customer> existingCustomers =  new ArrayList<>();
    WorkProjectDatabase wpDb;
    private ExisitngCustomerAdapter.OnItemClickListener listener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existing_customer_selection);
        RecyclerView rvExistingCustomers = findViewById(R.id.exisitngCustDisplayRV);
        wpDb = Room.databaseBuilder(getApplicationContext(), WorkProjectDatabase.class, "work_project_db").allowMainThreadQueries().build();
        existingCustomers = wpDb.customerDao().getAll();
        System.out.println(existingCustomers);
        ExisitngCustomerAdapter exisitngCustomerAdapter = new ExisitngCustomerAdapter(existingCustomers, listener);
        rvExistingCustomers.setAdapter(exisitngCustomerAdapter);
        rvExistingCustomers.setLayoutManager(new LinearLayoutManager(this));
    }
}
