package com.example.logsignsql;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.logsignsql.adapter.HotCoffeeCatAdapter;
import com.example.logsignsql.model.HotCoffeeCat;
import java.util.ArrayList;
import java.util.List;

public class HotCoffeeActivity extends AppCompatActivity {

    RecyclerView hotcoffeeRecycler;
    HotCoffeeCatAdapter hotCoffeeCatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_coffee);

        List<HotCoffeeCat> hotcoffeeCats = new ArrayList<>();

        hotcoffeeCats.add(new HotCoffeeCat("Cortado", R.drawable.cortado));
        hotcoffeeCats.add(new HotCoffeeCat("Americano", R.drawable.americano));
        hotcoffeeCats.add(new HotCoffeeCat("Flat White", R.drawable.flatwhite));
        hotcoffeeCats.add(new HotCoffeeCat("Cappuccino", R.drawable.cappuccino));
        hotcoffeeCats.add(new HotCoffeeCat("Latte", R.drawable.latte));
        hotcoffeeCats.add(new HotCoffeeCat("Spanish Latte", R.drawable.hotspanishlatte));
        hotcoffeeCats.add(new HotCoffeeCat("Caramel Latte", R.drawable.caramellatte));
        hotcoffeeCats.add(new HotCoffeeCat("Mocha Latte", R.drawable.mocha));

        hotcoffeeRecycler = findViewById(R.id.hotcoffee_recyclerview);
        GridLayoutManager hotcoffeeLayoutManager = new GridLayoutManager(this, 2);
        hotcoffeeRecycler.setLayoutManager(hotcoffeeLayoutManager);
        hotCoffeeCatAdapter = new HotCoffeeCatAdapter(this, hotcoffeeCats);
        hotcoffeeRecycler.setAdapter(hotCoffeeCatAdapter);


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