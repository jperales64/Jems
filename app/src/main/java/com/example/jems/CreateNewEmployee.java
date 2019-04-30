package com.example.jems;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.time.LocalDate;
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

    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_employee);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Create New Employee");
        setSupportActionBar(toolbar);

        wpDb = WorkProjectDatabase.getInstance(this);
        firstName = findViewById(R.id.firstNameEditText);
        lastName = findViewById(R.id.lastNameEditText);
        wage = findViewById(R.id.wageEditText);
        startDate = findViewById(R.id.startDateEditText);
        wage.setInputType(InputType.TYPE_DATETIME_VARIATION_DATE);

        startDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        CreateNewEmployee.this,
                        android.R.style.Theme_Holo_Light,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month += 1;
                String date = month + "/" + day + "/" + year;
                startDate.setText(date);
            }
        };

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


                Employee newEmployee = new Employee(first, last, sDate, w); //removed start date
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
