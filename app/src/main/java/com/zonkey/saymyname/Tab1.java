package com.zonkey.saymyname;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;


/**
 * A placeholder fragment containing a simple view.
 */
public class Tab1 extends Fragment {

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    public ImageView genderImage1;
    public Switch genderSwitch;


    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static Tab1 newInstance(int sectionNumber) {
        Tab1 fragment = new Tab1();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.tab_1, container, false);
        genderImage1 = (ImageView) rootView.findViewById(R.id.genericStripperImage);
        //updates image from shared preferences
        updateGenderImage();
        genderSwitch = (Switch) rootView.findViewById(R.id.gender_switch);
        //updates state of the switch to match image from shared preferences
        updateGenderSwitch();

        genderSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //recall the image and the state of the switch from custom class for shared preferences
                GenderPicker.setChickMode(isChecked, getActivity());
                GenderPicker.setChickChecked(isChecked, getActivity());
                updateGenderImage();
                updateGenderSwitch();

            }
        });
        return rootView;
    }

    /**
     * this method sets the image the user sees on this view recalled from shared preferences
     */
    protected void updateGenderImage() {
        if (GenderPicker.isInChickMode(getActivity()))
            genderImage1.setImageResource(R.drawable.fatlady);
        else genderImage1.setImageResource(R.drawable.fatguy);
    }


    /**
     * this method sets the Switch to checked or not based on the user's image selection from shared preferences
     */
    protected void updateGenderSwitch(){
        if (GenderPicker.isChickChecked(getActivity()))
                genderSwitch.setChecked(true);
        else genderSwitch.setChecked(false);

    }

}
