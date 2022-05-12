package com.example.a51c_task;

import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NEWS_Recycler_View_Adapter extends RecyclerView.Adapter<NEWS_Recycler_View_Adapter.MyViewHolder>
{
    Context context;
    ArrayList<NEWS> news;
    ArrayList<STORIES> fragmentStories;



    public NEWS_Recycler_View_Adapter(Context context, ArrayList<NEWS> newsList, ArrayList<STORIES> storiesData)
    {
        this.context = context;
        this.news = newsList;
        this.fragmentStories = storiesData;

    }

    @NonNull
    @Override
    public NEWS_Recycler_View_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_views_related, parent, false);
        return new NEWS_Recycler_View_Adapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NEWS_Recycler_View_Adapter.MyViewHolder holder, int position) {
        holder.image1.setImageResource(news.get(position).getPhoto1());
        holder.image2.setImageResource(news.get(position).getPhoto2());
        holder.image3.setImageResource(news.get(position).getPhoto3());
        holder.image4.setImageResource(news.get(position).getPhoto4());

        holder.image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                STORIES mainStory = new STORIES(news.get(holder.getAdapterPosition()).getPhoto1(), news.get(holder.getAdapterPosition()).getDescription1(), news.get(holder.getAdapterPosition()).getTitle1());
                Fragment fullscreen = new FullscreenFragment1(mainStory, fragmentStories);
                FragmentManager fragmentManager = ((AppCompatActivity)context).getSupportFragmentManager();
                fragmentManager.beginTransaction().add(R.id.fragmentContainer, fullscreen).addToBackStack("TAG").commit();
            }
        });

        holder.image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                STORIES mainStory = new STORIES(news.get(holder.getAdapterPosition()).getPhoto2(), news.get(holder.getAdapterPosition()).getDescription2(), news.get(holder.getAdapterPosition()).getTitle2());
                Fragment fullscreen = new FullscreenFragment1(mainStory, fragmentStories);
                FragmentManager fragmentManager = ((AppCompatActivity)context).getSupportFragmentManager();
                fragmentManager.beginTransaction().add(R.id.fragmentContainer, fullscreen).addToBackStack("TAG").commit();
            }
        });

        holder.image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                STORIES mainStory = new STORIES(news.get(holder.getAdapterPosition()).getPhoto3(), news.get(holder.getAdapterPosition()).getDescription3(), news.get(holder.getAdapterPosition()).getTitle3());
                Fragment fullscreen = new FullscreenFragment1(mainStory, fragmentStories);
                FragmentManager fragmentManager = ((AppCompatActivity)context).getSupportFragmentManager();
                fragmentManager.beginTransaction().add(R.id.fragmentContainer, fullscreen).addToBackStack("TAG").commit();
            }
        });

        holder.image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                STORIES mainStory = new STORIES(news.get(holder.getAdapterPosition()).getPhoto4(), news.get(holder.getAdapterPosition()).getDescription4(), news.get(holder.getAdapterPosition()).getTitle4());
                Fragment fullscreen = new FullscreenFragment1(mainStory, fragmentStories);
                FragmentManager fragmentManager = ((AppCompatActivity)context).getSupportFragmentManager();
                fragmentManager.beginTransaction().add(R.id.fragmentContainer, fullscreen).addToBackStack("TAG").commit();
            }
        });


        holder.textView1.setText(news.get(position).getTitle1());
        holder.textView2.setText(news.get(position).getTitle2());
        holder.textView3.setText(news.get(position).getTitle3());
        holder.textView4.setText(news.get(position).getTitle4());

        holder.textView1.setMovementMethod(new ScrollingMovementMethod());
        holder.textView2.setMovementMethod(new ScrollingMovementMethod());
        holder.textView3.setMovementMethod(new ScrollingMovementMethod());
        holder.textView4.setMovementMethod(new ScrollingMovementMethod());
    }



    @Override
    public int getItemCount() {
        return news.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView image1, image2, image3, image4;
        TextView textView1, textView2, textView3, textView4;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image1 = itemView.findViewById(R.id.news1_Image);
            image2 = itemView.findViewById(R.id.news2_Image);
            image3 = itemView.findViewById(R.id.news3_Image);
            image4 = itemView.findViewById(R.id.news4_Image);
            textView1 = itemView.findViewById(R.id.news1TextView);
            textView2 = itemView.findViewById(R.id.news2TextView);
            textView3 = itemView.findViewById(R.id.news3TextView);
            textView4 = itemView.findViewById(R.id.news4TextView);

        }
    }
}
