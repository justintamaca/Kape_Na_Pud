package com.example.logsignsql;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.logsignsql.adapter.SandwichCatAdapter;
import com.example.logsignsql.model.SandwichCat;
import java.util.ArrayList;
import java.util.List;

public class SandwichActivity extends AppCompatActivity {

    RecyclerView sandwichRecycler;
    SandwichCatAdapter sandwichCatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sandwich);

        List<SandwichCat> sandwichCats = new ArrayList<>();

        sandwichCats.add(new SandwichCat("Cheesy Hungarian", R.drawable.cheesyhungarian));
        sandwichCats.add(new SandwichCat("Philly Cheesesteak", R.drawable.phillycheesesteak));
        sandwichCats.add(new SandwichCat("Truffle Grilled Cheese", R.drawable.trufflegrilledcheese));
        sandwichCats.add(new SandwichCat("TLC", R.drawable.tlc));
        sandwichCats.add(new SandwichCat("Monte Cristo", R.drawable.montecristo));

        sandwichRecycler = findViewById(R.id.sandwich_recyclerview);
        GridLayoutManager sandwichLayoutManager = new GridLayoutManager(this, 2);
        sandwichRecycler.setLayoutManager(sandwichLayoutManager);
        sandwichCatAdapter = new SandwichCatAdapter(this, sandwichCats);
        sandwichRecycler.setAdapter(sandwichCatAdapter);


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