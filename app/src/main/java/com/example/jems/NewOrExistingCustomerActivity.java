package com.example.jems;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class NewOrExistingCustomerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_or_existing_customer);
        Button createNewCustomerButton = findViewById(R.id.newCustomerButton);
        Button selectExistingCustomerButton = findViewById(R.id.existingCustomerButton);
        createNewCustomerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewOrExistingCustomerActivity.this,CreateNewCustomerActivity.class);
                startActivity(intent);
            }
        });

        selectExistingCustomerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewOrExistingCustomerActivity.this, ExistingCustomerSelectionActivity.class);
                startActivity(intent);
            }
        });
    }
}
