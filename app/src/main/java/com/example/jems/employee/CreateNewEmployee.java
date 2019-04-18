package com.example.jems.employee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jems.R;
import com.example.jems.WorkProjectDatabase;

public class CreateNewEmployee extends AppCompatActivity {

    private Button createNewEmpBtn;
    private TextView firstName;
    private TextView lastName;
    private TextView wage;
    private WorkProjectDatabase wpDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_employee);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("New Employee");
        setSupportActionBar(toolbar);

        wpDb = WorkProjectDatabase.getInstance(this);
        firstName = findViewById(R.id.firstNameEditText);
        lastName = findViewById(R.id.lastNameEditText);
        wage = findViewById(R.id.wageEditText);

        createNewEmpBtn = (Button) findViewById(R.id.createNewEmpBtn);
        createNewEmpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (firstName.getText().equals(null))
                {}

                String first = firstName.getText().toString();
                String last = lastName.getText().toString();
                Double w = Double.parseDouble(wage.getText().toString());

                Employee newEmployee = new Employee(first, last, w);
                wpDb.employeeDao().insert(newEmployee);

                Intent intent = new Intent(getApplicationContext(), EmployeeActivity.class);
                newEmployee = wpDb.employeeDao().getEmpbyName(newEmployee.getFirstName(), newEmployee.getLastName());
                Log.i("CreateNewEmployee", "The employee is " + newEmployee.getFirstName());

                intent.putExtra("com.example.jems.NEW_EMP", newEmployee);
                startActivity(intent);

            }
        });

    }




}
