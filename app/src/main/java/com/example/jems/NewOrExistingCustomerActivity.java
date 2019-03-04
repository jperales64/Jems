package com.example.jems;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewOrExistingCustomerActivity extends AppCompatActivity {

    private Button createNewCustomerButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_or_existing_customer);
        createNewCustomerButton = findViewById(R.id.newCustomerButton);
        createNewCustomerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewOrExistingCustomerActivity.this,CreateNewCustomerActivity.class);
                startActivity(intent);
            }
        });
    }
}
