package com.desarrolladorandroid.colorteacher;

import android.annotation.TargetApi;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.desarrolladorandroid.colorteacher.utilities.MainListObject;

public class BasicColors extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_colors);
        MainListObject menu = (MainListObject) getIntent().getExtras().getSerializable("menu");
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setColorFilter(menu.getColor(), PorterDuff.Mode.SRC_IN);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            entrace();

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void entrace() {
        getWindow().getEnterTransition().setDuration(getResources().getInteger(R.integer.anim_duration_long));
    }
}
