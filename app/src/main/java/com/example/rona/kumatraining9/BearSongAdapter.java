package com.example.rona.kumatraining9;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

//import com.coderefer.recyclerviewtutorial.R;
//import com.coderefer.recyclerviewtutorial.models.Song;
import com.example.rona.kumatraining9.Kuuuun;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;



public class BearSongAdapter extends RecyclerView.Adapter<BearSongAdapter.ViewHolder> {

    private List<Kuuuun> kuuuunList;

    public static class ViewHolder extends RecyclerView.ViewHolder{
//each data item is just a string in this case
 public TextView tvRank,tvSongName,tvSinger,tvYear;
 public ImageView ivAlbumCover;

        public ViewHolder(View v) {
            super(v);
            tvRank = (TextView)v.findViewById(R.id.tv_rank);
            tvSongName = (TextView) v.findViewById(R.id.bear_song);
            tvSinger = (TextView) v.findViewById(R.id.bear_singer);
            tvYear = (TextView) v.findViewById(R.id.bear_year);
            ivAlbumCover = (ImageView) v.findViewById(R.id.bear_album);
        }

    }

    //Provide a suitable constructor
    public BearSongAdapter(List<Kuuuun> songList){
        this.kuuuunList = songList;
    }

    //Create new views (invoked by the layout manager)
    @Override
    public BearSongAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_bear_songs,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(BearSongAdapter.ViewHolder holder, int position) {

        Kuuuun song = kuuuunList.get(position);
        holder.tvRank.setText(String.valueOf(song.getRank()));
        holder.tvSongName.setText(song.getName());
        holder.tvSinger.setText(song.getSinger());
        holder.tvYear.setText(song.getYear());
        holder.ivAlbumCover.setImageResource(song.getPic());
        holder.tvYear.setText("2016");
    }

    @Override
    public int getItemCount() {
        return kuuuunList.size();
    }
}
