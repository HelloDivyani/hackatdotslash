package com.clarifai.android.starter.api.v2.activity;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created by ishmitaloona on 08/10/2017.
 */

public class TextSpeech {
    TextToSpeech toj;
    Context mContext;
    String s;

    public TextSpeech(Context context, String s) {
        this.mContext = context;
        this.s = s;
        toj=new TextToSpeech(context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR)
                {
                    toj.setLanguage(Locale.US);

                }
            }
        });
    }

    public void speakText()
    {



        String s1="US-English";

        // if there is no error in text to speech then set the language for conversion

        toj.setLanguage(Locale.ENGLISH);

        toj.setPitch((float)0.9);
        toj.setSpeechRate((float)1.1);


        //Toast.makeText(getApplicationContext(),"SP : "+sp,Toast.LENGTH_SHORT).show();
        String toSpeak = s;
        if(toSpeak == null)
        {
            toSpeak = "Nothing to Speak";
        }
        Toast.makeText(mContext, toSpeak, Toast.LENGTH_LONG).show();
        toj.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }

}
