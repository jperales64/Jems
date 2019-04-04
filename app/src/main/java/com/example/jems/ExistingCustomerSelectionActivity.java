package com.example.jems;

import android.content.Intent;
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
        wpDb = WorkProjectDatabase.getInstance(this);
        existingCustomers = wpDb.customerDao().getAll();
        listener = new ExisitngCustomerAdapter.OnItemClickListener() {


            @Override
            public void onItemClick(Customer customer) {
                Intent intent = new Intent(ExistingCustomerSelectionActivity.this, ProjectDisplayActivity.class);
                WorkProject temp = new WorkProject(customer.getId());
                intent.putExtra("project", temp);
                intent.putExtra("customer", customer);
                wpDb.workProjectDao().insert(temp);
                startActivity(intent);
            }
        };
        ExisitngCustomerAdapter exisitngCustomerAdapter = new ExisitngCustomerAdapter(existingCustomers, listener);
        rvExistingCustomers.setAdapter(exisitngCustomerAdapter);
        rvExistingCustomers.setLayoutManager(new LinearLayoutManager(this));
    }
}
