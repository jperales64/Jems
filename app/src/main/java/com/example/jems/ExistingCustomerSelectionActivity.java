package com.example.jems;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class ExistingCustomerSelectionActivity extends AppCompatActivity {

    WorkProjectDatabase wpDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existing_customer_selection);
        RecyclerView rvExistingCustomers = findViewById(R.id.exisitngCustDisplayRV);
        wpDb = WorkProjectDatabase.getInstance(this);
        List<Customer> existingCustomers = wpDb.customerDao().getAll();
        ExisitngCustomerAdapter.OnItemClickListener listener = new ExisitngCustomerAdapter.OnItemClickListener() {


            @Override
            public void onItemClick(Customer customer) {
                Intent intent = new Intent(ExistingCustomerSelectionActivity.this, CreateProjectName.class);
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
