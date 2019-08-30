/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class WordAdapterClass extends ArrayAdapter<WordCustoumClass> {



private int backGroundColor;
    public WordAdapterClass(Activity context, ArrayList<WordCustoumClass> colorWords,int backgroundColorid) {

        super(context, 0, colorWords);
        backGroundColor=backgroundColorid;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            LayoutInflater inflater=LayoutInflater.from(getContext());
            listItemView =inflater.inflate(R.layout.custom_list_item, parent, false);
        }


        WordCustoumClass getwords = getItem(position);


        TextView nubianTextView = (TextView) listItemView.findViewById(R.id.nubian_translat);
        nubianTextView.setText(getwords.getNubianTranslatoin());


        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_translat);
        defaultTextView .setText(getwords.getDefaultTranslation());





        ImageView imageTextView = (ImageView) listItemView.findViewById(R.id.imageRes);
        if(getwords.hasIMAGE()){
        imageTextView.setImageResource(getwords.getImageResourceId());
        imageTextView.setVisibility(View.VISIBLE);}
        else { imageTextView.setVisibility(View.GONE);}

// to set back grond color for each activity
       View view = listItemView.findViewById(R.id.setBackgroundColor);
       int color = ContextCompat.getColor(getContext(),backGroundColor);
       view.setBackgroundColor(color);
       // return view
        return listItemView;

    }

}
