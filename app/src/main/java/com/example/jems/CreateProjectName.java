package com.example.jems;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateProjectName extends AppCompatActivity {
    private EditText projName;
    private Button ok;
    WorkProjectDatabase wpDb;

    private WorkProject p;
    private Customer c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_project_name);

        Intent i = getIntent();
        c = (Customer) i.getParcelableExtra("customer");
        p = (WorkProject) i.getParcelableExtra("project");

        wpDb = WorkProjectDatabase.getInstance(this);

        ok = findViewById(R.id.okProjBtn);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                projName = findViewById(R.id.projectNameET);
                String pName = projName.getText().toString();

                p.setProjectName(pName);
                wpDb.workProjectDao().update(p);
                Intent intent = new Intent(getApplicationContext(), ProjectDisplayActivity.class);
                intent.putExtra("project", p);
                intent.putExtra("customer", c);
                startActivity(intent);
            }
        });
    }
}
