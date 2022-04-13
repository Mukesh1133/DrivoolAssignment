package com.example.drivoolassignment1.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.drivoolassignment1.data.DataProvider;
import com.example.drivoolassignment1.models.ChargerModel;
import com.example.drivoolassignment1.R;
import com.example.drivoolassignment1.adapters.StationListAdapter;
import com.example.drivoolassignment1.models.StationModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class StationActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    StationListAdapter stationsListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stations_list);

        ArrayList<StationModel> stationModels = new ArrayList<>();
        recyclerView = findViewById(R.id.rvStationsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        try {
            JSONArray arr = new JSONArray(DataProvider.json);
            for (int i = 0; i < arr.length(); i++) {
                JSONObject jsonObject = arr.getJSONObject(i);
                String stationName = jsonObject.optString("stationName");
                String address = jsonObject.getString("address");
                JSONArray listOfChargers = jsonObject.getJSONArray("listOfChargers");

                ArrayList<ChargerModel> chargerModelList = new ArrayList<>();
                for (int j = 0; j < listOfChargers.length(); j++) {
                    JSONObject jsonOb = listOfChargers.getJSONObject(j);
                    String chargerName = jsonOb.getString("name");
                    String type = jsonOb.getString("type");
                    String availability = jsonOb.getString("availability");

                    chargerModelList.add(new ChargerModel(chargerName, type, availability));
                    Log.d("TAG", chargerModelList.toString());
                }
                stationModels.add(new StationModel(stationName, address, chargerModelList));
            }
            stationsListAdapter = new StationListAdapter(stationModels, this);
            recyclerView.setAdapter(stationsListAdapter);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}