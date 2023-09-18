package com.example.logsignsql;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.logsignsql.adapter.CategoryAdapter;
import com.example.logsignsql.adapter.BestSellingFoodAdapter;
import com.example.logsignsql.model.BestSellingFood;
import com.example.logsignsql.model.Category;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    RecyclerView bestsellingRecycler, categoriesRecycler;
    BestSellingFoodAdapter bestSellingFoodAdapter;
    CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        List<BestSellingFood> bestSellingFoodList = new ArrayList<>();

        bestSellingFoodList.add(new BestSellingFood("Caramel Macchiato", "₱130", R.drawable.carmach));
        bestSellingFoodList.add(new BestSellingFood("Tapsilog", "₱120", R.drawable.tapsilog));
        bestSellingFoodList.add(new BestSellingFood("Spanish Latte", "₱140", R.drawable.spanishlatte));

        bestsellingRecycler = findViewById(R.id.bestselling_recyclerview);
        RecyclerView.LayoutManager bestSellingLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        bestsellingRecycler.setLayoutManager(bestSellingLayoutManager);
        bestSellingFoodAdapter = new BestSellingFoodAdapter(this, bestSellingFoodList);
        bestsellingRecycler.setAdapter(bestSellingFoodAdapter);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category("Appetizer", R.drawable.appetizer));
        categoryList.add(new Category("Pasta", R.drawable.pasta));
        categoryList.add(new Category("Rice Meal", R.drawable.ricemeal));
        categoryList.add(new Category("Sandwich", R.drawable.sandwich));
        categoryList.add(new Category("Hot Coffee", R.drawable.hotcoffee));
        categoryList.add(new Category("Iced Coffee", R.drawable.icedcoffee));
        categoryList.add(new Category("Non-iced Coffee", R.drawable.nonicedcoffee));
        categoryList.add(new Category("Milkshake", R.drawable.milkshake));

        categoriesRecycler = findViewById(R.id.categories_recyclerview);
        RecyclerView.LayoutManager categoryLayoutManager = new GridLayoutManager(this, 4);
        categoriesRecycler.setLayoutManager(categoryLayoutManager);
        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoriesRecycler.setAdapter(categoryAdapter);

        BottomNavigationView bottomNavigationView = findViewById(R.id.botNatView);
        bottomNavigationView.setSelectedItemId(R.id.bot_menu);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.bot_home) {
                startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else if (item.getItemId() == R.id.bot_menu) {
                startActivity(new Intent(getApplicationContext(), MenuActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else if (item.getItemId() == R.id.bot_cart) {
                startActivity(new Intent(getApplicationContext(), CartActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else if (item.getItemId() == R.id.bot_profile) {
                return true;
            }
            return false;
        });

        categoryAdapter.setOnItemClickListener(new CategoryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Category clickedCategory = categoryList.get(position);
                String categoryName = clickedCategory.getname();
                if ("Appetizer".equals(categoryName)) {
                    startActivity(new Intent(MenuActivity.this, AppetizerActivity.class));
                } else if ("Pasta".equals(categoryName)) {
                    // Redirect to PastaActivity or the appropriate activity
                }
                // Add more conditions for other categories as needed
            }
        });
    }
}
