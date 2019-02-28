package com.example.jems;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class ToDoListAdapter extends RecyclerView.Adapter<ToDoListAdapter.ViewHolder>{

    private ArrayList<String> toDoStrings;

    public ToDoListAdapter(ArrayList<String> toDoStrings){
        this.toDoStrings = toDoStrings;
    }

    public ToDoListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.view_todo_list_row, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    public void onBindViewHolder(ToDoListAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        String  toDoString = toDoStrings.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.toDoItem;
        textView.setText(toDoString);

    }

    public int getItemCount() {
        return toDoStrings.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView toDoItem;
        public CheckBox toDoCompletChBox;

        public ViewHolder(View itemView){
            super(itemView);

            toDoItem = itemView.findViewById(R.id.toDoItem);
            toDoCompletChBox = itemView.findViewById(R.id.toDoCompleteChBox);
        }
    }
}
