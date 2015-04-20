package edu.ucsb.cs.cs185.mohit.buzzmeprogrammatically;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Context;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.view.View.OnClickListener;



public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // we will be using our own layout
        //setContentView(R.layout.activity_main);
        /*
        //In case the buttons are of the wrong height
        Display display = getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();
         Log.i("MY", "Actual Screen Height = " + height + " Width = " + width);
        */


        Button oneButton = new Button(this);
        oneButton.setText("One");
        oneButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                ToneGenerator tg = new ToneGenerator(AudioManager.STREAM_NOTIFICATION, 100);
                tg.startTone(ToneGenerator.TONE_PROP_BEEP);
                //from slides, adding vibration unable to check as device does not support SDK 21

                Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                v.vibrate(300);

            }
        });

        Button twoButton = new Button(this);
        twoButton.setText("Two");

        twoButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                ToneGenerator tg = new ToneGenerator(AudioManager.STREAM_NOTIFICATION, 100);
                tg.startTone(ToneGenerator.TONE_PROP_BEEP2);
                //from slides, adding vibration unable to check as device does not support SDK 21
                Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                long[] tonePattern = {0, 300, 0, 300};
                v.vibrate(tonePattern, -1);


            }
        });


        Button threeButton = new Button (this);
        threeButton.setText("Three");
        threeButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                ToneGenerator tg = new ToneGenerator(AudioManager.STREAM_NOTIFICATION, 100);
                ToneGenerator tgs = new ToneGenerator(AudioManager.STREAM_NOTIFICATION, 0);
                // i am sure there is a better way of doing this, this is extremely redundant.

                tg.startTone(ToneGenerator.TONE_PROP_BEEP);
                for (int i = 0 ; i< 8 ; i++) {
                    tgs.startTone(ToneGenerator.TONE_PROP_BEEP2);
                }
                tg.startTone(ToneGenerator.TONE_PROP_BEEP);
                for (int i = 0 ; i< 8 ; i++) {
                    tgs.startTone(ToneGenerator.TONE_PROP_BEEP2);
                }
                tg.startTone(ToneGenerator.TONE_PROP_BEEP);

                //from slides, adding vibration unable to check as device does not support SDK 21
                Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                long[] tonePattern = {0, 300, 0, 300,0 ,300 };
                v.vibrate(tonePattern  ,-1 );


            }
        });

        //layout stuff
        LinearLayout myLayout = new LinearLayout(this);
        LinearLayout.LayoutParams buttonParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT , 1  );

        myLayout.setOrientation(LinearLayout.VERTICAL);

        oneButton.setLayoutParams( buttonParams );
        twoButton.setLayoutParams(buttonParams );
        threeButton.setLayoutParams(buttonParams );

        myLayout.addView(oneButton);
        myLayout.addView(twoButton);
        myLayout.addView(threeButton);

        setContentView(myLayout);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    //adding functionality for one tone
    public void playOneTone ( View id ){
        // from slides, creating tones and playing them

        ToneGenerator tg = new ToneGenerator(AudioManager.STREAM_NOTIFICATION, 100);
        tg.startTone(ToneGenerator.TONE_PROP_BEEP);


        //from slides, adding vibration unable to check as device does not support SDK 21

        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(300);


    }//adding functionality for two tone
    public void playTwoTone ( View id ){


        ToneGenerator tg = new ToneGenerator(AudioManager.STREAM_NOTIFICATION, 100);
        tg.startTone(ToneGenerator.TONE_PROP_BEEP2);


        //from slides, adding vibration unable to check as device does not support SDK 21
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long[] tonePattern = {0, 300, 0,300 };
        v.vibrate(tonePattern  ,-1 );




    }//adding functionality for three tone
    public void playThreeTone ( View id ){
        ToneGenerator tg = new ToneGenerator(AudioManager.STREAM_NOTIFICATION, 100);
        ToneGenerator tgs = new ToneGenerator(AudioManager.STREAM_NOTIFICATION, 0);
        // i am sure there is a better way of doing this, this is extremely redundant.

        tg.startTone(ToneGenerator.TONE_PROP_BEEP);
        for (int i = 0 ; i< 8 ; i++) {
            tgs.startTone(ToneGenerator.TONE_PROP_BEEP2);
        }
        tg.startTone(ToneGenerator.TONE_PROP_BEEP);
        for (int i = 0 ; i< 8 ; i++) {
            tgs.startTone(ToneGenerator.TONE_PROP_BEEP2);
        }
        tg.startTone(ToneGenerator.TONE_PROP_BEEP);

        //from slides, adding vibration unable to check as device does not support SDK 21
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long[] tonePattern = {0, 300, 0, 300,0 ,300 };
        v.vibrate(tonePattern  ,-1 );

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
