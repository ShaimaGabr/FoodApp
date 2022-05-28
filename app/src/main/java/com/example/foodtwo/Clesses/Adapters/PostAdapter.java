package com.example.foodtwo.Clesses.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodtwo.Clesses.RestFullAPI.model.Post;
import com.example.foodtwo.R;
import com.example.foodtwo.databinding.FoodItemBinding;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder> {

    private List<Post> posts;
    private OnFoodClickListener listener;

    public void setDate(List<Post> post) {
        this.posts = post;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(posts.get(position));
    }

    @Override
    public int getItemCount() {
        return posts != null ? posts.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final FoodItemBinding binding;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = FoodItemBinding.bind(itemView);
            binding.fav.setOnClickListener(this::onFavClicked);
            itemView.setOnClickListener(this::OnClickedFood);
        }

        private void onFavClicked(View view) {

        }

        private void OnClickedFood(View view) {

            listener.onFoodClicked(getAdapterPosition());
        }

        void bind(Post post) { binding.title.setText(post.getTitle()); }

    }

    public interface OnFoodClickListener {
        void onFoodClicked(int foodId);
    }

    public void setOnFoodClickListener(OnFoodClickListener listener){
        this.listener = listener;
    }
}
