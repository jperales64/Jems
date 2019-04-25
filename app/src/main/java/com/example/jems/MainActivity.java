package com.example.jems;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jems.employee.ClockInOut;
import com.example.jems.employee.EmployeeActivity;
import com.facebook.stetho.Stetho;
import com.example.jems.estimator.QuickEstimator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Stetho.initializeWithDefaults(this);
    }

    /** Called when the user taps the quickEstimate button */
    public void startQuickEstimate(View view)
    {
        Intent intent = new Intent(this, QuickEstimator.class);
        startActivity(intent);

    }

    /** Called when the user taps the projectTracker button */
    public void startProjectTracker(View view)
    {
        Intent intent = new Intent(this, ProjectTracker.class);
        startActivity(intent);

    }

    /** Called when the user taps the quickEstimate button */
    public void startCustomerTracker(View view)
    {
        Intent intent = new Intent(this, CustomerTrackerActivity.class);
        startActivity(intent);

    }

    public void startExpenses(View view) {
        Intent intent = new Intent(this, ExpensesActivity.class);
        startActivity(intent);
    }

    public void startSettings(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    /** Called when the user taps the employeeTimesheet button */
    public void startEmployeeTimesheet(View view) {
        Intent intent = new Intent(this, EmployeeActivity.class);
        startActivity(intent);
    }

    public void startClockInOut(View view) {
        Intent intent = new Intent(this, ClockInOut.class);
        startActivity(intent);
    }
}
