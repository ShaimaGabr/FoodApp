package com.example.foodtwo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodtwo.databinding.CustomLayoutBinding;

import java.util.List;

public class DiscountAdapter extends RecyclerView.Adapter<DiscountAdapter.DiscountViewHolder> {
    private Integer [] images = {R.drawable.meat,R.drawable.fishh,R.drawable.perger,R.drawable.pizta};


    @NonNull
    @Override
    public DiscountViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DiscountViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DiscountAdapter.DiscountViewHolder holder, int position) {
        holder.bind(images[position]);

    }

    @Override
    public int getItemCount() {
        return images !=null?images.length:0;
    }

    public class DiscountViewHolder extends RecyclerView.ViewHolder {
        private final CustomLayoutBinding binding;
        public DiscountViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = CustomLayoutBinding.bind(itemView);
        }
        void bind(Integer images ){
            binding.imageView.setBackgroundResource(images);
        }
    }
}
