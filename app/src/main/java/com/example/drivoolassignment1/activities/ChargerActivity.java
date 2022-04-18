package com.example.drivoolassignment1.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.drivoolassignment1.adapters.ChargerListAdapter;
import com.example.drivoolassignment1.models.ChargerModel;
import com.example.drivoolassignment1.R;
import com.example.drivoolassignment1.models.StationModel;

import java.util.ArrayList;

public class ChargerActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ChargerListAdapter chargerListAdapter;
    TextView tvAddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chargers_list);
        tvAddress = findViewById(R.id.tvAddress);

//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        StationModel stationModels = (StationModel) getIntent().getSerializableExtra("CHARGER_LIST");
        tvAddress.setText(stationModels.getAddress());
        getSupportActionBar().setTitle(stationModels.getStationName());

        recyclerView = findViewById(R.id.rvChargersList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<ChargerModel> chargerList = stationModels.getChargersList();

        chargerListAdapter = new ChargerListAdapter(chargerList);
        recyclerView.setAdapter(chargerListAdapter);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}