package com.juara.submision_satu.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.juara.submision_satu.Detail;
import com.juara.submision_satu.R;
import com.juara.submision_satu.model.Pemain;

import java.util.ArrayList;


public class Adapter extends RecyclerView.Adapter<Adapter.AdapterViewHolder> {

    private ArrayList<Pemain> listPemain;
    public Adapter(ArrayList<Pemain> listPemain, Context context) {
        this.listPemain = listPemain;
        this.context = context;
    }
    private Context context;

//    public Adapter(ArrayList<Pemain> listPemain, Context cont ){
//        this.listPemain = listPemain;
//        this.context = cont;
//    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterViewHolder holder, final int position) {
        Pemain pemain = listPemain.get(position);
        Glide.with(holder.itemView.getContext())
                .load(pemain.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.txtNama.setText(pemain.getNama());
        holder.txtGaji.setText(pemain.getGaji());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context.getApplicationContext(), Detail.class);
                Bundle bundle = new Bundle();

                bundle.putString("name", listPemain.get(position).getNama());
                bundle.putString("gaji", listPemain.get(position).getGaji());
                bundle.putString("detail", listPemain.get(position).getDetail());
                bundle.putInt("image", listPemain.get(position).getPhoto());
//                intent.putExtra("nama", listPemain.get(position).getNama());
//                intent.putExtra("gaji", listPemain.get(position).getGaji());
//                intent.putExtra("dtail", listPemain.get(position).getDetail());
//                intent.putExtra("photo", listPemain.get(position).getPhoto());
                intent.putExtras(bundle);
                context.startActivity(intent);

                Toast.makeText(holder.itemView.getContext(), "" + listPemain.get(holder.getAdapterPosition()).getNama(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return listPemain.size();
    }



    public class AdapterViewHolder extends RecyclerView.ViewHolder {
        public CardView item_card;
        ImageView imgPhoto;
        TextView txtNama, txtGaji;

        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            item_card = itemView.findViewById(R.id.item_card);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            txtNama = itemView.findViewById(R.id.txtNama);
            txtGaji = itemView.findViewById(R.id.txtGaji);

        }
    }
}
