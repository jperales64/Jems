package com.example.jems;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.facebook.stetho.inspector.protocol.module.DOMStorage;

import java.util.ArrayList;
import java.util.List;

public class EmployeeActivity extends AppCompatActivity {
    private Employee e;
    ListView employeeList;
    WorkProjectDatabase wpDb;
    private List<Employee> employees = new ArrayList<>();
    private Button addNewEmployee;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        Intent i = getIntent();
        Employee e = i.getParcelableExtra("employee");

        addNewEmployee = (Button) findViewById(R.id.addNewEmployeeBtn);

        employeeList = (ListView) findViewById(R.id.employeeList);
        wpDb = WorkProjectDatabase.getInstance(this);
        employees = wpDb.employeeDao().getAll();

//        employeeList.setAdapter(new ArrayAdapter<String>(this, R.layout.employee_listview_detail, employees));

        EmployeeTimesheetAdapter empTimeAdapter = new EmployeeTimesheetAdapter(this, employees);
        employeeList.setAdapter(empTimeAdapter);

        //opens detailed timesheet of clicked employee
        employeeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent showEmpTimeDetailActivity =
                        new Intent(getApplicationContext(), EmployeeTimesheetDetailActivity.class);

                showEmpTimeDetailActivity.putExtra("com.example.jems.EMP_INDEX", i);
                startActivity(showEmpTimeDetailActivity);
            }
        });

        //creates new employee
        addNewEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CreateNewEmployee.class);
                startActivity(intent);

            }
        });
    }


//    private Employee e;
//    ListView employeeList;
//    WorkProjectDatabase wpDb;
//    String [] employees;
//    private Button addNewEmployee;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_employee);
//        Intent i = getIntent();
//        Employee e = i.getParcelableExtra("employee");
//
//        addNewEmployee = (Button) findViewById(R.id.addNewEmployeeBtn);
//
//        employeeList = (ListView) findViewById(R.id.employeeList);
//        wpDb = WorkProjectDatabase.getInstance(this);
////        employees = wpDb.employeeDao().getAll();
//
//        Resources res = getResources();
//        employees = res.getStringArray(R.array.employees);
////        employeeList.setAdapter(new ArrayAdapter<String>(this, R.layout.employee_listview_detail, employees));
//
//        EmployeeTimesheetAdapter empTimeAdapter = new EmployeeTimesheetAdapter(this, employees);
//        employeeList.setAdapter(empTimeAdapter);
//
//        //opens detailed timesheet of clicked employee
//        employeeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent showEmpTimeDetailActivity =
//                        new Intent(getApplicationContext(), EmployeeTimesheetDetailActivity.class);
//
//                showEmpTimeDetailActivity.putExtra("com.example.jems.EMP_INDEX", i);
//                startActivity(showEmpTimeDetailActivity);
//            }
//        });
//
//        //creates new employee
//        addNewEmployee.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), CreateNewEmployee.class);
//                startActivity(intent);
//
//            }
//        });
//    }

}
