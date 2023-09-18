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
import com.example.logsignsql.model.AppetizerCat;

import java.util.List;

public class AppetizerCatAdapter extends RecyclerView.Adapter<AppetizerCatAdapter.CategoryViewHolder> {

    Context context;
    List<AppetizerCat> categoryList;

    public AppetizerCatAdapter(Context context, List<AppetizerCat> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

        holder.categoryImage.setImageResource(categoryList.get(position).getImageurl());
        holder.name.setText(categoryList.get(position).getname());

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }


    public static final class CategoryViewHolder extends RecyclerView.ViewHolder{


        ImageView categoryImage;
        TextView name;


        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            categoryImage = itemView.findViewById(R.id.appetizercategory);
            name = itemView.findViewById(R.id.appetizercategoryName);
        }
    }

}


