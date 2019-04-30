package com.example.jems;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class TimeClockDetailAdapter extends RecyclerView.Adapter<TimeClockDetailAdapter.MyViewHolder> {

    private List<Timesheet> timesheetRow;
    private Employee e;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView date;
        public TextView clockIn;
        public TextView clockOut;
        public TextView hours;

        public MyViewHolder(View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.dateTextView);
            clockIn = itemView.findViewById(R.id.clockInTextView);
            clockOut = itemView.findViewById(R.id.clockOutTextView);
            hours = itemView.findViewById(R.id.hoursTextView);
        }
    }

    public TimeClockDetailAdapter(List<Timesheet>timesheetRow, Employee e) {
        this.timesheetRow = timesheetRow;
        this.e = e;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.time_clock_detail_view, parent, false);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Timesheet currentRow = timesheetRow.get(position);
        String parseIn = currentRow.getClockIn();
        String[] dateIn = parseIn.split(" ");

        String parseOut = currentRow.getClockOut();
        String[] dateOut = parseOut.split(" ");

        String date = dateIn[0];
        String clockIn = dateIn[1];
        String clockOut = dateOut[1];
        String hours = String.valueOf(currentRow.getNumHours());

        holder.date.setText(date);
        holder.clockIn.setText(clockIn);
        holder.clockOut.setText(clockOut);
        holder.hours.setText(hours);

    }

    @Override
    public int getItemCount() {
        return timesheetRow.size();
    }
}
