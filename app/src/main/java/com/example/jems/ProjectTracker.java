package com.example.jems;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class ProjectTracker extends Activity {

    private List<WorkProject> projects = new ArrayList<WorkProject>();
    private Button addNewProjectButton;
    WorkProjectDatabase wpDb;

    private ProjectAdapter.OnItemClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_tracker);
        RecyclerView rvProjects = (RecyclerView) findViewById(R.id.projectTrackerRv);
        listener = new ProjectAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(WorkProject project, Customer customer) {
                Intent intent = new Intent(ProjectTracker.this, ProjectDisplayActivity.class);
                intent.putExtra("project", project);
                intent.putExtra("customer", customer);
                startActivity(intent);
            }
        };
        addNewProjectButton = findViewById(R.id.createNewProjectButton);
        addNewProjectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProjectTracker.this, NewOrExistingCustomerActivity.class);

                startActivity(intent);
            }
        });

        wpDb = Room.databaseBuilder(getApplicationContext(), WorkProjectDatabase.class, "work_project_db").allowMainThreadQueries().build();


        projects = wpDb.workProjectDao().getAll();
        ProjectAdapter projectAdapter = new ProjectAdapter(projects, listener, wpDb);
        rvProjects.setAdapter(projectAdapter);

        rvProjects.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(ProjectTracker.this, MainActivity.class);
        startActivity(i);
    }
//    final Migration MIGRATION_1_2 =
//            new Migration(1, 2) {
//                @Override
//                public void migrate(@NonNull final SupportSQLiteDatabase database) {
//                    database.execSQL("CREATE TABLE IF NOT EXISTS `customer` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `first_name` TEXT, `last_name` TEXT, `address` TEXT)");
//                }
//            };

}