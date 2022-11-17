package com.example.foodorder;

import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {

    ArrayList<FoodDomain> PopularFood;

    public PopularAdapter(ArrayList<FoodDomain> PopularFood) {

        this.PopularFood = PopularFood;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular,  parent,false);
        return new ViewHolder(inflate);

    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int  position) {
        holder.title.setText(PopularFood.get(position).getTitle());
        holder.fee.setText(String.valueOf(PopularFood.get(position).getFees()));


        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(PopularFood.get(position).getPic(), "drawable", holder.itemView.getContext().getOpPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);

        holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(holder.itemView.getContext(),ShowDetailActivity.class);
                intent.putExtra("object", PopularFood.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return PopularFood.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,fee;
        ImageView pic;
        TextView addBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.PopTitle);
            fee =  itemView.findViewById(R.id.fee);
            pic = itemView.findViewById(R.id.PopImg);
            addBtn  =itemView.findViewById(R.id.txtAdd);
        }
    }
}
