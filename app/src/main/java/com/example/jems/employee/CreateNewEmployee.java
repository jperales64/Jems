package com.example.jems.employee;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jems.AlertDialogFragment;
import com.example.jems.R;
import com.example.jems.WorkProjectDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class CreateNewEmployee extends AppCompatActivity {

    private Button createNewEmpBtn;
    private TextView firstName;
    private TextView lastName;
    private TextView wage;
    private TextView startDate;
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
        startDate = findViewById(R.id.startDateEditText);

        createNewEmpBtn = (Button) findViewById(R.id.createNewEmpBtn);
        createNewEmpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(firstName.getText().toString())) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(CreateNewEmployee.this);
                    builder.setTitle(R.string.insert_first_name);
                    builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            return;
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                    return;
                }

                if (TextUtils.isEmpty(lastName.getText().toString())) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(CreateNewEmployee.this);
                    builder.setTitle(R.string.insert_last_name);
                    builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            return;
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                    return;
                }

                if (TextUtils.isEmpty(wage.getText().toString())) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(CreateNewEmployee.this);
                    builder.setTitle(R.string.insert_wage);
                    builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            return;
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                    return;
                }

                if (TextUtils.isEmpty(startDate.getText().toString())) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(CreateNewEmployee.this);
                    builder.setTitle(R.string.insert_date);
                    builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            return;
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                    return;
                }

                String first = firstName.getText().toString();
                String last = lastName.getText().toString();
                Double w = Double.parseDouble(wage.getText().toString());

                String sDate = startDate.getText().toString();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate date = LocalDate.parse(sDate, formatter);


                Employee newEmployee = new Employee(first, last, date, w); //removed start date
                wpDb.employeeDao().insert(newEmployee);

                Intent intent = new Intent(getApplicationContext(), EmployeeActivity.class);
                newEmployee = wpDb.employeeDao().getEmpbyName(newEmployee.getFirstName(), newEmployee.getLastName());
                Log.i("CreateNewEmployee", "The employee is " + newEmployee.getFirstName());

                intent.putExtra("com.example.jems.NEW_EMP", newEmployee);
                startActivity(intent);

            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(getApplicationContext(), EmployeeActivity.class);
        startActivity(i);
    }


}
