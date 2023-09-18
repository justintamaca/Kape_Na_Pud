package com.example.logsignsql;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.logsignsql.adapter.NonicedCoffeeCatAdapter;
import com.example.logsignsql.model.NonicedCoffeeCat;

import java.util.ArrayList;
import java.util.List;

public class NonicedCoffeeActivity extends AppCompatActivity {

    RecyclerView nonicedcoffeeRecycler;
    NonicedCoffeeCatAdapter nonicedCoffeeCatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noniced_coffee);

        List<NonicedCoffeeCat> nonicedcoffeeCats = new ArrayList<>();

        nonicedcoffeeCats.add(new NonicedCoffeeCat("Iced Chocolate", R.drawable.icedchocolate));
        nonicedcoffeeCats.add(new NonicedCoffeeCat("Iced Matcha", R.drawable.icedmatcha));
        nonicedcoffeeCats.add(new NonicedCoffeeCat("Cucumber Soda", R.drawable.cucumbersoda));
        nonicedcoffeeCats.add(new NonicedCoffeeCat("Orange Soda ", R.drawable.orangesoda));


        nonicedcoffeeRecycler = findViewById(R.id.nonicedcoffee_recyclerview);
        GridLayoutManager icedcoffeeLayoutManager = new GridLayoutManager(this, 2);
        nonicedcoffeeRecycler.setLayoutManager(icedcoffeeLayoutManager);
        nonicedCoffeeCatAdapter = new NonicedCoffeeCatAdapter(this, nonicedcoffeeCats);
        nonicedcoffeeRecycler.setAdapter(nonicedCoffeeCatAdapter);


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