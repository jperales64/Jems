package com.example.jems;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the quickEstimate button */
    public void startQuickEstimate(View view)
    {
        Intent intent = new Intent(this, QuickEstimator.class);
        startActivity(intent);

    }

    /** Called when the user taps the quickEstimate button */
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
}
