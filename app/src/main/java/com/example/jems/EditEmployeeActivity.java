package com.example.jems;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class EditEmployeeActivity extends AppCompatActivity {
    private Employee e;
    private int empId;
    private TextView firstName;
    private TextView lastName;
    private TextView wage;
    private TextView startDate;
    private Button updateBtn;
    private Button deleteBtn;
    private WorkProjectDatabase wpDb;

    private DatePickerDialog.OnDateSetListener mDateSetListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_employee);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent i = getIntent();
        e = (Employee) i.getParcelableExtra("com.example.jems.employee.EDIT_EMP");

        wpDb = WorkProjectDatabase.getInstance(this);
        firstName = findViewById(R.id.firstNameEditText);
        lastName = findViewById(R.id.lastNameEditText);
        wage = findViewById(R.id.wageEditText);
        startDate = findViewById(R.id.startDateEditText);

        empId = e.getEmployeeId();
        firstName.setText(e.getFirstName());
        lastName.setText(e.getLastName());
        wage.setText(Double.toString(e.getWage()));

        startDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Calendar cal = Calendar.getInstance();
//                int year = cal.get(Calendar.YEAR);
//                int month = cal.get(Calendar.MONTH);
//                int day = cal.get(Calendar.DAY_OF_MONTH);
                String[] date = e.getStartDate().split("/");
                int month = Integer.parseInt(date[0]);
                int day = Integer.parseInt(date[1]);
                int year = Integer.parseInt(date[2]);

                DatePickerDialog dialog = new DatePickerDialog(
                        EditEmployeeActivity.this,
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

        // UPDATE EMPLOYEE BTN CLICKED
        updateBtn = findViewById(R.id.updateEmpBtn);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateEmployee(view);
            }
        });

        // DELETE BUTTON CLICKED
        deleteBtn = (Button) findViewById(R.id.deleteEmpBtn);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteEmployee(view);
            }
        });
    }

    public void updateEmployee(View view) {
        if (TextUtils.isEmpty(firstName.getText().toString())) {
            AlertDialog.Builder builder = new AlertDialog.Builder(EditEmployeeActivity.this);
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
            AlertDialog.Builder builder = new AlertDialog.Builder(EditEmployeeActivity.this);
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
            AlertDialog.Builder builder = new AlertDialog.Builder(EditEmployeeActivity.this);
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
            AlertDialog.Builder builder = new AlertDialog.Builder(EditEmployeeActivity.this);
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
        double w = Double.parseDouble(wage.getText().toString());
        String sDate = startDate.getText().toString();

//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate date;
//        String[] dateArr = sDate.split("-");
//        if (dateArr[0].length() == 2) {
//            String[] temp = new String[3];
//            temp[0] = dateArr[2];
//            temp[1] = dateArr[0];
//            temp[2] = dateArr[1];
//            sDate = String.join("-", temp);
//        }
//        date = LocalDate.parse(sDate, formatter);

        e.setFirstName(first);
        e.setLastName(last);
        e.setWage(w);
        e.setStartDate(sDate);

//        wpDb.employeeDao().update(e);

        wpDb.employeeDao().update(e);
        Intent intent = new Intent(getApplicationContext(), EmployeeDetailActivity.class);

        intent.putExtra("com.example.jems.EMP_DETAIL_ACT", e);
        startActivity(intent);

    }

    public void deleteEmployee(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(EditEmployeeActivity.this);
        builder.setTitle("Are you sure?");
        builder.setMessage("You are about to delete this employee. Data will be lost if employee is deleted.");
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                return;
            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                wpDb.employeeDao().delete(e);
                Intent intent = new Intent(getApplicationContext(), EmployeeActivity.class);
                startActivity(intent);
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    @Override
    public void onBackPressed() {
        Intent i = new Intent(getApplicationContext(), EmployeeDetailActivity.class);
        i.putExtra("com.example.jems.EMP_DETAIL_ACT", e);
        startActivity(i);
    }
}
