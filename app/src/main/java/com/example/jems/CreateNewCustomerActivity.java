package com.example.jems;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateNewCustomerActivity extends AppCompatActivity {
    Button addCustomerToDatabase;
    private WorkProjectDatabase wpdp;
    private EditText newCustFirstName;
    private EditText newCustLastName;
    private EditText newCustAddress;
    private EditText newCustTele;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_customer);
        addCustomerToDatabase = findViewById(R.id.addCustToDatabase);
        newCustFirstName = findViewById(R.id.newCustFirstName);
        newCustLastName = findViewById(R.id.newCustLastName);
        newCustAddress = findViewById(R.id.newCustAddress) ;
        newCustTele = findViewById(R.id.newCustTele);
        wpdp = Room.databaseBuilder(getApplicationContext(), WorkProjectDatabase.class, "work_project_db").allowMainThreadQueries().build();
        addCustomerToDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = newCustFirstName.getText().toString();
                String lastName = newCustLastName.getText().toString();
                String address = newCustAddress.getText().toString();
                String tele = newCustTele.getText().toString();
                Customer cust = new Customer(firstName,lastName,address,tele);
                wpdp.customerDao().insert(cust);
                Intent intent = new Intent(CreateNewCustomerActivity.this, ProjectDisplayActivity.class);
                cust = wpdp.customerDao().getCustbyName(cust.getFirstName(),cust.getLastName());
                WorkProject project = new WorkProject(cust.getId());

                intent.putExtra("project", project);
                intent.putExtra("customer", cust);
                wpdp.workProjectDao().insert(project);
                startActivity(intent);
            }
        });

    }

}
