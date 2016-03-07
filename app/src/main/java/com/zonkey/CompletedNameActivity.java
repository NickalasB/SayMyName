package com.zonkey;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.TextView;

import com.zonkey.saymyname.R;

public class CompletedNameActivity extends AppCompatActivity {

    /**
     * all of this handles getting the extra string from the StripperNameActivity and also does some rudimentary animation
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_name);
        final TextView completedNameTextView1 = (TextView) findViewById(R.id.completed_name_textview1);
        final TextView completedNameTextView2 = (TextView) findViewById(R.id.completed_name_text_view2);
        completedNameTextView1.setText(getString(R.string.your_name_is_string));

        //This gives us the screen width in pixels
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        //before animate this sets the view to the left of the screen by the width of the current screen
        completedNameTextView1.setTranslationX(-displayMetrics.widthPixels);

        //delays the animation
        completedNameTextView1.post(new Runnable() {
            @Override
            public void run() {
                completedNameTextView1.animate().translationX(0f).setDuration(1000).start();

            }
        });

        Intent completedNameIntent = getIntent();
        if (completedNameIntent.hasExtra("finalStripperName")) {
            completedNameTextView2.setText(getIntent().getStringExtra("finalStripperName") + "!!!");
        }

        //This starts the view as not visible
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f,1f);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                completedNameTextView2.setAlpha((Float) animation.getAnimatedValue());
            }
        });

        completedNameTextView2.post(new Runnable() {
            @Override
            public void run() {
                completedNameTextView1.animate().translationX(0f).setDuration(1000).start();

            }
        });
        valueAnimator.setDuration(250).setRepeatCount(9);
        valueAnimator.start();
    }

}

