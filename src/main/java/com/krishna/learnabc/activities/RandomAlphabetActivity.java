package com.krishna.learnabc.activities;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.krishna.learnabc.R;
import com.krishna.learnabc.util.OnSwipeTouchListener;

import java.util.Locale;
import java.util.Random;

public class RandomAlphabetActivity extends AppCompatActivity {

    TextToSpeech t1;
    int alphabetCode = 65;
    int lastAlphabetCode = 90;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_alphabet);

        process();
    }



    private void process(){
        final TextSwitcher textSwitcher = (TextSwitcher) findViewById(R.id.randomTextSwitcher);

        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.getDefault());
                }
            }
        });

    textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
        //Random rnd = new Random();
        //int color = Color.rgb(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255));

        public View makeView() {
            TextView myText = new TextView(RandomAlphabetActivity.this);
            myText.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.FILL_PARENT, FrameLayout.LayoutParams.FILL_PARENT));

            myText.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
            myText.setTextSize(200);
            myText.setTypeface(null, Typeface.BOLD);

            myText.setTextColor(Color.WHITE);
            return myText;
        }
    });

        Random rn = new Random();
        int alphabetInt = rn.nextInt(lastAlphabetCode - alphabetCode + 1) + alphabetCode;
        textSwitcher.setText(Character.toString((char)alphabetInt));

    textSwitcher.setOnTouchListener(new OnSwipeTouchListener(this.getApplicationContext()) {
        int alphabetInt = 65;
        public void onSingleTap() {
            String text = Character.toString((char) alphabetInt);
            //textSwitcher.setText(text);
            t1.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        }

        public void onSwipeTop() {
        }

        public void onSwipeRight() {
            generateText();
        }

        public void onSwipeLeft() {
            generateText();
        }

        public void onSwipeBottom() {
        }

        private void generateText() {
            Random rn = new Random();
            alphabetInt = rn.nextInt(lastAlphabetCode - alphabetCode + 1) + alphabetCode;
            String text = Character.toString((char) alphabetInt);
            textSwitcher.setText(text);
        }

    });
}

}




