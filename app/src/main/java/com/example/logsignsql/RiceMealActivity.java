package com.example.logsignsql;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.logsignsql.adapter.RiceMealCatAdapter;
import com.example.logsignsql.model.RiceMealCat;
import java.util.ArrayList;
import java.util.List;

public class RiceMealActivity extends AppCompatActivity {

    RecyclerView ricemealRecycler;
    RiceMealCatAdapter ricemealCatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rice_meal);

        List<RiceMealCat> ricemealCats = new ArrayList<>();

        ricemealCats.add(new RiceMealCat("Spam", R.drawable.spam));
        ricemealCats.add(new RiceMealCat("Tapsilog", R.drawable.tapsilog));
        ricemealCats.add(new RiceMealCat("Hungarian Sausage", R.drawable.hungariansausage));
        ricemealCats.add(new RiceMealCat("Boneless Chicken", R.drawable.bonelesschicken));
        ricemealCats.add(new RiceMealCat("Herb Roasted Chicken", R.drawable.herbroastedchicken));
        ricemealCats.add(new RiceMealCat("Beef Salpicao", R.drawable.beefsalpicao));
        ricemealCats.add(new RiceMealCat("Baby Back Ribs", R.drawable.babybackribs));

        ricemealRecycler = findViewById(R.id.ricemeal_recyclerview);
        GridLayoutManager ricemealLayoutManager = new GridLayoutManager(this, 2);
        ricemealRecycler.setLayoutManager(ricemealLayoutManager);
        ricemealCatAdapter = new RiceMealCatAdapter(this, ricemealCats);
        ricemealRecycler.setAdapter(ricemealCatAdapter);


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