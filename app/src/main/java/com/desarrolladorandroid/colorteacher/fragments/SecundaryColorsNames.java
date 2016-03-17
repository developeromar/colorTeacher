package com.desarrolladorandroid.colorteacher.fragments;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.desarrolladorandroid.colorteacher.DetailContentActivity;
import com.desarrolladorandroid.colorteacher.R;

/**
 * Created by cosanchez on 17/03/2016.
 */
public class SecundaryColorsNames extends MasterFragment implements View.OnClickListener {
    ImageView orange, purple, green;
    TextView name, awnser;
    statusColor[] colors;
    int count;
    FloatingActionButton floatingActionButton;

    public SecundaryColorsNames() {
        this.count = 0;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_basic_color_name, container, false);
        floatingActionButton = (FloatingActionButton) view.findViewById(R.id.next);
        orange = (ImageView) view.findViewById(R.id.red_circle);
        purple = (ImageView) view.findViewById(R.id.blue_circle);
        green = (ImageView) view.findViewById(R.id.yellow_circle);
        name = (TextView) view.findViewById(R.id.name);
        awnser = (TextView) view.findViewById(R.id.awnser);
        orange.setColorFilter(ContextCompat.getColor(getContext(), R.color.orange), PorterDuff.Mode.SRC_IN);
        purple.setColorFilter(ContextCompat.getColor(getContext(), R.color.purple), PorterDuff.Mode.SRC_IN);
        green.setColorFilter(ContextCompat.getColor(getContext(), R.color.green), PorterDuff.Mode.SRC_IN);
        orange.setOnClickListener(this);
        purple.setOnClickListener(this);
        green.setOnClickListener(this);
        this.colors = new statusColor[3];
        this.colors[0] = new statusColor(getString(R.string.orange));
        this.colors[1] = new statusColor(getString(R.string.purple));
        this.colors[2] = new statusColor(getString(R.string.green));
        if (savedInstanceState == null)
            generateRandomNameColor();
        else {
            name.setText(savedInstanceState.getString("name"));
            awnser.setText(savedInstanceState.getString("awnser"));
        }
        return view;
    }

    public void generateRandomNameColor() {
        Boolean flag = true;
        int value = 0;
        int value2 = 1;

        while (flag) {
            if (count >= 6) {
                count = 0;
                value = 0;
                value2 = 1;
            }
            if (count >= 3) {
                value = 1;
                value2 = 0;
            }
            statusColor s = colors[((int) (Math.random() * 3))];
            if (s.getStatus() == value) {
                name.setText(s.getName());
                s.setStatus(value2);
                count++;
                flag = false;
            }


        }
        if (count > 3) {
            floatingActionButton.setVisibility(View.VISIBLE);
            floatingActionButton.setBackgroundTintList(ColorStateList.valueOf(((DetailContentActivity) getActivity()).getColorBar()));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("name", (String) name.getText());
        outState.putString("awnser", awnser.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.red_circle:
                if (name.getText().equals(colors[0].getName())) {
                    awnser.setText(getString(R.string.succes));
                    generateRandomNameColor();
                } else {
                    awnser.setText(getString(R.string.wrong));
                }
                break;
            case R.id.blue_circle:
                if (name.getText().equals(colors[1].getName())) {
                    awnser.setText(getString(R.string.succes));
                    generateRandomNameColor();
                } else {
                    awnser.setText(getString(R.string.wrong));
                }
                break;
            case R.id.yellow_circle:
                if (name.getText().equals(colors[2].getName())) {
                    awnser.setText(getString(R.string.succes));
                    generateRandomNameColor();
                } else {
                    awnser.setText(getString(R.string.wrong));
                }
                break;
        }

    }

    public class statusColor {
        String name;
        int status;

        public statusColor(String name) {
            this.name = name;
            this.status = 0;

        }

        public String getName() {
            return name;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

    }
}
