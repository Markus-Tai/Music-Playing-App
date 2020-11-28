package com.example.musicplayer;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SongViewHolder extends RecyclerView.ViewHolder{

    //Constructor
    public SongViewHolder(@NonNull View itemView) {
        super(itemView);
        this.itemView = itemView;
        imageView = itemView.findViewById(R.id.image_view);
        songNameTextView = itemView.findViewById(R.id.song_name_textview);
        artistNameTextView = itemView.findViewById(R.id.artist_name_textview);
        selectedBackgroundView = itemView.findViewById(R.id.selected_background_view);
    }

    //Properties
    View itemView;
    ImageView imageView;
    TextView songNameTextView;
    TextView artistNameTextView;
    View selectedBackgroundView;
}
