package com.example.a51c_task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public ArrayList<STORIES> storiesData = new ArrayList<>();
    private int[] storiesPhoto = new int[] {R.drawable.climate_change, R.drawable.bon_scott_death, R.drawable.sebastian,
            R.drawable.nevaeh_austin, R.drawable.russian_deported, R.drawable.ukraine_war, R.drawable.dennis_death, R.drawable.rent};
    private ArrayList<NEWS> newsData = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Top Stories Recycler View
        RecyclerView topStories = findViewById(R.id.recyclerViewTopStories);
        prepareStoriesData();
        TOPSTORIES_Recycler_View_Adapter adapter = new TOPSTORIES_Recycler_View_Adapter(this, storiesData, 0);
        topStories.setAdapter(adapter);
        topStories.setLayoutManager( new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        //News Recycler View
        RecyclerView news = findViewById(R.id.news_recycler_view);
        prepareNewsData();
        NEWS_Recycler_View_Adapter adapter_news = new NEWS_Recycler_View_Adapter(this, newsData, storiesData);
        news.setAdapter(adapter_news);
        news.setLayoutManager( new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

    }

    private void prepareStoriesData()
    {
        for (int i = 0; i < storiesPhoto.length; i++)
        {
            String description_resource = "news_";
            description_resource += (i+1);
            storiesData.add(new STORIES(storiesPhoto[i],
                    getResources().getString(getResources().getIdentifier(description_resource.toString(), "string", getPackageName())),
                    getResources().getString(getResources().getIdentifier((description_resource + "Title").toString(), "string", getPackageName()))));
        }
    }

    private void prepareNewsData()
    {
        for (int i = 0; i < storiesPhoto.length; i+= (storiesPhoto.length/2))
        {
            String description_resource = "news_";
            int index1 = i + 1;
            int index2 = i + 2;
            int index3 = i + 3;
            int index4 = i + 4;
            newsData.add(new NEWS(storiesPhoto[i], storiesPhoto[i+1], storiesPhoto[i+2], storiesPhoto[i+3],
                    getResources().getString(getResources().getIdentifier((description_resource + index1 +"Title").toString(), "string", getPackageName())),
                    getResources().getString(getResources().getIdentifier((description_resource + index2 +"Title").toString(), "string", getPackageName())),
                    getResources().getString(getResources().getIdentifier((description_resource + index3 +"Title").toString(), "string", getPackageName())),
                    getResources().getString(getResources().getIdentifier((description_resource + index4 +"Title").toString(), "string", getPackageName())),
                    getResources().getString(getResources().getIdentifier((description_resource + index1).toString(), "string", getPackageName())),
                    getResources().getString(getResources().getIdentifier((description_resource + index2).toString(), "string", getPackageName())),
                    getResources().getString(getResources().getIdentifier((description_resource + index3).toString(), "string", getPackageName())),
                    getResources().getString(getResources().getIdentifier((description_resource + index4).toString(), "string", getPackageName()))));
        }
    }


}