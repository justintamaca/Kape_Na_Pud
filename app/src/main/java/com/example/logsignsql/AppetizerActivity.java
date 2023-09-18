package com.example.logsignsql;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.logsignsql.adapter.AppetizerCatAdapter;
import com.example.logsignsql.model.AppetizerCat;
import java.util.ArrayList;
import java.util.List;

public class AppetizerActivity extends AppCompatActivity {

    RecyclerView appetizerRecycler;
    AppetizerCatAdapter appetizerCatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appetizer_category);

        List<AppetizerCat> appetizerCats = new ArrayList<>();

        appetizerCats.add(new AppetizerCat("Nachos", R.drawable.nachos));
        appetizerCats.add(new AppetizerCat("Mojos", R.drawable.mojos));
        appetizerCats.add(new AppetizerCat("Truffle Parmesan Fries", R.drawable.trufflefries));
        appetizerCats.add(new AppetizerCat("Cheese Sticks", R.drawable.cheesestick));
        appetizerCats.add(new AppetizerCat("Quesadilla", R.drawable.quesadilla));

        appetizerRecycler = findViewById(R.id.appetizer_recyclerview);
        GridLayoutManager appetizerLayoutManager = new GridLayoutManager(this, 2);
        appetizerRecycler.setLayoutManager(appetizerLayoutManager);
        appetizerCatAdapter = new AppetizerCatAdapter(this, appetizerCats);
        appetizerRecycler.setAdapter(appetizerCatAdapter);

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
