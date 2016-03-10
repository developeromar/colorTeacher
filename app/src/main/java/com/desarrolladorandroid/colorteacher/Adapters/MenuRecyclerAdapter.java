package com.desarrolladorandroid.colorteacher.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.desarrolladorandroid.colorteacher.BasicColors;
import com.desarrolladorandroid.colorteacher.R;
import com.desarrolladorandroid.colorteacher.databinding.ItemMainListBinding;
import com.desarrolladorandroid.colorteacher.utilities.MainListObject;
import com.desarrolladorandroid.colorteacher.utilities.TransitionHelper;

import java.util.List;

/**
 * Created by cosanchez on 08/03/2016.
 */
public class MenuRecyclerAdapter extends RecyclerView.Adapter<MenuRecyclerAdapter.MenuViewHolder> {
    private List<MainListObject> menus;
    private Activity activity;

    public MenuRecyclerAdapter(Activity activity, List<MainListObject> menus) {
        this.menus = menus;
        this.activity = activity;
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemMainListBinding binding = ItemMainListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MenuViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(final MenuViewHolder holder, int position) {
        final MainListObject mainListObject = menus.get(position);
        holder.binding.setObject(mainListObject);
        holder.binding.elementMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendViewTransition(BasicColors.class, holder, mainListObject);
            }
        });
    }

    private void sendViewTransition(Class target, MenuViewHolder holder, MainListObject mainListObject) {
        Intent i = new Intent(activity, target);
        i.putExtra("menu", mainListObject);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Pair<View, String>[] pairs = TransitionHelper.createSafeTransitionParticipants(activity, false,
                    new Pair<>(holder.binding.menuIcon, activity.getString(R.string.icon)
                    )
            );
            ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, pairs);
            activity.startActivity(i, transitionActivityOptions.toBundle());
        } else {
            activity.startActivity(i);
        }
    }

    @Override
    public int getItemCount() {
        return menus.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {
        ItemMainListBinding binding;

        public MenuViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }


}
