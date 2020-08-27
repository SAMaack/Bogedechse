package com.example.bogedechse;

import android.os.AsyncTask;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;


public class PokeApi extends AsyncTask<String, Void, String> {

    private static String apiRoot = "https://pokeapi.co/api/v2/";                                   //Base url

    RecyclerView recyclerView;
    customAdapter adapter;
    ArrayList<Pokemon> pokeList;

    public PokeApi(RecyclerView rV) {
       recyclerView = rV;
    }

    @Override
    protected String doInBackground(String... strings) {
        HttpsURLConnection conn = null;
        BufferedReader reader = null;

        try {

            URL url = new URL (buildURL("pokemon", 0));

            conn = (HttpsURLConnection) url.openConnection();
            conn.connect();

            InputStream stream = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));

            return reader.readLine();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException i) {
            i.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {

        pokeList = new ArrayList<Pokemon>();

        try {
            JSONObject pokeObj = new JSONObject(result);

            if (result.contains("results")) {
                JSONArray jsonPokeArray = pokeObj.getJSONArray("results");

                for (int i = 0; i != jsonPokeArray.length(); i++) {

                    //Pull single object from json array
                    JSONObject pokemon_simple = jsonPokeArray.getJSONObject(i);

                    //Populate array with new filled pokemon classes
                    pokeList.add(new Pokemon(pokemon_simple.getString("name"),
                            pokemon_simple.getString("url")));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        adapter = new customAdapter(pokeList);
        recyclerView.setAdapter(adapter);

    }

    private String buildURL(@Nullable String category, int id){
        try {

        }
        catch (Exception e) {

        }
        StringBuilder urlSB = new StringBuilder(apiRoot);

        if (category != null) {                                                                     //Check if a specific type of category is wanted. - Example: https://pokeapi.co/api/v2/ + pokemon | https://pokeapi.co/api/v2/ + berrys
                                                                                                    //If null, get everything.
            switch(category) {
                case "pokemon": {
                    urlSB.append("pokemon");
                }
            }//END SWITCH

            //If a specific entry is looked for.
            if (id != 0 && category != null) {
                urlSB.append("/" + id);
            }//END IF
            else {
                urlSB.append("?limit=1048");    //Gets every pokemon there is.
            }

        }//END IF

        return urlSB.toString();
    }//END BUILD URL

}//END POK API CLASS
