package com.example.pokedachs.pokeData;

public class Pokemon {
    private String name_Default;
    private String name_SysLang;
    private String url;
    private int id;
    private String spriteDefault;

    public Pokemon(String n, String url) {

            this.name_Default = n;
            this.url = url;

    }

    public String getName_Default() {
        return name_Default;
    }

    public void setName_SysLang(String name_SysLang) {
        this.name_SysLang = name_SysLang;
    }

    public String getName_SysLang() {
        return name_SysLang;
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

    public void setSpriteDefault(String spriteDefault) {
        this.spriteDefault = spriteDefault;
    }

    public String getSpriteDefault() {
        return spriteDefault;
    }
}
