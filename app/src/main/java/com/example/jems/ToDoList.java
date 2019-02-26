package com.example.jems;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class ToDoList extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<String> toDoList;
    private FloatingActionButton newToDoItemButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);
        recyclerView = (RecyclerView) findViewById(R.id.ToDoRecylceView);
        newToDoItemButton = findViewById(R.id.addNewToDoItem);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        toDoList = new ArrayList<String>();
        toDoList.add("BE Awesome");
        toDoList.add("Finish Deck");
        mAdapter = new ToDoAdapter(toDoList);

        recyclerView.setAdapter(mAdapter);
        newToDoItemButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                final EditText taskEditText = new EditText(ToDoList.this);
                AlertDialog dialog = new AlertDialog.Builder(ToDoList.this)
                        .setTitle("Add a new task")
                        .setMessage("What do you want to do next?")
                        .setView(taskEditText)
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String task = String.valueOf(taskEditText.getText());

                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create();
                dialog.show();
            }
        });


    }

    public void addNewToDoList(){


    }
}
