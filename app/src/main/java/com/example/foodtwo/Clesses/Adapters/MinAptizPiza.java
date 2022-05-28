package com.example.foodtwo.Clesses.Adapters;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodtwo.R;
import com.example.foodtwo.databinding.MaincoursesItemBinding;
import com.example.foodtwo.databinding.PopularItemBinding;

public class MinAptizPiza extends RecyclerView.Adapter< MinAptizPiza.MyViewHolder> {
    private   onClickListener listener;
    int countt= 1;
    private Integer [] images = {R.drawable.meat,R.drawable.fishh,R.drawable.perger,R.drawable.pizta,R.drawable.fish,R.drawable.palet,R.drawable.checken};
    @NonNull
    @Override
    public MinAptizPiza.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new  MinAptizPiza.MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.maincourses_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull  MinAptizPiza.MyViewHolder holder, int position) {
        holder.bind(images[position],position);
    }

    @Override
    public int getItemCount() {
        return images!=null?images.length:0;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final MaincoursesItemBinding binding;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding =   MaincoursesItemBinding.bind(itemView);
            binding.maincourseitemAdd.setOnClickListener(this::onClickedItem);
            binding.mainCoursePlus.setOnClickListener(this::plusAction);
            binding.mainCourseMinus.setOnClickListener(this::minusAction);

        }

        private void minusAction(View view) {



        countt=countt-1;
        binding.orderCount.setText(""+countt);
        if(countt<=1){
            binding.maincourseitemAdded.setVisibility(View.GONE);
            binding.maincourseitemAdd.setVisibility(View.VISIBLE);
            listener.customToast(getAdapterPosition(),"hid",itemView);
        }
        }

        private void plusAction(View view) {
           // listener.customToast(getAdapterPosition(),"plus",itemView);
            countt=countt+1;
            binding.orderCount.setText(""+countt);
        }


        private void onClickedItem(View view) {
            listener.customToast(getAdapterPosition(),"add",itemView);
            binding.maincourseitemAdd.setVisibility(View.GONE);
           binding.maincourseitemAdded.setVisibility(View.VISIBLE);
        }

        void bind(Integer image,int po){
            binding.maincourseitemImag.setImageResource(image);
             binding.maincourseitemAdded.setVisibility(View.GONE);

        }

    }
    public interface onClickListener{
        void  customToast(int id,String show,View view);

    }
    public void  setOnClicked(onClickListener listener){this.listener=listener;}
}
