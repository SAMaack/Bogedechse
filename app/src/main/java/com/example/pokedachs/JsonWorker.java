package com.example.pokedachs;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.pokedachs.Interfaces.IArrayCallback;
import com.example.pokedachs.Interfaces.IResponseCallback;
import com.example.pokedachs.pokeData.PokeGeneration;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonWorker extends MainActivity implements IResponseCallback {

    private IArrayCallback iArrayCallback;
    private Context context;

    public JsonWorker(Context context, IArrayCallback iArrayCallback) {
        this.iArrayCallback = iArrayCallback;
        this.context = context;
    }

    @Override
    public void onResponseDone(String str) {
        //Do what exactly? I forgot. Duh.
        //Oh right, Requester calls.
    }

    public void TEST(String json) {
        Log.i("////JSONWORKER: ", json);

        try {

            ArrayList<PokeGeneration> pokeGenList = new ArrayList<PokeGeneration>();

            JSONObject jsonObj = new JSONObject(json);

            JSONArray genArray = jsonObj.getJSONArray("results");

            for (int i = 0;i < genArray.length(); i++) {
                JSONObject currObj = genArray.getJSONObject(i);
                pokeGenList.add(new PokeGeneration(currObj.getString("name"), currObj.getString("url")));
            }

            ArrayAdapter spinnerAdapter = new ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, pokeGenList);
            spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            gen_Spinner.setAdapter(spinnerAdapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}//END CLASS

