package com.zonkey;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.zonkey.saymyname.R;

public class StripperNameActivity extends AppCompatActivity {

    Spinner muppetSpinner;
    Spinner fastFoodSpinner;
    EditText petNameEditText;
    EditText grandparentEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stripper_name);
        petNameEditText = (EditText) findViewById(R.id.pet_name);
        grandparentEditText = (EditText) findViewById(R.id.grandparent_name);
//All of this is the muppet Spinner
        muppetSpinner = (Spinner) findViewById(R.id.muppet_name_spinner);
        openMuppetSpinnerAfterTextInput();
        ArrayAdapter<CharSequence> muppetAdapter = ArrayAdapter.createFromResource(this, R.array.muppets_array, R.layout.spinner_layout);
        muppetSpinner.setPrompt("Favorite Muppet");
        muppetSpinner.setFocusable(true);
        muppetSpinner.setFocusableInTouchMode(true);
        muppetSpinner.requestFocus();
        muppetAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        muppetSpinner.setAdapter(muppetAdapter);
//End of spinner stuff

// All of this is the fastfood Spinner
        fastFoodSpinner = (Spinner) findViewById(R.id.fast_food_spinner);
        openFastFoodSpinnerAfterTextInput();
        ArrayAdapter<CharSequence> fastFoodAdapter = ArrayAdapter.createFromResource(this, R.array.fast_food_array, R.layout.spinner_layout);
        fastFoodSpinner.setPrompt("Favorite Fast Food Entree");
        fastFoodSpinner.setFocusable(true);
        fastFoodSpinner.setFocusableInTouchMode(true);
        muppetSpinner.requestFocus();
        fastFoodAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fastFoodSpinner.setAdapter(fastFoodAdapter);
//End of spinner stuff
    }

    /**
     * this method sets some specifics for the next button only on the petNameEditText view
     */
    private void openMuppetSpinnerAfterTextInput() {
        petNameEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView petTextView, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    hideKeyboard();
                    petTextView.clearFocus();
                    muppetSpinner.requestFocus();
                    muppetSpinner.performClick();
                }
                return true;
            }
        });
    }

    /**
     * this method sets some specifics actions for the next button only on the petNameEditText view
     */
    private void openFastFoodSpinnerAfterTextInput() {
        grandparentEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    hideKeyboard();
                    textView.clearFocus();
                    fastFoodSpinner.requestFocus();
                    fastFoodSpinner.performClick();
                }
                return true;
            }
        });
    }

    /**
     * This method hides the keyboard when the system focuses on the spinners
     */
    private void hideKeyboard() {
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }

    /**
     * this method is called when the traditional button is pressed
     *
     * @param view
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void generateTraditionalName(View view) {

        Bundle bundle = ActivityOptions
                .makeSceneTransitionAnimation(this)
                .toBundle();
        EditText petText = (EditText) findViewById(R.id.pet_name);
        EditText streetText = (EditText) findViewById(R.id.street_name);
        String stripperName = petText.getText().toString() + " " + streetText.getText().toString();
        Intent completedNameIntent;
        completedNameIntent = new Intent(this, CompletedNameActivity.class);
        completedNameIntent.putExtra("finalStripperName", stripperName);
        startActivity(completedNameIntent, bundle);

    }

    /**
     * this method is called when the Freaky button is pressed
     *
     * @param view
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void generateFreakyName(View view) {

        Bundle bundle = ActivityOptions
                .makeSceneTransitionAnimation(this)
                .toBundle();
        Spinner muppetSpinner = (Spinner) findViewById(R.id.muppet_name_spinner);
        EditText iceCreamText = (EditText) findViewById(R.id.ice_cream);
        String stripperName = muppetSpinner.getSelectedItem().toString() + " " + iceCreamText.getText().toString();
//        Toast.makeText(this, "Your stripper name is " + stripperName, Toast.LENGTH_LONG).show();
        Intent completedNameIntent;
        completedNameIntent = new Intent(this, CompletedNameActivity.class);
        completedNameIntent.putExtra("finalStripperName", stripperName);
        startActivity(completedNameIntent, bundle);
    }

    /**
     * this method is called when the American button is pressed
     *
     * @param view
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void generateAmericanName(View view) {

        Bundle bundle = ActivityOptions
                .makeSceneTransitionAnimation(this)
                .toBundle();
        Spinner fastFoodSpinner = (Spinner) findViewById(R.id.fast_food_spinner);
        EditText grandParentText = (EditText) findViewById(R.id.grandparent_name);
        String stripperName = fastFoodSpinner.getSelectedItem().toString() + " " + grandParentText.getText().toString();
//        Toast.makeText(this, "Your stripper name is " + stripperName, Toast.LENGTH_LONG).show();
        Intent completedNameIntent;
        completedNameIntent = new Intent(this, CompletedNameActivity.class);
        completedNameIntent.putExtra("finalStripperName", stripperName);
        startActivity(completedNameIntent, bundle);
    }
}
