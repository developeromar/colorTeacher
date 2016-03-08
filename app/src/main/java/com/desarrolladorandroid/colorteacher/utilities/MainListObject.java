package com.desarrolladorandroid.colorteacher.utilities;

import android.databinding.BindingAdapter;
import android.graphics.PorterDuff;
import android.support.annotation.ColorRes;
import android.widget.ImageView;

import java.io.Serializable;

/**
 * Created by cosanchez on 08/03/2016.
 */
public class MainListObject implements Serializable {
    int color;
    String name;

    public MainListObject(@ColorRes int color, String name) {
        this.color = color;
        this.name = name;
    }

    @BindingAdapter("bind:colorTint")
    public static void setColorTint(ImageView view, @ColorRes int color) {
        //DrawableCompat.setTint(view.getDrawable(), color);
        view.setColorFilter(color, PorterDuff.Mode.SRC_IN);
    }

    public String getName() {
        return name;
    }

    public int getColor() {
        return color;
    }
}
