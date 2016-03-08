package com.desarrolladorandroid.colorteacher.Adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.desarrolladorandroid.colorteacher.databinding.ItemMainListBinding;
import com.desarrolladorandroid.colorteacher.utilities.MainListObject;

import java.util.List;

/**
 * Created by cosanchez on 08/03/2016.
 */
public class MenuRecyclerAdapter extends RecyclerView.Adapter<MenuRecyclerAdapter.MenuViewHolder> {
    private List<MainListObject> menus;

    public MenuRecyclerAdapter(List<MainListObject> menus) {
        this.menus = menus;
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemMainListBinding binding = ItemMainListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MenuViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        MainListObject mainListObject = menus.get(position);
        holder.binding.setObject(mainListObject);
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
