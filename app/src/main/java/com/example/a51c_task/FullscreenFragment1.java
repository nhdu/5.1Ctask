package com.example.a51c_task;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a51c_task.databinding.FragmentFullscreen1Binding;

import java.util.ArrayList;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenFragment1 extends Fragment {
    View view;
    STORIES mainStories;
    ArrayList<STORIES> related;
    TextView title, description;
    ImageView image;
    RecyclerView relatedFragmentStories;
    public FullscreenFragment1(STORIES mainStories, ArrayList<STORIES> relatedStories) {
        this.mainStories = mainStories;
        this.related = relatedStories;
    }

    public ArrayList<STORIES> removeMainStory(STORIES stories)
    {
        int removeIndex = 0;
        for (int index = 0; index < related.size(); index++)
        {
            if (related.get(index).getNews_title().equals(stories.getNews_title()))
            {
                removeIndex = index;
                break;
            }
        }
        ArrayList<STORIES> modifiedList = (ArrayList<STORIES>) related.clone();
        modifiedList.remove(removeIndex);
        return modifiedList;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_fullscreen1, container, false);

        title = view.findViewById(R.id.titleFragmentTextView);
        title.setText(mainStories.getNews_title());

        description = view.findViewById(R.id.descriptionFragmentTextView);
        description.setText(mainStories.getNews_description());

        image = view.findViewById(R.id.imageViewFragment);
        image.setImageResource(mainStories.getNews_photo());

        relatedFragmentStories = view.findViewById(R.id.fragmentRecyclerView);
        relatedFragmentStories.setAdapter(new TOPSTORIES_Recycler_View_Adapter(getContext(), removeMainStory(mainStories), 1));
        relatedFragmentStories.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        return view;
    }



}