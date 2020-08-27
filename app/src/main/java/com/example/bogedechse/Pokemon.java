package com.example.bogedechse;

import android.graphics.Bitmap;

public class Pokemon {
    private String name;
    private String url;
    private int id;
    private Bitmap sprite;

    public Pokemon(String n, String u) {

            this.name = n;
            this.url = u;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setSprite(Bitmap sprite) {
        this.sprite = sprite;
    }

    public Bitmap getSprite() {
        return sprite;
    }
}
