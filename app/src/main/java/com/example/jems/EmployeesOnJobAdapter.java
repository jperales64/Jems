package com.example.jems;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class EmployeesOnJobAdapter extends RecyclerView.Adapter<EmployeesOnJobAdapter.ViewHolder> {

   private List<Employee> employees;

   EmployeesOnJobAdapter(List<Employee> employees){
       this.employees = employees;
   }

    @NonNull
    public EmployeesOnJobAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.view_employee_row, parent, false);

        // Return a new holder instance
        return new ViewHolder(contactView);
    }

    public void onBindViewHolder(@NonNull EmployeesOnJobAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Employee employee = employees.get(position);

        // Set item views based on your views and data model
        TextView nameTextView = viewHolder.employeeNameTextView;
        nameTextView.setText(employee.getFirstName());
        //TextView hoursTextView = viewHolder.hoursWorkedTextView;

    }

    public int getItemCount() {
        return employees.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        TextView employeeNameTextView;
        TextView hoursWorkedTextView;

        ViewHolder(View itemView){
            super(itemView);
            employeeNameTextView = itemView.findViewById(R.id.employeeName);
            hoursWorkedTextView = itemView.findViewById(R.id.numOfHoursOnJobTextView);
        }
    }
}
