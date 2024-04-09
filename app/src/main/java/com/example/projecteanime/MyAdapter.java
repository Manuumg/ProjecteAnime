package com.example.projecteanime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Anime> mAnime;
    private Context mContext;


    public MyAdapter(  Context mContext, List<Anime> mAnime) {
        this.mContext = mContext;
        this.mAnime = mAnime;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.anime_list_fav_layaout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(mAnime.get(position).getName());
        holder.genre.setText(mAnime.get(position).getGenre());
        holder.year.setText(mAnime.get(position).getYear() + "");
        Picasso.get().load("https://joanseculi.com/" + mAnime.get(position).getImage())
                .fit()
                .centerCrop()
                .into(holder.url);

        System.out.println("HOla");

    }

    @Override
    public int getItemCount() {
        return mAnime.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView genre;
        TextView year;
        ImageView url;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.textName);
            genre = itemView.findViewById(R.id.textGenre);
            year = itemView.findViewById(R.id.textYear);
            url = itemView.findViewById(R.id.imageUrl);
        }

    }
}
