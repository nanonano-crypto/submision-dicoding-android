package com.juara.latihanrecycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GridHeroAdapter extends RecyclerView.Adapter<GridHeroAdapter.GridViewHolder> {

    private ArrayList<Hero> listHero;
    // constructor arraylist di atas
    public GridHeroAdapter(ArrayList<Hero> list){
        this.listHero = list;
    }

    private onItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(onItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    //hasil generate dari extends recycle view
    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hero_grid, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridHeroAdapter.GridViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(listHero.get(position).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return listHero.size();
    }

    //hasil create class dari extend class awal
    public class GridViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }

    public interface onItemClickCallback {
        void onItemClicked(Hero data);
    }
}
