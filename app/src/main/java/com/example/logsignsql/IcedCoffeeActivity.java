package com.example.logsignsql;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.logsignsql.adapter.IcedCoffeeCatAdapter;
import com.example.logsignsql.model.IcedCoffeeCat;

import java.util.ArrayList;
import java.util.List;

public class IcedCoffeeActivity extends AppCompatActivity {

    RecyclerView icedcoffeeRecycler;
    IcedCoffeeCatAdapter icedCoffeeCatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iced_coffee);

        List<IcedCoffeeCat> icedcoffeeCats = new ArrayList<>();

        icedcoffeeCats.add(new IcedCoffeeCat("Iced Mocha", R.drawable.icedmocha));
        icedcoffeeCats.add(new IcedCoffeeCat("Orange Americano", R.drawable.orangeamericano));
        icedcoffeeCats.add(new IcedCoffeeCat("Cream Cheese Latte", R.drawable.creamcheeselatte));
        icedcoffeeCats.add(new IcedCoffeeCat("Affogato", R.drawable.affogato));
        icedcoffeeCats.add(new IcedCoffeeCat("Iced Latte", R.drawable.icedlatte));
        icedcoffeeCats.add(new IcedCoffeeCat("Iced Spanish Latte", R.drawable.spanishlatte));
        icedcoffeeCats.add(new IcedCoffeeCat("Iced Caramel Latte", R.drawable.icedcaramellatte));
        icedcoffeeCats.add(new IcedCoffeeCat("Iced Cortado", R.drawable.icedcortado));

        icedcoffeeRecycler = findViewById(R.id.icedcoffee_recyclerview);
        GridLayoutManager icedcoffeeLayoutManager = new GridLayoutManager(this, 2);
        icedcoffeeRecycler.setLayoutManager(icedcoffeeLayoutManager);
        icedCoffeeCatAdapter = new IcedCoffeeCatAdapter(this, icedcoffeeCats);
        icedcoffeeRecycler.setAdapter(icedCoffeeCatAdapter);


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