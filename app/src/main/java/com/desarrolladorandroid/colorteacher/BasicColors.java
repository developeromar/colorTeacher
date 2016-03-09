package com.desarrolladorandroid.colorteacher;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.desarrolladorandroid.colorteacher.utilities.MainListObject;

public class BasicColors extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_colors);
        MainListObject menu = (MainListObject) getIntent().getExtras().getSerializable("menu");
    }
}
