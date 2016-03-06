package com.zonkey;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.zonkey.saymyname.R;

public class CompletedNameActivity extends AppCompatActivity {

    /**
     *
     * all of this handles getting the extra string from the StripperNameActivity and also does some rudimentary animation
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_name);
        TextView completedNameTextView1 = (TextView)findViewById(R.id.completed_name_textview1);
        TextView completedNameTextView2 = (TextView)findViewById(R.id.completed_name_text_view2);
        completedNameTextView1.setText(getString(R.string.your_name_is_string));
        completedNameTextView1.startAnimation(AnimationUtils.loadAnimation(CompletedNameActivity.this, android.R.anim.fade_in));
        Intent completedNameIntent = getIntent();
        if (completedNameIntent.hasExtra("finalStripperName")){
            completedNameTextView2.setText(getIntent().getStringExtra("finalStripperName") + "!!!");
        }
        completedNameTextView2.startAnimation(AnimationUtils.loadAnimation(CompletedNameActivity.this, android.R.anim.fade_in));



    }

}

