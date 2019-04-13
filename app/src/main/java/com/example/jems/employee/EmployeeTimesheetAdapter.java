package com.example.jems.employee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.jems.R;

import java.util.ArrayList;
import java.util.List;

public class EmployeeTimesheetAdapter extends BaseAdapter {

    List<Employee> employees = new ArrayList<>();
    LayoutInflater mInflater;

    public EmployeeTimesheetAdapter(Context c, List<Employee> emp) {
        employees = emp;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return employees.size();
    }

    @Override
    public Object getItem(int i) {
        return employees.get(i);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = mInflater.inflate(R.layout.employee_listview_detail, null);
        TextView nameTextView = (TextView) v.findViewById(R.id.detailNameTextView);

        Employee e = employees.get(i);
        String name = e.getFirstName() + " " + e.getLastName();

        nameTextView.setText(name);

        return v;
    }
}
