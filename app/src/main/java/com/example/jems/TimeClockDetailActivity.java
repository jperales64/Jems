package com.example.jems;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class TimeClockDetailActivity extends AppCompatActivity {

    private RecyclerView timeClockRV;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<Timesheet> timesheetRow;
    private Employee e;

    WorkProjectDatabase wpDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_clock_detail);

        wpDb = WorkProjectDatabase.getInstance(this);

        Intent i = getIntent();
        e = (Employee) i.getParcelableExtra("com.example.jems.employee.TIME_DETAIL");
        timesheetRow = wpDb.timesheetDao().getTSbyEmpId(e.getEmployeeId());

        timeClockRV = findViewById(R.id.timeClockList);
        timeClockRV.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new TimeClockDetailAdapter(timesheetRow, e);

        timeClockRV.setLayoutManager(mLayoutManager);
        timeClockRV.setAdapter(mAdapter);
    }
}
