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

    private ImageView genderImage;
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

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
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.tab_1, container, false);
        genderImage = (ImageView)rootView.findViewById(R.id.stripperPicImageView);
        Switch genderSwitch = (Switch)rootView.findViewById(R.id.gender_switch);
        genderSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                genderImage.setImageResource(isChecked ? R.drawable.skinnylady : R.drawable.fatguy);
            }
        });


        return rootView;
    }

}
