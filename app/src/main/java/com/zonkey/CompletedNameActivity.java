package com.zonkey;

import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zonkey.saymyname.GenderPicker;
import com.zonkey.saymyname.R;

public class CompletedNameActivity extends AppCompatActivity {

    MediaPlayer whistleSound;
    ImageView genderImage1;

    /**
     * all of this handles getting the extra string from the StripperNameActivity and also does some rudimentary animation
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_name);
        //Declares the imageView and then uses the UpdateGenderImage to determine User's preference
        genderImage1 = (ImageView) findViewById(R.id.genericStripperImage);
        updateGenderImage();

        whistleSound = MediaPlayer.create(this, R.raw.whistle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.collapseActionView();
        //
        final TextView completedNameTextView1 = (TextView) findViewById(R.id.completed_name_textview1);
        final TextView completedNameTextView2 = (TextView) findViewById(R.id.completed_name_text_view2);
        completedNameTextView1.setText(getString(R.string.your_name_is_string));

        //This sets up the floating action share button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.share_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String emailSubject = getString(R.string.share_subject_string);
                String stringToShare = getText(R.string.my_name_is_string) + " " + completedNameTextView2.getText().toString()
                        + getText(R.string.how_hot_string) + getText(R.string.find_out_string);
                sharingIntent.putExtra(Intent.EXTRA_TEXT, stringToShare);
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
                startActivity(Intent.createChooser(sharingIntent, "Share your stripper name"));
            }
        });

        //This gives us the screen width in pixels
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        //before animate this sets the view to the left of the screen by the width of the current screen
        completedNameTextView1.setTranslationX(-displayMetrics.widthPixels);

        //sets how long it will take for the first animation to complete
        completedNameTextView1.post(new Runnable() {
            @Override
            public void run() {
                completedNameTextView1.animate().translationX(0f).setDuration(1000).start();

            }
        });

        //this handler and runnable delays the 2nd TextView from showing on the screen until the first animation is complete
        final Handler textView2Handler = new Handler();
        Runnable textView2Runnable = new Runnable() {
            public void run() {
                //this gets the extra of the previous activity to put the actual stripper name on the screen
                //This is where the magic happens
                Intent completedNameIntent = getIntent();
                if (completedNameIntent.hasExtra("finalStripperName")) {
                    completedNameTextView2.setText(getIntent().getStringExtra("finalStripperName") + "!!!");
                }
            }
        };
        textView2Handler.postDelayed(textView2Runnable, 1250);

        //this hanlder and runnable delays the whistle sound from running until the 2nd animation starts
        final Handler mediaPlayerHandler = new Handler();
        Runnable mediaPlayerRunnable = new Runnable() {
            @Override
            public void run() {
                //this plays the sound at the same time the 2nd view
                whistleSound.start();
            }
        };
        mediaPlayerHandler.postDelayed(mediaPlayerRunnable, 1250);


        //This handles the flashing of the 2nd Textview between visible (1f) and not visible(0f)
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(1f, 0f);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                completedNameTextView2.setAlpha((Float) animation.getAnimatedValue());
            }
        });
        valueAnimator.setDuration(250).setRepeatCount(5);
        valueAnimator.setStartDelay(1250);
        valueAnimator.start();
        //This line is important because it defines that the animation ends on a floatValue of 1f(visible)
        valueAnimator.setFloatValues(1f);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        ImageView genderImage = (ImageView) findViewById(R.id.genericStripperImage);
        switch (item.getItemId()) {
            case R.id.dude_theme:
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                genderImage.setImageResource(R.drawable.muscle_man);
                return true;
            case R.id.chick_theme:
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                genderImage.setImageResource(R.drawable.skinnylady);
                return true;
            case R.id.about_developer:
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(false);
                new AlertDialog.Builder(this)
                        .setTitle(getString(R.string.about_developer_string))
                        .setMessage(getString(R.string.about_dev_dialog_text))
                        .show();
                return true;
            default:
                super.onOptionsItemSelected(item);
        }
        return true;

    }

    /**
     * this method recalls the shared preferences for the ImageView the user defines in Tab1
     */
    protected void updateGenderImage() {
        if (GenderPicker.isInChickMode(this))
            genderImage1.setImageResource(R.drawable.skinnylady);
        else genderImage1.setImageResource(R.drawable.muscle_man);

    }


}

