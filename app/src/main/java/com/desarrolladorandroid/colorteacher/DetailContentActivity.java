package com.desarrolladorandroid.colorteacher;

import android.annotation.TargetApi;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.view.Window;
import android.view.WindowManager;

import com.desarrolladorandroid.colorteacher.databinding.ActivityContentBinding;
import com.desarrolladorandroid.colorteacher.fragments.BasicColorName;
import com.desarrolladorandroid.colorteacher.fragments.BasicColors;
import com.desarrolladorandroid.colorteacher.fragments.ColorMixer;
import com.desarrolladorandroid.colorteacher.fragments.HowToObtain;
import com.desarrolladorandroid.colorteacher.fragments.MasterFragment;
import com.desarrolladorandroid.colorteacher.fragments.SecundaryColorsNames;
import com.desarrolladorandroid.colorteacher.utilities.MainListObject;

public class DetailContentActivity extends AppCompatActivity {
    MainListObject menu;
    private int color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupWindowAnimations();
        menu = (MainListObject) getIntent().getExtras().getSerializable("menu");
        ActivityContentBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_content);
        binding.setObject(menu);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            entrace();
        }
        if (savedInstanceState == null)
            startAnimationFragment(getFragmentFromData());
        setSupportActionBar(binding.tbdetail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void entrace() {
        Window window = getWindow();
        window.getEnterTransition().setDuration(getResources().getInteger(R.integer.anim_duration_long));
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(menu.getColorStatus());

    }

    private void startAnimationFragment(MasterFragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_detail, fragment)
                .commit();
    }

    public MasterFragment getFragmentFromData() {
        switch (menu.getFragment()) {
            case 0:
                color = menu.getColor();
                return new BasicColors();
            case 1:
                color = menu.getColor();
                return new BasicColorName();
            case 2:
                color = menu.getColor();
                return new ColorMixer();
            case 3:
                color = menu.getColor();
                return new SecundaryColorsNames();
            case 4:
                color = menu.getColor();
                return new HowToObtain();
            default:
                return new BasicColors();
        }
    }

    protected void setupWindowAnimations() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Fade fade = new Fade();
            fade.setDuration(getResources().getInteger(R.integer.anim_duration_long));
            getWindow().setReenterTransition(fade);
            getWindow().setEnterTransition(fade);
        }
    }

    public int getColorBar() {
        return color;
    }
    /*
            MasterFragment fragment = getFragmentFromData();
/*
        Slide slideTransition = new Slide(Gravity.RIGHT);
        slideTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));

        fragment.setEnterTransition(slideTransition);
        fragment.setReenterTransition(slideTransition);
        fragment.setExitTransition(slideTransition);
       // fragment.setSharedElementEnterTransition(new ChangeBounds());
    startAnimationFragment(fragment);*/
}
