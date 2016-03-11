package com.desarrolladorandroid.colorteacher.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.desarrolladorandroid.colorteacher.R;

/**
 * Created by cosanchez on 10/03/2016.
 */
public class BasicColors extends MasterFragment {
    public BasicColors() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_basic_color, container, false);
        return view;
    }
}
