package com.example.jems;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class ProjectTracker extends Activity {
    WorkProject project2 = new WorkProject(12.3, 4.3, "Al Bundy", "9764 Jeopardy Lane");
    WorkProject project = new WorkProject(70.5, 14.1, "George Jetson", "2062 SkyPad Apts");
    WorkProject project3 = new WorkProject(32.3, 42.3, "Nigel Thornberry", "300 Smashing Ln");
    WorkProject project4 = new WorkProject(19.7, 25.6, "Jean-Luc Picard", "1701 Enterprise");
    private ArrayList<WorkProject> projects = new ArrayList<WorkProject>();
    private Button addNewProjectButton;


    private ProjectAdapter.OnItemClickListener listener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_tracker);
        RecyclerView rvProjects = (RecyclerView) findViewById(R.id.projectTrackerRv);
        listener = new ProjectAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(WorkProject project) {
                Intent intent = new Intent(ProjectTracker.this,ProjectDisplayActivity.class);
                intent.putExtra("project", project);
                startActivity(intent);
            }
        };
        addNewProjectButton = findViewById(R.id.createNewProjectButton);
        addNewProjectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProjectTracker.this,NewOrExistingCustomerActivity.class);

                startActivity(intent);
            }
        });
        projects.add(project);
        projects.add(project2);
        projects.add(project3);
        projects.add(project4);
        ProjectAdapter projectAdapter = new ProjectAdapter(projects, listener);
        rvProjects.setAdapter(projectAdapter);

        rvProjects.setLayoutManager(new LinearLayoutManager(this));
    }
}
