package com.example.musicplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class SongAdapter extends RecyclerView.Adapter<SongViewHolder> {

    //Constructor
    SongAdapter(@NonNull Context context, @NonNull ArrayList<Song> songs) {
        this.context = context;
        this.songs = songs;

    }

    // Overridden methods
    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // This method is called whenever I need to create a new ViewHolder
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.item_song, parent, false);
        SongViewHolder viewHolder = new SongViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        // This method is called whenever an existing ViewHolder needs to be re-used
        // At this point, we need to repopulate the ViewHolder
        Song song = songs.get(position);
        holder.imageView.setImageResource(song.imageResource);
        holder.songNameTextView.setText(song.songName);
        holder.artistNameTextView.setText(song.artistName);
;

    }

    @Override
    public int getItemCount() {
        // Called whenever the RecyclerView needs to know how many items  in total to display
        return songs.size();
    }

    // Properties
    Context context;
    ArrayList<Song> songs;
}
