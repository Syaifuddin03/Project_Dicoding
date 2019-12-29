package com.example.projectdicoding.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.projectdicoding.Detail.Detail_Activity;
import com.example.projectdicoding.R;

import java.util.ArrayList;

public class Wisata_Adapter extends RecyclerView.Adapter<Wisata_Adapter.MovieViewHolder> {

    ArrayList<List_Wisata> listWisata;
    Context context;
    private ItemClickListener itemClickListener;

    public Wisata_Adapter(Context context, ArrayList<List_Wisata> list) {
        this.listWisata = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(listWisata.get(position).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);

        holder.tvName.setText(listWisata.get(position).getName());
        holder.tvDetail.setText(listWisata.get(position).getDetail());
        holder.tvLokasi.setText(listWisata.get(position).getLokasi());
        holder.tvRating.setText(listWisata.get(position).getRating());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {
                Bundle extras = new Bundle();
                extras.putString("nama_wisata", listWisata.get(position).getName());
                extras.putString("deskripsi_wisata", listWisata.get(position).getDetail());
                extras.putString("rating_wisata", listWisata.get(position).getRating());
                extras.putString("lokasi_wisata", listWisata.get(position).getLokasi());
                extras.putInt("image_wisata", listWisata.get(position).getPhoto());

                Intent intent = new Intent(context, Detail_Activity.class);
                intent.putExtras(extras);

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listWisata.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgPhoto;
        TextView tvName, tvDetail, tvLokasi, tvRating;

        private ItemClickListener itemClickListener;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
            tvLokasi = itemView.findViewById(R.id.lokasi);
            tvRating = itemView.findViewById(R.id.rating);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            this.itemClickListener.onItemClickListener(v, getLayoutPosition());
        }

        public void setItemClickListener(ItemClickListener ic){
            this.itemClickListener = ic;
        }
    }
}
