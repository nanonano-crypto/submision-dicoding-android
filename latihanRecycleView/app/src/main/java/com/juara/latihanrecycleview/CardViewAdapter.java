package com.juara.latihanrecycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.CardViewHolder> {

    private ArrayList<Hero> listHero;

    public CardViewAdapter(ArrayList<Hero> list){
        this.listHero = list;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hero_cardview, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewHolder holder, int position) {
        Hero hero = listHero.get(position);

        Glide.with(holder.itemView.getContext())
                .load(hero.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
        holder.txtName.setText(hero.getName());
        holder.txtDetail.setText(hero.getDetail());

        holder.btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "Favorite" +
                        listHero.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "Share" +
                        listHero.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listHero.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {

        ImageView imgPhoto;
        TextView txtName, txtDetail;
        Button btnFavorite, btnShare;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img);
            txtName = itemView.findViewById(R.id.txtNama);
            txtDetail = itemView.findViewById(R.id.txtDetail);
            btnFavorite = itemView.findViewById(R.id.btnFav);
            btnShare = itemView.findViewById(R.id.btnShare);
        }
    }
}
