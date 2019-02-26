package com.example.jems;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(WorkProject project);
    }

    private final List<WorkProject> items;
    private final OnItemClickListener listener;

    public ProjectAdapter(List<WorkProject> items, OnItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_project_tracker_row, parent, false);
        return new ViewHolder(v);
    }

    @Override public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(items.get(position), listener);
    }

    @Override public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView custName;
        private TextView jobInfo;

        public ViewHolder(View itemView) {
            super(itemView);
            custName = (TextView) itemView.findViewById(R.id.customerNameTextView);
            jobInfo = (TextView) itemView.findViewById(R.id.projectInfoTextView);
        }

        public void bind(final WorkProject item, final OnItemClickListener listener) {
            custName.setText(item.getCustomerName());
            jobInfo.setText(item.getCustomerName());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }
}