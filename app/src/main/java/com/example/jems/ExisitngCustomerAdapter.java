package com.example.jems;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ExisitngCustomerAdapter extends RecyclerView.Adapter<ExisitngCustomerAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(Customer customer);
    }

    private final List<Customer> existingCusts;
    private final OnItemClickListener listener;

    ExisitngCustomerAdapter(List<Customer> existingCusts, OnItemClickListener listener) {
        this.existingCusts = existingCusts;
        this.listener = listener;
    }

    @NonNull
    @Override public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_exisitng_customer_row, parent, false);
        return new ViewHolder(v);
    }

    @Override public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get the data model based on position
        Customer customer = existingCusts.get(position);

        // Set item views based on your views and data model
        TextView custName = holder.custName;
        String custNameSrtr = customer.getFirstName() + " " + customer.getLastName();
        custName.setText(custNameSrtr);

        TextView custAddress = holder.custAddress;
        custAddress.setText(customer.getCustAddress());

        holder.bind(customer, listener);
    }


    @Override public int getItemCount() {
        return existingCusts.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView custName;
        private TextView custAddress;

        ViewHolder(View itemView) {
            super(itemView);
            custName =  itemView.findViewById(R.id.existingCustName);
            custAddress = itemView.findViewById(R.id.existingCustAddress);
        }

        void bind(final Customer customer, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(customer);
                }
            });
        }
    }
}