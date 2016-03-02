package com.zonkey;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.zonkey.saymyname.R;

public class StripperNameActivity extends AppCompatActivity {

 //The Spinners
    Spinner muppetSpinner;
    Spinner fastFoodSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stripper_name);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.collapseActionView();

//All of this is the muppet Spinner
        muppetSpinner = (Spinner) findViewById(R.id.muppet_name_spinner);
        ArrayAdapter<CharSequence> muppetAdapter = ArrayAdapter.createFromResource(this, R.array.muppets_array, R.layout.spinner_layout);
        muppetSpinner.setPrompt("Favorite Muppet");
        muppetAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        muppetSpinner.setAdapter(muppetAdapter);
//End of spinner stuff

// All of this is the fastfood Spinner
        fastFoodSpinner = (Spinner) findViewById(R.id.fast_food_spinner);
        ArrayAdapter<CharSequence> fastFoodAdapter = ArrayAdapter.createFromResource(this, R.array.fast_food_array, R.layout.spinner_layout);
        fastFoodSpinner.setPrompt("Favorite Fast Food Entree");
        fastFoodAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fastFoodSpinner.setAdapter(fastFoodAdapter);
//End of spinner stuff

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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




    /**
     * this method is called when the traditional button is pressed
     * @param view
     */

    public void generateTraditionalName (View view){
        EditText petText = (EditText) findViewById(R.id.pet_name);
        EditText streetText = (EditText)findViewById(R.id.street_name);
        String stripperName = petText.getText().toString() + " " + streetText.getText().toString();
        Toast.makeText(this, "Your stripper name is " + stripperName, Toast.LENGTH_LONG).show();

    }
    /**
     * this method is called when the twisted button is pressed
     * @param view
     */
    public void generateTwistedName (View view){
        Spinner muppetSpinner = (Spinner) findViewById(R.id.muppet_name_spinner);
        EditText iceCreamText = (EditText)findViewById(R.id.ice_cream);
        String stripperName = muppetSpinner.getSelectedItem().toString() + " " + iceCreamText.getText().toString();
        Toast.makeText(this, "Your stripper name is " + stripperName, Toast.LENGTH_LONG).show();

    }

    /**
     * this method is called when the American button is pressed
     * @param view
     */
    public void generateAmericanName (View view){
        Spinner fastFoodSpinner = (Spinner) findViewById(R.id.fast_food_spinner);
        EditText grandParentText = (EditText)findViewById(R.id.grandparent_name);
        String stripperName = fastFoodSpinner.getSelectedItem().toString() + " " + grandParentText.getText().toString();
        Toast.makeText(this, "Your stripper name is " + stripperName, Toast.LENGTH_LONG).show();

    }
}
