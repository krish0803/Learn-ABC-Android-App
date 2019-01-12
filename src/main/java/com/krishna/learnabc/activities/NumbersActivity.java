package com.krishna.learnabc.activities;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.krishna.learnabc.R;
import com.krishna.learnabc.util.OnSwipeTouchListener;

import java.util.Locale;

/**
 * Created by Krishna on 3/24/2016.
 */
public class NumbersActivity extends AppCompatActivity {

    TextToSpeech t1;
    int displayedNumber = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        process();
    }

    private void process(){

        final TextSwitcher textSwitcher = (TextSwitcher) findViewById(R.id.numberSwitcher);

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
                TextView myText = new TextView(NumbersActivity.this);
                myText.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.FILL_PARENT, FrameLayout.LayoutParams.FILL_PARENT));

                myText.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                myText.setTextSize(200);
                myText.setTypeface(null, Typeface.BOLD);

                myText.setTextColor(Color.WHITE);
                return myText;
            }
        });

        textSwitcher.setText("1");

        textSwitcher.setOnTouchListener(new OnSwipeTouchListener(this.getApplicationContext()) {


            private void forward() {
                if (displayedNumber == 20) {
                    displayedNumber = 0;
                }

                String text = ++displayedNumber +"";
                textSwitcher.setText(text);
                t1.speak(text, TextToSpeech.QUEUE_FLUSH, null);
            }

            public void onTouch() {
                t1.speak(displayedNumber+"", TextToSpeech.QUEUE_FLUSH, null);
            }

            public void onSwipeTop() {
            }

            public void onSwipeRight() {
                if (displayedNumber == 1) {
                    displayedNumber = 21;
                }

                String text = --displayedNumber +"";
                textSwitcher.setText(text);
                t1.speak(text, TextToSpeech.QUEUE_FLUSH, null);
            }

            public void onSwipeLeft() {
                forward();
            }

            public void onSwipeBottom() {
            }

        });



    }
}
