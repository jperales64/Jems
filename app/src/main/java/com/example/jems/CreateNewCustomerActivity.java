package com.example.jems;

import android.app.AlertDialog;
import android.app.Dialog;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 *      Activity for creating a new customer and adding it to the database
 */
public class CreateNewCustomerActivity extends AppCompatActivity {
    Button addCustomerToDatabase;
    private WorkProjectDatabase wpdp;
    private EditText newCustFirstName;
    private EditText newCustLastName;
    private EditText newCustAddress;
    private EditText newCustTele;
    EditText projName;
//    private String projectName;
    private Customer cust;
    private WorkProject project;
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
                addCustomer(v);
            }
        });
    }

    public void addCustomer(View view) {
        String firstName = newCustFirstName.getText().toString();
        String lastName = newCustLastName.getText().toString();
        String address = newCustAddress.getText().toString();
        String tele = newCustTele.getText().toString();
        cust = new Customer(firstName,lastName,address,tele);

        wpdp.customerDao().insert(cust);

//        AlertDialog.Builder builder = new AlertDialog.Builder(CreateNewCustomerActivity.this);
//        // Get the layout inflater
//        LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//        // Inflate and set the layout for the dialog
//        // Pass null as the parent view because its going in the dialog layout
//        builder.setView(inflater.inflate(R.layout.create_project_name, null));
//                // Add action buttons
//
//        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int id) {
//                        projName = findViewById(R.id.projNameEditView);
//                        String projectName = projName.getText().toString();
//
//
//                    }
//                });
//        builder.create();
//        builder.show();
        cust = wpdp.customerDao().getCustbyName(cust.getFirstName(),cust.getLastName());
        project = new WorkProject(cust.getId());
//        project.setProjectName(projectName);

        Intent intent = new Intent(CreateNewCustomerActivity.this, CreateProjectName.class);
        intent.putExtra("project", project);
        intent.putExtra("customer", cust);
        wpdp.workProjectDao().insert(project);
        startActivity(intent);
    }

}
