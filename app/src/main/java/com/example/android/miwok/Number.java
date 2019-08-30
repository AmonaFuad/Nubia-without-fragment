package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Number extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
   public MediaPlayer.OnCompletionListener onCompletionListener= new MediaPlayer.OnCompletionListener() {
       @Override
       public void onCompletion(MediaPlayer mp) {
           releaseMediaPlayer();

       }
   };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        final ArrayList<WordCustoumClass> words = new ArrayList<WordCustoumClass>();
        words.add(new WordCustoumClass("one", "wira",R.drawable.number_one,R.raw.numberonee));
        words.add(new WordCustoumClass("two", "aw'ow",R.drawable.number_two, R.raw.number_twoo));
        words.add(new WordCustoumClass("three", "Tiscow",R.drawable.number_three,R.raw.number_threee));
        words.add(new WordCustoumClass("four", "kimsow",R.drawable.number_four,R.raw.number_fourr));
        words.add(new WordCustoumClass("five", "deja",R.drawable.number_five,R.raw.number_fivee));
        words.add(new WordCustoumClass("six", "gorjow",R.drawable.number_six,R.raw.number_sixx));
        words.add(new WordCustoumClass("seven", "kawluda",R.drawable.number_seven,R.raw.number_sevenn));
        words.add(new WordCustoumClass("eight", "edway",R.drawable.number_eight,R.raw.number_eightt));
        words.add(new WordCustoumClass("nine", "oscoda",R.drawable.number_nine,R.raw.number_ninee));
        words.add(new WordCustoumClass("ten", "demay",R.drawable.number_ten,R.raw.numer_tenn));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.

        final WordAdapterClass adapter = new WordAdapterClass(Number.this,words,R.color.category_numbers);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        ListView listView = (ListView) findViewById(R.id.words_list_view);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int psosition, long l) {
                WordCustoumClass getsounR =words.get(psosition);
                Toast.makeText(Number.this, "listen carefully and repeat  the sound", Toast.LENGTH_SHORT).show();
            releaseMediaPlayer();
                mMediaPlayer= MediaPlayer.create(Number.this, getsounR.getSoundRes());
                mMediaPlayer.start();
              mMediaPlayer.setOnCompletionListener(onCompletionListener);


            }
        });


/**
 * Clean up the media player by releasing its resources.
 */


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
