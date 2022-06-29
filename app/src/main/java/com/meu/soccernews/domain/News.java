package com.meu.soccernews.domain;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class News {
    @PrimaryKey
    public Integer id;
    public String title;
    public String description;
    public String image;
    public String link;
    public Boolean favorite = false;
}
