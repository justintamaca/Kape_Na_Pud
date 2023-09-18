package com.example.logsignsql;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.logsignsql.adapter.MilkshakeCatAdapter;
import com.example.logsignsql.model.MilkshakeCat;


import java.util.ArrayList;
import java.util.List;

public class MilkshakeActivity extends AppCompatActivity {

    RecyclerView milkshakeRecycler;
    MilkshakeCatAdapter milkshakeCatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milkshake);

        List<MilkshakeCat> milkshakeCats = new ArrayList<>();

        milkshakeCats.add(new MilkshakeCat("Espresso Milkshake", R.drawable.espressomilkshake));
        milkshakeCats.add(new MilkshakeCat("Matcha Milkshake", R.drawable.matchamilkshake));
        milkshakeCats.add(new MilkshakeCat("Oreo Milkshake", R.drawable.oreomilkshake));


        milkshakeRecycler = findViewById(R.id.milkshake_recyclerview);
        GridLayoutManager icedcoffeeLayoutManager = new GridLayoutManager(this, 2);
        milkshakeRecycler.setLayoutManager(icedcoffeeLayoutManager);
        milkshakeCatAdapter = new MilkshakeCatAdapter(this, milkshakeCats);
        milkshakeRecycler.setAdapter(milkshakeCatAdapter);


        ImageView backButton = findViewById(R.id.backbutton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}