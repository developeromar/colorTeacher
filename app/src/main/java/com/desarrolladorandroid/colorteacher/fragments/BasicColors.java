package com.desarrolladorandroid.colorteacher.fragments;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.desarrolladorandroid.colorteacher.R;

/**
 * Created by cosanchez on 10/03/2016.
 */
public class BasicColors extends MasterFragment implements RadioGroup.OnCheckedChangeListener {
    ImageView image;
    ImageView shadow;
    RadioGroup radioGroup;

    public BasicColors() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_basic_color, container, false);
        image = (ImageView) view.findViewById(R.id.cicle_basic);
        shadow = (ImageView) view.findViewById(R.id.cicle_basic_shadow);
        shadow.setColorFilter(ContextCompat.getColor(getContext(), R.color.colorDivider), PorterDuff.Mode.SRC_IN);
        radioGroup = (RadioGroup) view.findViewById(R.id.radio_colors);
        radioGroup.setOnCheckedChangeListener(this);

        return view;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_yellow:
                image.setColorFilter(ContextCompat.getColor(getContext(), R.color.yellow), PorterDuff.Mode.SRC_IN);
                break;
            case R.id.rb_blue:
                image.setColorFilter(ContextCompat.getColor(getContext(), R.color.blue), PorterDuff.Mode.SRC_IN);
                break;
            case R.id.rb_red:
                image.setColorFilter(ContextCompat.getColor(getContext(), R.color.red), PorterDuff.Mode.SRC_IN);
                break;
        }

    }
}
