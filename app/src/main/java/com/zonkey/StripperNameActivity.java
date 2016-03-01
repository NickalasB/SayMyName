package com.zonkey;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
        String stripperName = getString(R.string.pet_name) + getString(R.string.pet_name);
        Toast.makeText(this, "Your stripper name is " + stripperName, Toast.LENGTH_LONG).show();

    }

    /**
     * this method is called when the twisted button is pressed
     * @param view
     */
    public void generateTwistedName (View view){
        String stripperName = getString(R.string.muppet_name) + getString(R.string.ice_cream);
        Toast.makeText(this, "Your stripper name is " + stripperName, Toast.LENGTH_LONG).show();

    }

    /**
     * this method is called when the American button is pressed
     * @param view
     */
    public void generateAmericanName (View view){
        String stripperName = getString(R.string.fast_food) + getString(R.string.grandparent_name);
        Toast.makeText(this, "Your stripper name is " + stripperName, Toast.LENGTH_LONG).show();

    }
}
