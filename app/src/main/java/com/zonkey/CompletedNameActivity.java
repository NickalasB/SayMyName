package com.zonkey;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.zonkey.saymyname.R;

public class CompletedNameActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_name);
        TextView completedNameTextView = (TextView)findViewById(R.id.final_name_text_view);
        Intent completedNameIntent = getIntent();
        if (completedNameIntent.hasExtra("finalStripperName")){
            completedNameTextView.setText(getIntent().getStringExtra("finalStripperName"));
        }



    }

}

