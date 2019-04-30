package com.example.jems;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class SelectProject extends AppCompatActivity {

    private Button okBtn;
    private List<WorkProject>projects;
    private WorkProject selectedProject;
    private ListView projList;
    WorkProjectDatabase wpDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_project);

        okBtn = (Button) findViewById(R.id.okButton);

        projList = (ListView) findViewById(R.id.projList);
        wpDb = WorkProjectDatabase.getInstance(this);
        projects = wpDb.workProjectDao().getAll();

        SelectProjectAdapter projectAdapter = new SelectProjectAdapter(this, projects);
        projList.setAdapter(projectAdapter);

        //opens detailed timesheet of clicked employee
        projList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent =
                        new Intent(getApplicationContext(), ClockInOut.class);

                intent.putExtra("selected_project", (WorkProject) projList.getItemAtPosition(i));
                startActivity(intent);
            }
        });
    }
}
