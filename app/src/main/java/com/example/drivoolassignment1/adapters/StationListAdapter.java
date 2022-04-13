package com.example.drivoolassignment1.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drivoolassignment1.R;
import com.example.drivoolassignment1.activities.ChargerActivity;
import com.example.drivoolassignment1.models.StationModel;

import java.util.ArrayList;

public class StationListAdapter extends RecyclerView.Adapter<StationListAdapter.StationsListViewHolder> {
    ArrayList<StationModel> data;
    Context context;

    public StationListAdapter(ArrayList<StationModel> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public StationsListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_station, parent, false);
        StationsListViewHolder stationsListViewHolder = new StationsListViewHolder(view);
        return stationsListViewHolder;
    }

    @Override
    public void onBindViewHolder(StationsListViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.txtStationsName.setText(data.get(position).getStationName());
        holder.txtAddress.setText(data.get(position).getAddress());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ChargerActivity.class).putExtra("CHARGER_LIST", data.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class StationsListViewHolder extends RecyclerView.ViewHolder {
        TextView txtStationsName;
        TextView txtAddress;
        public StationsListViewHolder(@NonNull View itemView) {
            super(itemView);
            txtStationsName = itemView.findViewById(R.id.stationName);
            txtAddress = itemView.findViewById(R.id.stationAddress);

        }
    }
}
