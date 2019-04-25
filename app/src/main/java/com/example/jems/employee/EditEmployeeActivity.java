package com.example.jems.employee;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jems.CreateNewCustomerActivity;
import com.example.jems.R;
import com.example.jems.WorkProjectDatabase;

import org.w3c.dom.Text;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
        firstName.setText(e.getFirstName().toString());
        lastName.setText(e.getLastName().toString());
        wage.setText(Double.toString(e.getWage()));

        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        final String sDate = e.getStartDate().format(formatter);
        startDate.setText(sDate);

        // UPDATE EMPLOYEE BTN CLICKED
        updateBtn = findViewById(R.id.updateEmpBtn);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
                Double w = Double.parseDouble(wage.getText().toString());

                String sDate = startDate.getText().toString();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate date;
                String[] dateArr = sDate.split("-");
                if (dateArr[0].length() == 2) {
                    String[] temp = new String[3];
                    temp[0] = dateArr[2];
                    temp[1] = dateArr[0];
                    temp[2] = dateArr[1];
                    sDate = String.join("-", temp);
                }
                date = LocalDate.parse(sDate, formatter);

                e.setFirstName(first);
                e.setLastName(last);
                e.setWage(w);
                e.setStartDate(date);

                wpDb.employeeDao().update(e);

                Intent intent = new Intent(getApplicationContext(), EmployeeActivity.class);

                intent.putExtra("com.example.jems.EMP_DETAIL_ACT", e);
                startActivity(intent);

            }
        });

        // DELETE BUTTON CLICKED
        deleteBtn = (Button) findViewById(R.id.deleteEmpBtn);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
        });
    }


    @Override
    public void onBackPressed() {
        Intent i = new Intent(getApplicationContext(), EmployeeTimesheetDetailActivity.class);
        i.putExtra("com.example.jems.EMP_DETAIL_ACT", e);
        startActivity(i);
    }
}
