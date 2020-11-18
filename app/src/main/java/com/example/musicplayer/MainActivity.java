package com.example.musicplayer;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String song1Name = "Song 1";
        String songArtist = "Artist 1";
        int song1ImageResource;
        int song1Mp3Resource;

        //Arrays
        ArrayList<String> songNames = new ArrayList<>();
        ArrayList<String> artistName = new ArrayList<>();

        ArrayList<Song> songs
    }
}