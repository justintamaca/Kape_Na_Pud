package com.example.logsignsql.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.logsignsql.R;
import com.example.logsignsql.model.RiceMealCat;
import com.example.logsignsql.model.SandwichCat;

import java.util.List;

public class SandwichCatAdapter extends RecyclerView.Adapter<SandwichCatAdapter.CategoryViewHolder> {

    private final Context context;
    private final List<SandwichCat> categoryList;

    public SandwichCatAdapter(@NonNull Context context, @NonNull List<SandwichCat> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sandwich, parent, false);
        return new CategoryViewHolder(view);
    }

    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        if (categoryList != null && position >= 0 && position < categoryList.size()) {
            SandwichCat riceMealCat = categoryList.get(position);
            if (riceMealCat != null) {
                if (riceMealCat.getImageurl() != null && holder.categoryImage != null) {
                    holder.categoryImage.setImageResource(riceMealCat.getImageurl());
                }
                if (riceMealCat.getname() != null && holder.name != null) {
                    holder.name.setText(riceMealCat.getname());
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public static final class CategoryViewHolder extends RecyclerView.ViewHolder {

        ImageView categoryImage;
        TextView name;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryImage = itemView.findViewById(R.id.sandwichcategory);
            name = itemView.findViewById(R.id.sandwichcategoryName);
        }
    }
}
