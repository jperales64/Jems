package com.example.jems;

import android.icu.text.DecimalFormat;
import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClockInOut extends AppCompatActivity {

    private Employee e;
    private WorkProject selectedProject;
    private String projectName;
    private Timesheet newTimeRow;
    private ListView employeeList;
    private TextView clockTextView;

    WorkProjectDatabase wpDb;
    private List<Employee> employees = new ArrayList<>();
    private List<WorkProject> projects = new ArrayList<>();
    private List<EmployeesOnTheClock> clockedInEmpList = new ArrayList<>();
    private ClockInAdapter clockInAdapter;

    private static final String TAG = "ClockInOut";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock_in_out);

        employeeList = (ListView) findViewById(R.id.empClockInList);
        clockTextView = (TextView) findViewById(R.id.clockTextView);

        wpDb = WorkProjectDatabase.getInstance(this);
        employees = wpDb.employeeDao().getAll();
        projects = wpDb.workProjectDao().getAll();
        clockedInEmpList = wpDb.onTheClockDao().getAll();
//        clockTextView.setText(clock);

        clockInAdapter = new ClockInAdapter(this, employees, projects, clockedInEmpList);
        employeeList.setAdapter(clockInAdapter);

        employeeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                e = wpDb.employeeDao().getEmpById(employees.get(position).getEmployeeId());
                
                if(!findEmpId(clockedInEmpList, e.getEmployeeId())) {
                    //Create new Timesheet Row for employee
                    newTimeRow = new Timesheet(e.getEmployeeId());

                    //Set local instance of timeId
                    long timesheetId = wpDb.timesheetDao().insert(newTimeRow);
                    int timeId = (int) timesheetId;
                    newTimeRow.setTimeId(timeId);

                    //Update clockIn time
                    String clockInTime = newTimeRow.getClockIn();
                    wpDb.timesheetDao().updateClockIn(clockInTime, timeId);

                    //Add employee to list of employees that are clocked in
                    EmployeesOnTheClock clockedInEmp = new EmployeesOnTheClock(timeId, newTimeRow.getEmpId());
                    wpDb.onTheClockDao().insert(clockedInEmp);
                    clockedInEmpList.add(clockedInEmp);

                    List<EmployeesOnTheClock> currentListOfAllEmpsOnClock = wpDb.onTheClockDao().getAll();
                    Timesheet t = wpDb.timesheetDao().getTimesheet(timeId);

                    Log.i(TAG, "onItemClick: " + e.getFirstName() + " clocked in");
                    clockInAdapter.notifyDataSetChanged();
                } else {
                    //Set local var to employee found in list of clocked in employees
                    EmployeesOnTheClock clockOutEmp = getTimeIdByEmpId(clockedInEmpList, e.getEmployeeId());

                    //Find the timesheet of this instance of employee in timesheet table
                    int timesheetId = clockOutEmp.getTsId();
                    Timesheet clockOutTime = wpDb.timesheetDao().getTimesheet(timesheetId);

                    //Update clockout time
                    String out = getCurrentTimeStamp();
                    clockOutTime.setClockOut(out);
                    wpDb.timesheetDao().updateClockOut(out, timesheetId);

                    //find hours and update
                    double hours = getHours(clockOutTime.getClockIn(), clockOutTime.getClockOut());
                    clockOutTime.setNumHours(hours);
                    wpDb.timesheetDao().update(clockOutTime);

                    //remove employee from list of clocked in employees
                    wpDb.onTheClockDao().delete(clockOutEmp);
                    clockedInEmpList.remove(clockOutEmp);

                    Log.i(TAG, "onItemClick: " + e.getFirstName() + " clocked out");
                    Log.i(TAG, "clockIn: " + clockOutTime.getClockIn() + " clockOut: " + clockOutTime.getClockOut() + " hours: " + clockOutTime.getNumHours());
                    clockInAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    private static String getCurrentTimeStamp(){
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return dateFormat.format(new Date());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // determines if employeeId is in onTheClock table
    // returns timesheetId
    public EmployeesOnTheClock getTimeIdByEmpId(List<EmployeesOnTheClock> empsOnClock, int empId) {
        for (EmployeesOnTheClock emp:empsOnClock) {
            if(emp.getEmpId() == empId)
                return emp;
        }
        return null;
    }

    public boolean findEmpId(List<EmployeesOnTheClock> empsOnClock, int empId) {
        for (EmployeesOnTheClock emp:empsOnClock) {
            if(emp.getEmpId() == empId)
                return true;
        }
        return false;
    }

    public double getHours(String clockIn, String clockOut) {
        Log.i(TAG, "getHours: clockin:" + clockIn + " clockout:" + clockOut );
        String[] in = clockIn.split(" ");
        String[] hrMinIn = in[1].split(":");
        int hoursIn = Integer.valueOf(hrMinIn[0]);
        int minIn = Integer.valueOf(hrMinIn[1]);
        int totalMinIn = (hoursIn * 60) + minIn;

        String[] out = clockOut.split(" ");
        String[] hrMinOut = out[1].split(":");
        int hoursOut = Integer.valueOf(hrMinOut[0]);
        int minOut = Integer.valueOf(hrMinOut[1]);
        int totalMinOut = (hoursOut * 60) + minOut;

        double hours = (double)(totalMinOut - totalMinIn)/60;

        DecimalFormat df = new DecimalFormat("##.##");
        df.format(hours);
        return hours;
    }
}
