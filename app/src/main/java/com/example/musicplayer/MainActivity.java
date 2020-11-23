package com.example.musicplayer;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateDataModel();

        connectXMLViews();

        setupRecyclerView();

    }

    void populateDataModel() {
        // Initialize properties of playlist
        playlist.name = "My Playlist";
        playlist.songs = new ArrayList<Song>();

        //Create and initialize the first song
        Song song = new Song();
        song.songName = "Acoustic Breeze";
        song.artistName = "bensound.con";
        song.imageResource = R.drawable.acousticbreeze;
        song.mp3Resource = R.raw.acousticbreeze;

        //Adding the first song to the array of songs in the playlist
        playlist.songs.add(song);

       song = new Song();
       song.songName = "A New Beginning";
       song.artistName = "bensound.com";
       song.imageResource = R.drawable.anewbeginning;
       song.mp3Resource = R.raw.anewbeginning;

       playlist.songs.add(song);

        song = new Song();
        song.songName = "Creative Minds";
        song.artistName = "bensound.com";
        song.imageResource = R.drawable.creativeminds;
        song.mp3Resource = R.raw.creativeminds;

        playlist.songs.add(song);

        song = new Song();
        song.songName = "Going Higher";
        song.artistName = "bensound.com";
        song.imageResource = R.drawable.goinghigher;
        song.mp3Resource = R.raw.goinghigher;

        playlist.songs.add(song);

        song = new Song();
        song.songName = "Happy Rock";
        song.artistName = "bensound.com";
        song.imageResource = R.drawable.happyrock;
        song.mp3Resource = R.raw.happyrock;

        playlist.songs.add(song);

        song = new Song();
        song.songName = "Hey";
        song.artistName = "bensound.com";
        song.imageResource = R.drawable.hey;
        song.mp3Resource = R.raw.hey;

        playlist.songs.add(song);

        song = new Song();
        song.songName = "Summer";
        song.artistName = "bensound.com";
        song.imageResource = R.drawable.summer;
        song.mp3Resource = R.raw.summer;

        playlist.songs.add(song);
    }

    void connectXMLViews() {
        songsRecyclerView = findViewById(R.id.song_list_view);
        imageView = findViewById(R.id.cover_image);
        songNameTextView = findViewById(R.id.song_name_textview);
        artistNameTextView = findViewById(R.id.artist_name_textview);
        previousButton = findViewById(R.id.goBack);
        pauseButton = findViewById(R.id.pause);
        playButton = findViewById(R.id.play);
        nextButton = findViewById(R.id.goForward);
    }

    void setupRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        songsRecyclerView.setLayoutManager(layoutManager);

        //Connect the adapter to the recyclerView
        songAdapter = new SongAdapter(this, playlist.songs);
        songsRecyclerView.setAdapter(songAdapter);

    }

    //Properties
    Playlist playlist = new Playlist();
    SongAdapter songAdapter;

    // XML Views
    RecyclerView songsRecyclerView;
    ImageView imageView;
    TextView songNameTextView;
    TextView artistNameTextView;
    ImageButton previousButton;
    ImageButton pauseButton;
    ImageButton playButton;
    ImageButton nextButton;
}