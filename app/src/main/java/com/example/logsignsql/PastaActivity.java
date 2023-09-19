package com.example.logsignsql;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.logsignsql.adapter.PastaCatAdapter;
import com.example.logsignsql.model.PastaCat;


import java.util.ArrayList;
import java.util.List;

public class PastaActivity extends AppCompatActivity {

    RecyclerView pastaRecycler;
    PastaCatAdapter pastaCatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasta);

        List<PastaCat> pastaCats = new ArrayList<>();

        pastaCats.add(new PastaCat("Pasta Bolognese", R.drawable.pastabolognese));
        pastaCats.add(new PastaCat("Aglio Olio", R.drawable.aglioolio));
        pastaCats.add(new PastaCat("Truffle Cream Pasta", R.drawable.trufflecreampasta));
        pastaCats.add(new PastaCat("Lasagna", R.drawable.lasagna));
        pastaCats.add(new PastaCat("Chicken Pesto Penne", R.drawable.chickenpestopene));
        pastaCats.add(new PastaCat("Shrimp Scampi Linguine", R.drawable.shrimpscampilinguine));
        pastaCats.add(new PastaCat("Carbonara", R.drawable.carbonara));


        pastaRecycler = findViewById(R.id.pasta_recyclerview);
        GridLayoutManager pastaLayoutManager = new GridLayoutManager(this, 2);
        pastaRecycler.setLayoutManager(pastaLayoutManager);
        pastaCatAdapter = new PastaCatAdapter(this, pastaCats);
        pastaRecycler.setAdapter(pastaCatAdapter);


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