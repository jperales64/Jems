package com.example.jems;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class ToDoListActivity extends AppCompatActivity {
    ArrayList<String> toListStrings;
    ToDoListAdapter adapter;
    private Button addToDoIterm;
    private EditText toDoString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);

        RecyclerView rvToListItems = findViewById(R.id.rv_todo_list);
        rvToListItems.setHasFixedSize(true);
        toListStrings = new ArrayList<>();
        adapter = new ToDoListAdapter(toListStrings);
        rvToListItems.setAdapter(adapter);
        rvToListItems.setLayoutManager(new LinearLayoutManager(this));
        toDoString = findViewById(R.id.toDoString);
        addToDoIterm = findViewById(R.id.addToDoItem);
        addToDoIterm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toListStrings.add(0, toDoString.getText().toString());
                toDoString.getText().clear();
                adapter.notifyItemInserted(0);
            }
        });
    }

}
