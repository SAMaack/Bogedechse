package com.example.pokedachs;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.pokedachs.Interfaces.IResponseCallback;

public class Requester {

    private IResponseCallback iResponseCallback;
    private RequestQueue queue;

    String baseURL ="https://pokeapi.co/api/v2/";

    public Requester(Context context, IResponseCallback iResponseCallback) {

        this.iResponseCallback = iResponseCallback;
        this.queue = Volley.newRequestQueue(context); // Fehler hier.
    }

    private void getJsonString(String url) {

        StringRequest rq = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                iResponseCallback.onResponseDone(response);

            }// END ON RESPONSE

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }); //END REQUEST
        queue.add(rq);

    }//END getJsonString

    public void prepareURL(String type) {
        switch(type) {

            case "generation":

                getJsonString(baseURL + "generation");

                break;
            case "pokemon":
                break;
        }
    }





}//END CLASS
