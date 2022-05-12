package com.example.a51c_task;

public class STORIES {
    public int news_photo;
    public String news_description;
    public String news_title;


    public STORIES(int photo, String description, String title)
    {
        this.news_photo = photo;
        this.news_description = description;
        this.news_title = title;
    }

    public int getNews_photo() {
        return news_photo;
    }

    public void setNews_photo(int news_photo) {
        this.news_photo = news_photo;
    }

    public void setNews_description(String news_description) {
        this.news_description = news_description;
    }

    public String getNews_description() {
        return news_description;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

}
