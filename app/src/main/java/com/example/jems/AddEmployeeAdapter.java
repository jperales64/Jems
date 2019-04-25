package com.example.jems;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AddEmployeeAdapter extends RecyclerView.Adapter<AddEmployeeAdapter.ViewHolder> {

    private final OnItemClickListener listener;
    public interface OnItemClickListener {
        void onItemClick(int empId);
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView nameTextView;

        public ViewHolder(View itemView){
            super(itemView);
            nameTextView = itemView.findViewById(R.id.employeeName);
        }

        void bind(final int empId, final OnItemClickListener listener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(empId);
                }
            });
        }
    }

    private List<Employee> employees;

    public AddEmployeeAdapter(List<Employee> employees, OnItemClickListener listener){
        this.employees = employees;
        this.listener = listener;
    }

    @Override
    public AddEmployeeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.view_employee_row, parent, false);

        // Return a new holder instance
        return new AddEmployeeAdapter.ViewHolder(contactView);
    }




    @Override
    public void onBindViewHolder(@NonNull AddEmployeeAdapter.ViewHolder viewholder, int i) {
        Employee employee = this.employees.get(i);
        viewholder.bind(employee.getEmployeeId(),listener);
        TextView textView = viewholder.nameTextView;
        textView.setText(employee.getFirstName());
    }

    @Override
    public int getItemCount(){
        return employees.size();
    }


}
