package com.example.pokedachs;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.pokedachs.Adapter.customAdapter;
import com.example.pokedachs.Interfaces.IArrayCallback;
import com.example.pokedachs.Interfaces.IResponseCallback;
import com.example.pokedachs.pokeData.Pokemon;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements customAdapter.OnItemListener, IResponseCallback, IArrayCallback {

    private String TAG = "/// Main";

    RecyclerView recyclerView;
    Spinner gen_Spinner;
    ArrayList<Pokemon> pokeArrList;

    Requester requester;
    JsonWorker jsonWorker;

    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.jsonWorker = new JsonWorker(this, this);
        this.requester = new Requester(this, this);

        this.gen_Spinner = findViewById(R.id.gen_spinner);
        this.recyclerView = findViewById(R.id.recycler_v);
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);

        requester.prepareURL("generation");
    }

    @Override
    public void onItemClick(int position) {
        //Intent intent = new Intent(this, PokeDetailsActivity);
    }

    @Override
    public void setArrayList(ArrayList<Pokemon> pAL) {
        this.pokeArrList = pAL;
    }

    @Override
    public void onResponseDone(String string) {
        //WhatDoWithZeJsonThingy
        jsonWorker.TEST(string);

    }

    public void doRecyclerViewThings() {
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

}//END CLASS