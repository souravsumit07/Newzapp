package com.example.newz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.viewholder>{

    List<Article> articles;

    public NewsAdapter(List<Article> articles) {
        this.articles = articles;
    }


    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article, parent, false);
        return new viewholder(view);    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        Article article = articles.get(position);
        holder.tvTitle.setText(article.getTitle());
        holder.tvDescription.setText(article.getDescription());
        if(article.getUrlToImage() != null) {
            Picasso.get().load(article.getUrlToImage()).into(holder.ivThumbnail);
        } else {
            holder.ivThumbnail.setImageResource(R.drawable.img); // Add a placeholder image in your drawable folder
        }

    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        TextView tvTitle, tvDescription;
        ImageView ivThumbnail;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            ivThumbnail = itemView.findViewById(R.id.ivThumbnail);

        }
    }
}
