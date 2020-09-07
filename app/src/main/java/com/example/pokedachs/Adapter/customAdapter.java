package com.example.pokedachs.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokedachs.pokeData.Pokemon;
import com.example.pokedachs.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class customAdapter extends RecyclerView.Adapter<customAdapter.ViewHolder>{
    private ArrayList<Pokemon> mPokeList;
    private OnItemListener mOnItemListener;

    ///ADAPTER
    public customAdapter(ArrayList<Pokemon> pL, OnItemListener oIL) {
        this.mPokeList = pL;
        this.mOnItemListener = oIL;
    }

    @Override
    public customAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.poke_list_layout, parent, false);

        return new ViewHolder(v, mOnItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nameV.setText(mPokeList.get(position).getName_Default());
        Picasso.get().load(mPokeList.get(position).getSpriteDefault()).into(holder.spriteV);



    }

    @Override
    public int getItemCount() {
        return mPokeList.size();
    }

    //VIEW HOLDER
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView nameV;
        ImageView spriteV;

        OnItemListener mOnItemListener;

        public ViewHolder(View v, OnItemListener oIL) {
            super(v);
            this.nameV = v.findViewById(R.id.list_name_view);
            this.spriteV = v.findViewById(R.id.list_sprite_view);
            this.mOnItemListener = oIL;

            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mOnItemListener.onItemClick(getAdapterPosition());
        }
    }//END VIEW HOLDER

    public interface OnItemListener{
        void onItemClick(int position);
    }
}///END ADAPTER
