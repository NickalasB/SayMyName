package com.zonkey;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.zonkey.saymyname.R;

public class StripperNameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stripper_name);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
        EditText muppetText = (EditText) findViewById(R.id.muppet_name);
        EditText iceCreamText = (EditText)findViewById(R.id.ice_cream);
        String stripperName = muppetText.getText().toString() + " " + iceCreamText.getText().toString();
        Toast.makeText(this, "Your stripper name is " + stripperName, Toast.LENGTH_LONG).show();

    }

    /**
     * this method is called when the American button is pressed
     * @param view
     */
    public void generateAmericanName (View view){
        EditText fastFoodText = (EditText)findViewById(R.id.fast_food);
        EditText grandParentText = (EditText)findViewById(R.id.grandparent_name);
        String stripperName = fastFoodText.getText().toString() + " " + grandParentText.getText().toString();
        Toast.makeText(this, "Your stripper name is " + stripperName, Toast.LENGTH_LONG).show();

    }
}
