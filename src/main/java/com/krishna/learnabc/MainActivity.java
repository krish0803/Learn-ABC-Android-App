package com.krishna.learnabc;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.krishna.learnabc.activities.AlphabetActivity;
import com.krishna.learnabc.activities.NumbersActivity;
import com.krishna.learnabc.activities.RandomAlphabetActivity;
import com.krishna.learnabc.util.OnSwipeTouchListener;

import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int alphabetCode = 65;
    int lastAlphabetCode = 90;
    TextToSpeech t1;

   /* private void test(){
        final TextSwitcher textSwitcher = (TextSwitcher) findViewById(R.id.textSwitcher);

        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.getDefault());
                }
            }
        });

        // Set the ViewFactory of the TextSwitcher that will create TextView object when asked
        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            //Random rnd = new Random();
            //int color = Color.rgb(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255));

            public View makeView() {
                // TODO Auto-generated method stub
                // create new textView and set the properties like clolr, size etc
                TextView myText = new TextView(MainActivity.this);
                myText.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.FILL_PARENT, FrameLayout.LayoutParams.FILL_PARENT));

                myText.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                myText.setTextSize(200);
                myText.setTypeface(null, Typeface.BOLD);

                myText.setTextColor(Color.WHITE);
                return myText;
            }
        });

        //Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        //Animation out = AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right);


        textSwitcher.setText("A");

       *//* textSwitcher.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (alphabetCode == lastAlphabetCode + 1)
                        alphabetCode = 65;
                    textSwitcher.setText(Character.toString((char) alphabetCode++));
                    return true;
                }
                return false;
            }
        });*//*

        textSwitcher.setOnTouchListener(new OnSwipeTouchListener(this.getApplicationContext()) {

            //Animation slideInLeft = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
            //Animation slideOutRight = AnimationUtils.loadAnimation(getApplicationContext(),android.R.anim.slide_out_right);

            private void forwardText () {
                if (alphabetCode == lastAlphabetCode + 1){
                    alphabetCode = 65;
                }else if(alphabetCode == 90){
                    alphabetCode = 64;
                }

                String text = Character.toString((char) ++alphabetCode);
                textSwitcher.setText(text);
                t1.speak(text, TextToSpeech.QUEUE_FLUSH, null);
            }

            *//*@Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    forwardText();
                    return true;
                }
                return false;
            }*//*

            public void onSwipeTop() {
                //Toast.makeText(MainActivity.this, "top", Toast.LENGTH_SHORT).show();
            }

            public void onSwipeRight() {
                //textSwitcher.setOutAnimation(slideOutRight);
                //textSwitcher.setInAnimation(slideInLeft);
                if (alphabetCode == lastAlphabetCode + 1) {
                    alphabetCode = 65;
                }else if (alphabetCode == 65) {
                    alphabetCode = 91;
                }

                String text = Character.toString((char) --alphabetCode);
                textSwitcher.setText(text);
                t1.speak(text, TextToSpeech.QUEUE_FLUSH, null);
            }

            public void onSwipeLeft() {

                //textSwitcher.setInAnimation(slideInLeft);
                //textSwitcher.setOutAnimation(slideOutRight);
                forwardText();


            }

            public void onSwipeBottom() {
                //Toast.makeText(MainActivity.this, "bottom", Toast.LENGTH_SHORT).show();
            }

        });
    }

*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton  abcImageButton = (ImageButton) findViewById(R.id.abcImageButton);
        abcImageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent
                        (MainActivity.this, AlphabetActivity.class);
                startActivity(intent);
            }
        });

        ImageButton numbersImageButton = (ImageButton) findViewById(R.id.numbersImageButton);
        numbersImageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent
                        (MainActivity.this, NumbersActivity.class);
                startActivity(intent);
            }
        });

        ImageButton randomAbcImageButton = (ImageButton) findViewById(R.id.randomAbcImageButton);
        randomAbcImageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent
                        (MainActivity.this, RandomAlphabetActivity.class);
                startActivity(intent);
            }
        });
    }

}
