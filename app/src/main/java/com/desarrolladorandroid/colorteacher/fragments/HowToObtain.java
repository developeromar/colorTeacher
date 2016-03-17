package com.desarrolladorandroid.colorteacher.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.desarrolladorandroid.colorteacher.R;

/**
 * Created by cosanchez on 17/03/2016.
 */
public class HowToObtain extends MasterFragment implements View.OnClickListener {
    public HowToObtain() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_how_to_obtain, container, false);
        return view;
    }

    @Override
    public void onClick(View v) {

    }
}
