package com.example.jems;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class ToDoListActivity extends AppCompatActivity {
    List<ToDoItem> toListStrings;
    ToDoListAdapter adapter;
    private Button addToDoIterm;
    private EditText toDoString;
    WorkProjectDatabase wpDb;
    private int projectId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);
        wpDb = WorkProjectDatabase.getInstance(this);


        Bundle extras = getIntent().getExtras();
        this.projectId = extras.getInt("projectId");
        RecyclerView rvToListItems = findViewById(R.id.rv_todo_list);
        rvToListItems.setHasFixedSize(true);
        toListStrings = wpDb.toDoListDao().getAll();
        adapter = new ToDoListAdapter(toListStrings);
        rvToListItems.setAdapter(adapter);
        rvToListItems.setLayoutManager(new LinearLayoutManager(this));
        toDoString = findViewById(R.id.toDoString);
        addToDoIterm = findViewById(R.id.addToDoItem);
        addToDoIterm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txd = toDoString.getText().toString();
                System.out.println("textview text = " + txd);
                if(!(toDoString.getText().toString().isEmpty())) {
                    ToDoItem newToDoItem = new ToDoItem(toDoString.getText().toString(), ToDoListActivity.this.projectId);
                    toListStrings.add(0, newToDoItem);
                    wpDb.toDoListDao().insert(newToDoItem);
                    toDoString.getText().clear();
                    adapter.notifyItemInserted(0);
                }
            }
        });

    }

}
