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
import com.example.logsignsql.model.BestSellingFood;

import java.util.List;

public class BestSellingFoodAdapter extends RecyclerView.Adapter<BestSellingFoodAdapter.BestSellingFoodViewHolder> {

    Context context;
    List<BestSellingFood> BestSellingFoodList;



    public BestSellingFoodAdapter(Context context, List<BestSellingFood> bestSellingFoodList) {
        this.context = context;
        BestSellingFoodList = bestSellingFoodList;
    }

    @NonNull
    @Override
    public BestSellingFoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.bsf_row_item, parent, false);
        return new BestSellingFoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BestSellingFoodViewHolder holder, int position) {

        holder.foodImage.setImageResource(BestSellingFoodList.get(position).getImageurl());
        holder.name.setText(BestSellingFoodList.get(position).getName());
        holder.price.setText(BestSellingFoodList.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        return BestSellingFoodList.size();
    }


    public static final class BestSellingFoodViewHolder extends RecyclerView.ViewHolder{

        ImageView foodImage;
        TextView price, name;


        public BestSellingFoodViewHolder(@NonNull View itemView) {
            super(itemView);

            foodImage = itemView.findViewById(R.id.carmach);
            name = itemView.findViewById(R.id.carmachtxt);
            price = itemView.findViewById(R.id.carmachprice);
        }
    }
}
