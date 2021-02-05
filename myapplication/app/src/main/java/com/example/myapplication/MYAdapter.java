package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MYAdapter extends RecyclerView.Adapter<MYAdapter.MyViewHolder> {

    String data1[], data2[];
    int images[];
    Context context;

    public MYAdapter(Context ct, String foodnamess[], String descriptionss[], int img[]){
        context = ct;
        data1 = foodnamess;
        data2 = descriptionss;
        images = img;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.food_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.mytext1.setText(data1[position]);
        holder.mytext2.setText(data2[position]);
        holder.myImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mytext1, mytext2;
        ImageView myImage;

        public MyViewHolder (@NonNull View itemView){
            super(itemView);

            mytext1 = itemView.findViewById(R.id.foodnames);
            mytext1 = itemView.findViewById(R.id.descriptions);
            myImage = itemView.findViewById(R.id.imageView2);

        }
    }
}
