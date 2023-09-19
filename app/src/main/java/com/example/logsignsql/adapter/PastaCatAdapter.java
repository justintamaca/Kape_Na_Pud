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
import com.example.logsignsql.model.PastaCat;

import java.util.List;

public class PastaCatAdapter extends RecyclerView.Adapter<PastaCatAdapter.CategoryViewHolder> {

    private final Context context;
    private final List<PastaCat> categoryList;

    public PastaCatAdapter(@NonNull Context context, @NonNull List<PastaCat> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pasta, parent, false);
        return new CategoryViewHolder(view);
    }

    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        if (categoryList != null && position >= 0 && position < categoryList.size()) {
            PastaCat hotCoffeeCat = categoryList.get(position);
            if (hotCoffeeCat != null) {
                if (hotCoffeeCat.getImageurl() != null && holder.categoryImage != null) {
                    holder.categoryImage.setImageResource(hotCoffeeCat.getImageurl());
                }
                if (hotCoffeeCat.getname() != null && holder.name != null) {
                    holder.name.setText(hotCoffeeCat.getname());
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
            categoryImage = itemView.findViewById(R.id.pastacategory);
            name = itemView.findViewById(R.id.pastacategoryName);
        }
    }
}
