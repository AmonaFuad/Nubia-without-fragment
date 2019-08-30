package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Phreses extends AppCompatActivity {
MediaPlayer  mMediaPlayer;
MediaPlayer.OnCompletionListener onCompletionListener=new MediaPlayer.OnCompletionListener() {
    @Override
    public void onCompletion(MediaPlayer mp) {
        releaseMediaPlayer();
    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.word_list);

       final ArrayList<WordCustoumClass> colorWords=new ArrayList <WordCustoumClass>();


        colorWords.add(new WordCustoumClass("How are you feeling?","ier hiakrufi",R.raw.number_eightt));
        colorWords.add(new WordCustoumClass("hello","maska'agrow",R.raw.number_eightt));
        colorWords.add(new WordCustoumClass("What is your name?","ayka nayina",R.raw.number_eightt));
        colorWords.add(new WordCustoumClass("My name is...","ayqa .......'iiqana",R.raw.number_eightt));
        colorWords.add(new WordCustoumClass("Are you coming?","'ier hakyna",R.raw.number_eightt));
        colorWords.add(new WordCustoumClass("Yes, I’m coming.","ayyu hakil",R.raw.number_eightt));
        colorWords.add(new WordCustoumClass("Let’s go.","yala hanuqajilun",R.raw.number_eightt));
        colorWords.add(new WordCustoumClass("Come here.","iindu kery",R.raw.number_eightt));
        colorWords.add(new WordCustoumClass("give me water please","amnga  a'ker",R.raw.number_eightt));
        WordAdapterClass colorItemAdapter = new WordAdapterClass(this, colorWords,R.color.category_phrases);


        ListView showColorWords =(ListView)findViewById(R.id.words_list_view);

        showColorWords.setAdapter(colorItemAdapter);
        showColorWords.setAdapter(colorItemAdapter);
        showColorWords.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int psosition, long l) {

                WordCustoumClass getsounR = colorWords.get(psosition);
                Toast.makeText(Phreses.this, "listen carefully and repeat  the sound", Toast.LENGTH_SHORT).show();
                releaseMediaPlayer();
                mMediaPlayer= MediaPlayer.create(Phreses.this, getsounR.getSoundRes());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(onCompletionListener);
            }
        });

    }
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer( ) {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}
