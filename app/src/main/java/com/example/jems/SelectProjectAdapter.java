package com.example.jems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SelectProjectAdapter extends BaseAdapter {

    List<WorkProject> projects = new ArrayList<>();
    LayoutInflater mInflater;

    public SelectProjectAdapter(Context c, List<WorkProject> proj) {
        projects = proj;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

    @Override
    public int getCount() {
        return projects.size();
    }

    @Override
    public Object getItem(int i) {
        return projects.get(i);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = mInflater.inflate(R.layout.employee_listview_detail, null);
        TextView projectTextView = (TextView) v.findViewById(R.id.detailNameTextView);

        WorkProject p = projects.get(i);
        String pName = p.getProjectName();

        projectTextView.setText(pName);

        return v;
    }
}
