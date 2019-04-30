package com.example.jems;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class EmployeeActivity extends AppCompatActivity {

    private Employee e;
    private ListView employeeList;
    WorkProjectDatabase wpDb;
    private List<Employee> employees = new ArrayList<>();
    private Button addNewEmployee;
    private static final String TAG = "EmployeeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        addNewEmployee = (Button) findViewById(R.id.addNewEmployeeBtn);

        employeeList = (ListView) findViewById(R.id.employeeList);
        wpDb = WorkProjectDatabase.getInstance(this);
        employees = wpDb.employeeDao().getAll();


        EmployeeTimeSheetAdapter empTimeAdapter = new EmployeeTimeSheetAdapter(this, employees);
        employeeList.setAdapter(empTimeAdapter);

        //opens detailed timesheet of clicked employee
        employeeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent showEmpTimeDetailActivity =
                        new Intent(getApplicationContext(), EmployeeDetailActivity.class);

                Log.i("EmpAct", "Clicked");
                showEmpTimeDetailActivity.putExtra("com.example.jems.EMP_DETAIL_ACT", (Employee) employeeList.getItemAtPosition(i));
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

    @Override
    public void onBackPressed() {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }
}
