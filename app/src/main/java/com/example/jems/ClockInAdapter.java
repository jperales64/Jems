package com.example.jems;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.jems.Employee;
import com.example.jems.R;

import java.util.ArrayList;
import java.util.List;

public class ClockInAdapter extends BaseAdapter {

    List<Employee> employees = new ArrayList<>();
    List<EmployeesOnTheClock> clockedInEmp = new ArrayList<>();
    LayoutInflater mInflater;

    String clock;
    TextView clockTextView;
    TextView projectTextView;
    TextView nameTextView;
    List<WorkProject> projects;
    WorkProject selectedProject;
    private static final String TAG = "ClockInAdapter";

    WorkProjectDatabase wpDb;

    public ClockInAdapter(Context c, List<Employee> emp, List<WorkProject> projects, List<EmployeesOnTheClock> clockedInEmp) {
        employees = emp;
        this.projects = projects;
        this.clock = clock;
        this.clockedInEmp = clockedInEmp;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return employees.size();
    }

    @Override
    public Object getItem(int i) {
        return employees.get(i);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if( view == null)
            view = mInflater.inflate(R.layout.emp_clock_detail, null);

        nameTextView = (TextView) view.findViewById(R.id.empNameTextView);
        projectTextView = (TextView) view.findViewById(R.id.projectTextView);
        clockTextView = (TextView) view.findViewById(R.id.clockTextView);

        Employee e = employees.get(i);
        String name = e.getFirstName() + " " + e.getLastName();
        nameTextView.setText(name);
        
        if(findEmpId(clockedInEmp, e.getEmployeeId())) {
            clockTextView.setText("Clock Out");
            projectTextView.setText("Employee is Clocked In");
        }
        else {
            clockTextView.setText("Clock In");
            projectTextView.setText("Employee is Clocked Out");
        }
        return view;
    }
    
    public boolean findEmpId(List<EmployeesOnTheClock> empsOnClock, int empId) {
        for (EmployeesOnTheClock emp:empsOnClock) {
            if(emp.getEmpId() == empId)
                return true;
        }
        return false;
    }
}








//        clockInOutBtn = (Button) view.findViewById(R.id.clockInOutBtn);
//        clockInOutBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (clockInOutBtn.getText().toString().equalsIgnoreCase("Clock In")) {
//
//                    AlertDialog.Builder builder = new AlertDialog.Builder(ClockInOut);
//                    builder.setTitle("Select Project");
//                    builder.setItems(projects, new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int i) {
//                            selectedProject = projects.get(i).getProjectName();
//                        }
//                    });
//                    AlertDialog dialog = builder.create();
//                    dialog.show();
//                }
//            }
//        });