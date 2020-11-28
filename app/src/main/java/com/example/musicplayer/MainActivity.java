package com.example.musicplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;




public class MainActivity extends AppCompatActivity {

    //Tells Main Activity that user has selected song at position
    void onUserSelectedSongAtPosition(int position) {
        switchSong(currentSongIndex, position);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateDataModel();

        connectXMLViews();

        setupRecyclerView();

        setupButtonHandlers();

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
        songAdapter = new SongAdapter(this, playlist.songs, this);
        songsRecyclerView.setAdapter(songAdapter);

    }

    void displayCurrentSong() {
        Song currentSong = playlist.songs.get(currentSongIndex);
        imageView.setImageResource(currentSong.imageResource);
        songNameTextView.setText(currentSong.songName);
        artistNameTextView.setText(currentSong.artistName);
    }


    void setupButtonHandlers() {
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //This will be called when the previous button is tapped
                System.out.println("Previous button tapped.");
                if (currentSongIndex -1 >= 0) {
                    switchSong(currentSongIndex, currentSongIndex - 1);
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Next button tapped.");
                if (currentSongIndex + 1 < playlist.songs.size()) {
                    switchSong(currentSongIndex, currentSongIndex + 1);
                }
            }

        });
        
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Pause button tapped.");
                pauseCurrentSong();
            }
        });
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Play button tapped");
                playCurrentSong();
            }
        });
    }

    void switchSong(int fromIndex, int toIndex) {
        // Tell song adapter to refresh currently selected song
        songAdapter.notifyItemChanged(currentSongIndex);
        //update current song index
        currentSongIndex = toIndex;

        //Display song
        displayCurrentSong();

        // Tell song adapter to refresh the newly selected song
        songAdapter.notifyItemChanged(currentSongIndex);

        //Scroll to make current song visible in recyclerview
        songsRecyclerView.scrollToPosition(currentSongIndex);

        // Check if a current song is playing
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            // A song is playing, pause the current song
            pauseCurrentSong();

            // Invalidate the media player
            mediaPlayer = null;

            // Play the new current song
            playCurrentSong();


        }
        else {
            // A song is not currently playing, invalidate the media player
            mediaPlayer = null;

        }

        // Invalidate the media player
        mediaPlayer = null;
    }

    void pauseCurrentSong() {
        System.out.println("Pausing song at index " + currentSongIndex);
        // Check if media player already exists
        if (mediaPlayer != null) {
            // Media player exists, go ahead and pause it
            mediaPlayer.pause();

        }
    }

    void playCurrentSong() {
        System.out.println("Playing song at index " + currentSongIndex);
        // Check if mediaPlayer already exists
        if (mediaPlayer == null) {
            // mediaPlayer has not been created

            // Get the song object corresponding to the current song
            Song currentSong = playlist.songs.get(currentSongIndex);

            // Create a media player for the MP3 resource of the current song
            mediaPlayer = MediaPlayer.create(MainActivity.this, currentSong.mp3Resource );

        }
        // Play the song
        mediaPlayer.start();
    }



    //Properties
    Playlist playlist = new Playlist();
    Integer currentSongIndex = 0;

    //Adapter for recycler view
    SongAdapter songAdapter;

    // Media player to play MP#
    MediaPlayer mediaPlayer = null;


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