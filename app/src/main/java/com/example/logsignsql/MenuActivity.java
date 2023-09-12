package com.example.logsignsql;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.logsignsql.adapter.BestSellingFoodAdapter;
import com.example.logsignsql.model.BestSellingFood;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    RecyclerView bestsellingRecycler;
    BestSellingFoodAdapter bestSellingFoodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        List<BestSellingFood> bestSellingFoodList = new ArrayList<>();

        bestSellingFoodList.add(new BestSellingFood("Caramel Macchiato", "₱130", R.drawable.carmach));
        bestSellingFoodList.add(new BestSellingFood("Tapsilog", "₱120", R.drawable.tapsilog));
        bestSellingFoodList.add(new BestSellingFood("Spanish Latte", "₱140", R.drawable.spanishlatte));

        setBestsellingRecycler(bestSellingFoodList);

        BottomNavigationView bottomNavigationView = findViewById(R.id.botNatView);
        bottomNavigationView.setSelectedItemId(R.id.bot_menu);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.bot_home) {
                startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else if (item.getItemId() == R.id.bot_menu) {
                return true;
            } else if (item.getItemId() == R.id.bot_cart) {
                startActivity(new Intent(getApplicationContext(), CartActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();                return true;
            } else if (item.getItemId() == R.id.bot_profile) {
                startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            }
            return false;
        });

    }
    private void setBestsellingRecycler(List<BestSellingFood> BestSellingFoodList){

        bestsellingRecycler = findViewById(R.id.bestselling_recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        bestsellingRecycler.setLayoutManager(layoutManager);
        bestSellingFoodAdapter = new BestSellingFoodAdapter(this, BestSellingFoodList);
        bestsellingRecycler.setAdapter(bestSellingFoodAdapter);

    }
}