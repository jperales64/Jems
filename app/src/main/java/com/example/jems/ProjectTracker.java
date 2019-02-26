package com.example.jems;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ProjectTracker extends Activity {
    WorkProject project2 = new WorkProject();
    private ArrayList<WorkProject> projects = new ArrayList<WorkProject>();

    private  WorkProject project = new WorkProject();
    private ProjectAdapter.OnItemClickListener listener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        project2.setCustName("PIE");
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

        projects.add(project);
        projects.add(project2);
        projects.add(project);
        ProjectAdapter projectAdapter = new ProjectAdapter(projects, listener);
        rvProjects.setAdapter(projectAdapter);

        rvProjects.setLayoutManager(new LinearLayoutManager(this));
    }
}
