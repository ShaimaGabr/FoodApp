package com.example.foodtwo.Clesses.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodtwo.R;
import com.example.foodtwo.databinding.PopularItemBinding;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.MyViewHolder> {
    private Integer [] images = {R.drawable.meat,R.drawable.fishh,R.drawable.perger,R.drawable.pizta,R.drawable.fish,R.drawable.palet,R.drawable.checken};
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new  MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PopularAdapter.MyViewHolder holder, int position) {
         holder.bind(images[position]);
    }

    @Override
    public int getItemCount() {
        return images!=null?images.length:0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
      private final PopularItemBinding binding;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding =   PopularItemBinding.bind(itemView);
        }
        void bind(Integer image){
            binding.foodimage.setImageResource(image);
        }
    }
}
