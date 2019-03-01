package com.example.jems.estimator;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.content.DialogInterface;

import com.example.jems.R;
import com.example.jems.materials.MaterialType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class QuickEstimator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_estimator);

        Button selectProjectButton = (Button) findViewById(R.id.selectProjectButton);
        selectProjectButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                AlertDialog alertDialog = new AlertDialog.Builder(QuickEstimator.this).create();
                alertDialog.setTitle("Select Project Type: ");
                alertDialog.setMessage("This screen will have five buttons that open another " +
                        "alert with further options. At the end of the options, it will pass the" +
                        "selected project price to the estimator screen.");



                alertDialog.show();
            }
        });
    }

}
