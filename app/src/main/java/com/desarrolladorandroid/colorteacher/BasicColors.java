package com.desarrolladorandroid.colorteacher;

import android.annotation.TargetApi;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.desarrolladorandroid.colorteacher.databinding.ActivityBasicColorsBinding;
import com.desarrolladorandroid.colorteacher.utilities.MainListObject;

public class BasicColors extends AppCompatActivity {
    MainListObject menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        menu = (MainListObject) getIntent().getExtras().getSerializable("menu");
        ActivityBasicColorsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_basic_colors);
        binding.setObject(menu);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            entrace();
        }

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void entrace() {
        Window window = getWindow();
        window.getEnterTransition().setDuration(getResources().getInteger(R.integer.anim_duration_long));
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(menu.getColorStatus());

    }
}
