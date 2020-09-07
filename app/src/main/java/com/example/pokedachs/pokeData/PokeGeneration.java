package com.example.pokedachs.pokeData;

public class PokeGeneration {
    private String gen_URL;

    private String gen_Name;
    private String name_SysLang;
    private String api_Name;

    public PokeGeneration(String gen_Name, String gen_URL) {
        this.gen_Name = gen_Name;
        this.gen_URL = gen_URL;
        this.name_SysLang = "?";
    }

    public void setName_SysLang(String name_SysLang) {
        this.name_SysLang = name_SysLang;
    }

    public void setApi_Name(String api_Name) {
        this.api_Name = api_Name;
    }

    public String getGen_URL() {
        return gen_URL;
    }

    public String getGen_Name() {
        return gen_Name;
    }

    public String getName_SysLang() {
        return name_SysLang;
    }

    public String getApi_Name() {
        return api_Name;
    }
}
