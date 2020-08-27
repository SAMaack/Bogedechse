package com.example.bogedechse;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class customAdapter extends RecyclerView.Adapter<customAdapter.ViewHolder> {
    private ArrayList<Pokemon> pokeList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameV;
        ImageView spriteV;

        public ViewHolder(View v) {
            super(v);
            this.nameV = v.findViewById(R.id.list_name_view);
            this.spriteV = v.findViewById(R.id.list_sprite_view);
        }
    }

    public customAdapter(ArrayList<Pokemon> pL) {
        this.pokeList = pL;
    }

    @Override
    public customAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.poke_list_layout, parent, false);

        ViewHolder vH = new ViewHolder(v);
        return vH;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nameV.setText(pokeList.get(position).getName());
        Picasso.get().load(pokeList.get(position).getUrl()).into(holder.spriteV);
    }

    @Override
    public int getItemCount() {
        return pokeList.size();
    }
}
