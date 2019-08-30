package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FamilyMembers extends AppCompatActivity {
MediaPlayer mediaPlayer;
MediaPlayer .OnCompletionListener onCompletionListener =new MediaPlayer.OnCompletionListener() {
    @Override
    public void onCompletion(MediaPlayer mp) {
        releaseMediaPlayer();
    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.word_list);

       final ArrayList<WordCustoumClass> familyWords=new ArrayList <WordCustoumClass>();


        familyWords.add(new WordCustoumClass("father","abou",R.drawable.family_father,R.raw.number_eightt));
        familyWords.add(new WordCustoumClass("mother","anain",R.drawable.family_mother,R.raw.number_eightt));
        familyWords.add(new WordCustoumClass("older brother","anniga dawey",R.drawable.family_older_brother,R.raw.number_eightt));
        familyWords.add(new WordCustoumClass("older sister","annesy dawey",R.drawable.family_older_sister,R.raw.number_eightt));
        familyWords.add(new WordCustoumClass("younger brother","anniga kodood",R.drawable.family_younger_brother,R.raw.number_eightt));
        familyWords.add(new WordCustoumClass("younger sister","annesy kodood",R.drawable.family_younger_sister,R.raw.number_eightt));
        familyWords.add(new WordCustoumClass("grandfather","annow",R.drawable.family_grandfather,R.raw.number_eightt));
        familyWords.add(new WordCustoumClass("grandmother","annaow",R.drawable.family_grandmother,R.raw.number_eightt));
        familyWords.add(new WordCustoumClass("son","angaa",R.drawable.family_son,R.raw.number_eightt));
        familyWords.add(new WordCustoumClass("daughter","annass",R.drawable.family_daughter,R.raw.number_eightt));



        WordAdapterClass colorItemAdapter = new WordAdapterClass(this, familyWords,R.color.category_family);

        ListView showColorWords =(ListView)findViewById(R.id.words_list_view);

        showColorWords.setAdapter(colorItemAdapter);
        showColorWords.setAdapter(colorItemAdapter);

        showColorWords.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                WordCustoumClass getsoundposition =familyWords.get(position);
                Toast.makeText(FamilyMembers.this, "listen carefully and repeat  the sound", Toast.LENGTH_SHORT).show();
                releaseMediaPlayer();
                mediaPlayer=MediaPlayer.create(FamilyMembers.this, getsoundposition.getSoundRes());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(onCompletionListener);
            }
        });


    }
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }


    private void releaseMediaPlayer( ) {
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
