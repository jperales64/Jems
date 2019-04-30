package com.example.jems;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(WorkProject project, Customer customer);
    }

    private final List<WorkProject> items;
    private final OnItemClickListener listener;
    private WorkProjectDatabase wpdb;


    ProjectAdapter(List<WorkProject> items, OnItemClickListener listener, WorkProjectDatabase wpdb) {
        this.items = items;
        this.listener = listener;
        this.wpdb = wpdb;
    }

    @NonNull
    @Override public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_project_tracker_row, parent, false);
        return new ViewHolder(v);
    }

    @Override public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        WorkProject p = wpdb.workProjectDao().getProjById(items.get(position).getId());
        TextView projName = holder.jobInfo;
        projName.setText(p.getProjectName());

        int cId = p.getCustomerID();
        Customer c = wpdb.customerDao().getCustbyId(cId);
        holder.bind(items.get(position), c, listener);
        TextView cName = holder.custName;
        String cNameStr = c.getFirstName() + " " + c.getLastName();
        cName.setText(cNameStr);

//        Customer tempCust = (wpdb.customerDao().getCustbyId(items.get(position).getCustomerID()));
//        holder.bind(items.get(position), tempCust, listener);
//        TextView custName = holder.custName;
//        String custNameStr  = tempCust.getFirstName() + " " + tempCust.getLastName();
//        custName.setText(custNameStr);
//        TextView custAddress = holder.jobInfo;
//        custAddress.setText(tempCust.getCustAddress());
    }

    @Override public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView custName;
        private TextView jobInfo;

        ViewHolder(View itemView) {
            super(itemView);
            custName = itemView.findViewById(R.id.customerNameTextView);
            jobInfo = itemView.findViewById(R.id.projectInfoTextView);
        }

        void bind(final WorkProject item, final Customer customer, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(item, customer );
                }
            });
        }
    }
}