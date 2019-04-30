package com.example.jems;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class ToDoListAdapter extends RecyclerView.Adapter<ToDoListAdapter.ViewHolder>{

    private List<ToDoItem> toDoStrings;

    ToDoListAdapter(List<ToDoItem> toDoStrings){
        this.toDoStrings = toDoStrings;
    }

    @NonNull
    public ToDoListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.view_todo_list_row, parent, false);

        // Return a new holder instance
        return new ViewHolder(contactView);
    }

    public void onBindViewHolder(@NonNull ToDoListAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        ToDoItem  toDoString = toDoStrings.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.toDoItem;
        textView.setText(toDoString.getToDoItem());

    }

    public int getItemCount() {
        return toDoStrings.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        TextView toDoItem;
        CheckBox toDoCompletChBox;

        ViewHolder(View itemView){
            super(itemView);

            toDoItem = itemView.findViewById(R.id.toDoItem);
            toDoCompletChBox = itemView.findViewById(R.id.toDoCompleteChBox);
        }
    }
}
