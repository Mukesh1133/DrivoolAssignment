package com.example.drivoolassignment1.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drivoolassignment1.R;
import com.example.drivoolassignment1.models.ChargerModel;

import java.util.ArrayList;

public class ChargerListAdapter extends RecyclerView.Adapter<ChargerListAdapter.ChargerListViewHolder> {
    ArrayList<ChargerModel> list;

    public ChargerListAdapter(ArrayList<ChargerModel> list) {
        this.list = list;
    }

    @Override
    public ChargerListViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_charger, parent, false);
        ChargerListViewHolder chargerList = new ChargerListViewHolder(view);
        return chargerList;
    }

    @Override
    public void onBindViewHolder( ChargerListViewHolder holder, int position) {
        ChargerModel chargerModel = list.get(position);
        holder.txtName.setText(chargerModel.getName());
        holder.txtType.setText(chargerModel.getTypeOfCharger());
        holder.txtAvailability.setText(chargerModel.getAvailability());

        if (chargerModel.getAvailability().equalsIgnoreCase("free")) {
            holder.txtAvailability.setTextColor(ContextCompat.getColor(holder.txtAvailability.getContext(), R.color.green));
        } else {
            holder.txtAvailability.setTextColor(ContextCompat.getColor(holder.txtAvailability.getContext(), R.color.red));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ChargerListViewHolder extends RecyclerView.ViewHolder {
        TextView txtName;
        TextView txtType;
        TextView txtAvailability;
        public ChargerListViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtType = itemView.findViewById(R.id.txtType);
            txtAvailability = itemView.findViewById(R.id.txtAvailability);
        }
    }
}
