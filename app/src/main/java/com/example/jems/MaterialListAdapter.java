package com.example.jems;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MaterialListAdapter extends RecyclerView.Adapter<MaterialListAdapter.ViewHolder> {

    private MaterialList materialList;
    class ViewHolder extends RecyclerView.ViewHolder{
        TextView materialNameTextView;
        TextView materialQtyTextView;
        TextView materialPriceTextView;

        ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            materialNameTextView = itemView.findViewById(R.id.materialNameTextView);
            materialQtyTextView = itemView.findViewById(R.id.materailQtyTextView);
            materialPriceTextView = itemView.findViewById(R.id.materialPriceTextView);
        }
    }

    MaterialListAdapter(MaterialList materialList) {
        this.materialList = materialList;
    }
    @NonNull
    public MaterialListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.view_materal_list_row, parent, false);

        // Return a new holder instance
        return new ViewHolder(contactView);
    }

    public void onBindViewHolder(@NonNull MaterialListAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        MaterialListLineItem material = materialList.get(position);

        // Set item views based on your views and data model
        TextView matName = viewHolder.materialNameTextView;
        matName.setText(material.getName());

        TextView matQty = viewHolder.materialQtyTextView;
        matQty.setText(Integer.toString(material.getQty()));

        TextView matPrice = viewHolder.materialPriceTextView;
        matPrice.setText(material.getCostPerMateral().toString());
    }

    public int getItemCount() {
        return materialList.size();
    }


}
