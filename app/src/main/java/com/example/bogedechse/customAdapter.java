package com.example.bogedechse;

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
    private ArrayList<Pokemon> mPokeList;

    //VIEW HOLDER
    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView nameV;
        ImageView spriteV;

        public ViewHolder(View v) {
            super(v);
            this.nameV = v.findViewById(R.id.list_name_view);
            this.spriteV = v.findViewById(R.id.list_sprite_view);
            //this.onItemListener = oIL;

            //v.setOnClickListener(this);
        }
    }//END VIEW HOLDER


    ///ADAPTER
    public customAdapter(ArrayList<Pokemon> pL) {
        this.mPokeList = pL;
    }

    @Override
    public customAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.poke_list_layout, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nameV.setText(mPokeList.get(position).getName());
        Picasso.get().load(mPokeList.get(position).getUrl()).into(holder.spriteV);
    }

    @Override
    public int getItemCount() {
        return mPokeList.size();
    }
}///END ADAPTER
