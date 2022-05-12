package com.example.a51c_task;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class TOPSTORIES_Recycler_View_Adapter extends RecyclerView.Adapter {
    Context context;
    ArrayList<STORIES> news;
    int adapterViewType;
    public TOPSTORIES_Recycler_View_Adapter(Context context, ArrayList<STORIES> news_list, int viewType)
    {
        this.context = context;
        this.news = news_list;
        this.adapterViewType = viewType;

    }

    public int getAdapterViewType() {
        return adapterViewType;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        if (getAdapterViewType() == 0) {
            View view = inflater.inflate(R.layout.recycler_views_top_stories, parent, false);
            return new MyViewHolder0(view);
        }
        else {

            View view = inflater.inflate(R.layout.recycler_views_related_fragment, parent, false);
            return new MyViewHolder1(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getAdapterViewType() == 0)
        {
            //bind viewholder0
            MyViewHolder0 viewHolder0 = (MyViewHolder0) holder;
            viewHolder0.stories.setImageResource(news.get(position).getNews_photo());
            viewHolder0.stories.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment fullscreen = new FullscreenFragment1(news.get(holder.getAdapterPosition()), news);
                    FragmentManager fragmentManager = ((AppCompatActivity)context).getSupportFragmentManager();
                    fragmentManager.beginTransaction().add(R.id.fragmentContainer, fullscreen).addToBackStack("TAG").commit();
                }
            });
        }
        else {
            //bind viewholder1
            MyViewHolder1 viewHolder1 = (MyViewHolder1) holder;
            viewHolder1.stories.setImageResource(news.get(position).getNews_photo());
            viewHolder1.description.setText(news.get(position).getNews_title());
            viewHolder1.stories.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment fullscreen = new FullscreenFragment1(news.get(holder.getAdapterPosition()), news);
                    FragmentManager fragmentManager = ((AppCompatActivity)context).getSupportFragmentManager();
                    fragmentManager.beginTransaction().add(R.id.fragmentContainer, fullscreen).addToBackStack("TAG").commit();
                }
            });

        }

    }


    @Override
    public int getItemCount() {
        return news.size();
    }

    public static class MyViewHolder0 extends RecyclerView.ViewHolder {
        ImageView stories;
        public MyViewHolder0(@NonNull View itemView) {
            super(itemView);
            stories = itemView.findViewById(R.id.imageTopStories);
        }
    }

    public static class MyViewHolder1 extends  RecyclerView.ViewHolder {
        ImageView stories;
        TextView description;
        public MyViewHolder1(@NonNull View itemView) {
            super(itemView);
            stories = itemView.findViewById(R.id.fragmentRelatedImageView);
            description = itemView.findViewById(R.id.descriptionRelatedFragmentTextView);
        }
    }
}
