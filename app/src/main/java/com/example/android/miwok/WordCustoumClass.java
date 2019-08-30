package com.example.android.miwok;

import android.media.MediaPlayer;

public class WordCustoumClass {
    private String defaultWords;
    private String nubianrWords;
    private int imageRes=NO_IMAGE_PROVIDE;
    private final static int NO_IMAGE_PROVIDE=-1;
    private  int soundRes;



    public WordCustoumClass(String mdefaultColorWords, String mnubianColorWords ,int msoundRes) {

        defaultWords = mdefaultColorWords;
        nubianrWords = mnubianColorWords;
        soundRes= msoundRes;


    }

    public WordCustoumClass(String mdefaultColorWords, String mnubianColorWords,int mimageres,int msoundRes) {

        defaultWords = mdefaultColorWords;
        nubianrWords = mnubianColorWords;
        imageRes = mimageres;
        soundRes=msoundRes;

    }


    public String getDefaultTranslation() {
        return defaultWords;
    }

    public String getNubianTranslatoin() { return nubianrWords;}

    public int getSoundRes(){return soundRes;}

    public int getImageResourceId() {
        return imageRes;
    }
    public boolean hasIMAGE(){
        return imageRes!=NO_IMAGE_PROVIDE;
    }

    @Override
    //To summarize, we’ve just covered how you can override the toString() method of any class, which is optional.
    // However, it’s a helpful practice because in the future,
    // you may want to print the current state of an object to the logs (instead of using the step-by-step debugger in Android Studio).
    public String toString() {
        return "WordCustoumClass{" + "defaultWords='" + defaultWords + '\'' + ", nubianrWords='" + nubianrWords + '\'' + ", imageRes=" + imageRes + ", soundRes=" + soundRes + '}';
    }
}
