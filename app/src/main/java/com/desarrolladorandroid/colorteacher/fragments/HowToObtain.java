package com.desarrolladorandroid.colorteacher.fragments;

import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.desarrolladorandroid.colorteacher.R;

/**
 * Created by cosanchez on 17/03/2016.
 */
public class HowToObtain extends MasterFragment implements View.OnClickListener {
    private final int RED = 0;
    private final int YELLOW = 1;
    private final int BLUE = 2;
    ImageView red, blue, yellow, first, second, finale;
    int position = 0;
    ColorFilter baseColor;
    int position1;
    int position2;
    int[][] values;

    public HowToObtain() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        values = new int[][]{{ContextCompat.getColor(getContext(), R.color.red), ContextCompat.getColor(getContext(), R.color.orange), ContextCompat.getColor(getContext(), R.color.purple)},
                {ContextCompat.getColor(getContext(), R.color.orange), ContextCompat.getColor(getContext(), R.color.yellow), ContextCompat.getColor(getContext(), R.color.green)},
                {ContextCompat.getColor(getContext(), R.color.purple), ContextCompat.getColor(getContext(), R.color.green), ContextCompat.getColor(getContext(), R.color.blue)}};
        View view = inflater.inflate(R.layout.fragment_color_mixer, container, false);
        red = (ImageView) view.findViewById(R.id.red_circle);
        blue = (ImageView) view.findViewById(R.id.blue_circle);
        yellow = (ImageView) view.findViewById(R.id.yellow_circle);
        red.setOnClickListener(this);
        blue.setOnClickListener(this);
        yellow.setOnClickListener(this);
        first = (ImageView) view.findViewById(R.id.first_circle);
        second = (ImageView) view.findViewById(R.id.second_circle);
        finale = (ImageView) view.findViewById(R.id.final_circle);
        red.setColorFilter(ContextCompat.getColor(getContext(), R.color.red), PorterDuff.Mode.SRC_IN);
        blue.setColorFilter(ContextCompat.getColor(getContext(), R.color.blue), PorterDuff.Mode.SRC_IN);
        yellow.setColorFilter(ContextCompat.getColor(getContext(), R.color.yellow), PorterDuff.Mode.SRC_IN);
        baseColor = second.getColorFilter();
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.yellow_circle:
                savePosition(YELLOW);
                painter(ContextCompat.getColor(getContext(), R.color.yellow));
                break;
            case R.id.red_circle:
                savePosition(RED);
                painter(ContextCompat.getColor(getContext(), R.color.red));
                break;
            case R.id.blue_circle:
                savePosition(BLUE);
                painter(ContextCompat.getColor(getContext(), R.color.blue));
                break;
        }

    }

    private void savePosition(int color) {
        if (position == 0) {
            position1 = color;
        } else {
            position2 = color;
        }
    }

    private void painter(@ColorRes int color) {
        if (position == 0) {
            first.setColorFilter(color, PorterDuff.Mode.SRC_IN);
            second.setColorFilter(baseColor);
            finale.setColorFilter(baseColor);
            position = 1;
        } else {
            second.setColorFilter(color, PorterDuff.Mode.SRC_IN);
            finale.setColorFilter(getCombination(), PorterDuff.Mode.SRC_IN);
            position = 0;
        }
    }

    private
    @ColorRes
    int getCombination() {
        return values[position1][position2];

    }
}
