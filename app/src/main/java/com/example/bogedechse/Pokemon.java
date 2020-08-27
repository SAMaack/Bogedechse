package com.example.bogedechse;

import android.graphics.Bitmap;

public class Pokemon {
    private String name;
    private String url;
    private int id;
    private Bitmap sprite;

    public Pokemon(String n, String u, int id) {

            this.name = n;
            this.url = u;
            this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
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
