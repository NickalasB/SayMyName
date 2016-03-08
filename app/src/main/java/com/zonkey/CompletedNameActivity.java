package com.zonkey;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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

        //delays the first animation
        completedNameTextView1.post(new Runnable() {
            @Override
            public void run() {
                completedNameTextView1.animate().translationX(0f).setDuration(1000).start();

            }
        });


        //this handler delays the 2nd textview from showing on the screen
        final Handler textView2Handler = new Handler();
        Runnable textView2Runnable = new Runnable() {
            public void run() {
                //this gets the extra of the previous activity to put the actual stripper name on the screen
                Intent completedNameIntent = getIntent();
                if (completedNameIntent.hasExtra("finalStripperName")) {
                    completedNameTextView2.setText(getIntent().getStringExtra("finalStripperName") + "!!!");
                }
            }
        };
        textView2Handler.postDelayed(textView2Runnable, 1250);


        //This handles the animation of the 2nd textview
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


}

