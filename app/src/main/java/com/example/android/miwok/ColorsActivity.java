package com.example.android.miwok;

import android.media.MediaPlayer;
import android.provider.UserDictionary;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
MediaPlayer.OnCompletionListener onCompletionListener= new MediaPlayer.OnCompletionListener(){

    @Override
    public void onCompletion(MediaPlayer mp) {
        releaseMediaPlayer();
    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList <WordCustoumClass> colorWords = new ArrayList <WordCustoumClass>();


        colorWords.add(new WordCustoumClass("black", "awrum", R.drawable.color_black, R.raw.sleepawy));
        colorWords.add(new WordCustoumClass("white", "Nowlu", R.drawable.color_white, R.raw.number_eightt));
        colorWords.add(new WordCustoumClass("red", "gail", R.drawable.color_red, R.raw.number_eightt));
        colorWords.add(new WordCustoumClass("yellow", "gumray", R.drawable.color_dusty_yellow, R.raw.number_eightt));
        colorWords.add(new WordCustoumClass("tan", "Nabri", R.drawable.color_brown, R.raw.number_eightt));
        colorWords.add(new WordCustoumClass("orange", "gummetar", R.drawable.color_mustard_yellow, R.raw.number_eightt));
        colorWords.add(new WordCustoumClass("gray", "Shoor", R.drawable.color_gray, R.raw.number_eightt));
        colorWords.add(new WordCustoumClass("green", "dissy", R.drawable.color_green, R.raw.number_eightt));


        WordAdapterClass colorItemAdapter = new WordAdapterClass(this, colorWords, R.color.category_colors);


        ListView showColorWords = (ListView) findViewById(R.id.words_list_view);

        showColorWords.setAdapter(colorItemAdapter);

        showColorWords.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView <?> adapterView, View view, int position, long l) {
                WordCustoumClass getSounPosition = colorWords.get(position);
                Toast.makeText(ColorsActivity.this, "listen carefully and repeat  the sound", Toast.LENGTH_SHORT).show();
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(ColorsActivity.this, getSounPosition.getSoundRes());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(onCompletionListener);
            }
        });


    }

    @Override
    protected void onStop() {
        super.onStop();
     releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }
}
